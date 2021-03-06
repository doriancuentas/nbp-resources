/*
 * Copyright 2008 by Emeric Vernat
 *
 *     This file is part of Dead Code Detector.
 *
 * Dead Code Detector is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dead Code Detector is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Dead Code Detector.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.netbeans.dcd;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * Impl�mentation de l'interface ClassVisitor d'ASM utilis�e lors de l'indexation
 * (parcours des classes pour lister les m�thodes et les attributs
 * appelables soit en mode public, soit en mode priv�).
 * @author evernat
 */
class CalledClassVisitor extends ClassVisitor {
	private static final int OPCODE_CLASS_FILTERED = Opcodes.ACC_INTERFACE | Opcodes.ACC_ANNOTATION;
	private static final int OPCODE_PUBLIC_METHOD = Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED;
	private static final int OPCODE_PUBLIC_METHOD_FILTERED = OPCODE_PUBLIC_METHOD
			| Opcodes.ACC_ABSTRACT | Opcodes.ACC_SYNTHETIC;
	private static final int OPCODE_PRIVATE_METHOD_FILTERED = Opcodes.ACC_PRIVATE
			| Opcodes.ACC_ABSTRACT | Opcodes.ACC_SYNTHETIC;
	private static final int OPCODE_DEFAULT_CONSTRUCTOR_FILTERED = Opcodes.ACC_PUBLIC
			| Opcodes.ACC_PRIVATE | Opcodes.ACC_SYNTHETIC;
	private static final int OPCODE_FIELD_INLINEABLE = Opcodes.ACC_FINAL | Opcodes.ACC_STATIC;
	// voir http://java.sun.com/javase/6/docs/platform/serialization/spec/serialTOC.html pour read/write*,
	// values() et valueOf(String) pour les enum
	// (m�thodes non synth�tiques malheureusement conform�ment � la spec),
	// getPort et setEndpointAddress pour les services web
	// (getPort pourrait �tre �vit� avec jaxrpc dans classpath et setEndpointAddress pour axis)
	private static final Set<String> IGNORED_METHODS = Collections
			.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "<clinit>", "main",
					"readResolve", "readObject", "readExternal", "writeObject", "writeExternal",
					"writeReplace", "values", "valueOf", "getPort", "setEndpointAddress", })));
	private Set<String> methods;
	private Set<String> fields;
	private final boolean publicIndexation;

	CalledClassVisitor(Set<String> methods, Set<String> fields, boolean publicIndexation) {
		super(Opcodes.ASM4);
		this.methods = methods;
		this.fields = fields;
		this.publicIndexation = publicIndexation;
	}

	private boolean isClassFiltered(int asmAccess) {
		return (asmAccess & OPCODE_CLASS_FILTERED) != 0;
	}

	private boolean isMethodFiltered(int asmAccess) {
		// si mode private, on filtre public et abstract/synth�tic,
		// si mode public, on filtre private, abstract/synth�tic
		//    et ce qui n'est pas non plus public ou protected (car package-private n'a pas d'opcode)
		return !publicIndexation
				&& (asmAccess & OPCODE_PUBLIC_METHOD_FILTERED) != 0
				|| publicIndexation
				&& ((asmAccess & OPCODE_PRIVATE_METHOD_FILTERED) != 0 || (asmAccess & OPCODE_PUBLIC_METHOD) == 0);
	}

	private boolean isDefaultConstructorFiltered(int access, String name, String desc) {
		return (access & OPCODE_DEFAULT_CONSTRUCTOR_FILTERED) != 0 && "<init>".equals(name)
				&& "()V".equals(desc);
	}

	private boolean isPublicAccessorFiltered(int access, String name, String desc) {
		// getter public sans param�tre ou setter public avec un param�tre
		return (access & Opcodes.ACC_PUBLIC) != 0 && (isGetter(name, desc) || isSetter(name, desc));
	}

	private boolean isGetter(String name, String desc) {
		return name.startsWith("get") && desc.startsWith("()")
				&& Type.getReturnType(desc) != Type.VOID_TYPE || name.startsWith("is")
				&& desc.startsWith("()") && Type.getReturnType(desc) == Type.BOOLEAN_TYPE;
	}

	private boolean isSetter(String name, String desc) {
		return name.startsWith("set") && Type.getReturnType(desc) == Type.VOID_TYPE
				&& Type.getArgumentTypes(desc).length == 1;
	}

	private boolean isFieldInlineable(int access, String desc) {
		if ((access & OPCODE_FIELD_INLINEABLE) != 0) {
			final Type type = Type.getType(desc);
			return type.getSort() != Type.OBJECT || "java.lang.String".equals(type.getClassName());
		}
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public void visit(int version, int access, String name, String signature, String superName,
			String[] interfaces) {
		//log(name + " extends " + superName + " {");
		if (isClassFiltered(access)) {
			// les annotations et les interfaces n'appellent pas de m�thodes (ou d'attributs) :
			// on ignore la visite de cette classe
			methods = null;
			fields = null;
		}
	}

	/** {@inheritDoc} */
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature,
			String[] exceptions) {
		// m�thode filtr�e si c'est une m�thode abstract ou selon la visibilit�
		// ou s'il s'agit de m�thodes sp�ciales (<clinit>, main, readResolve, enum valueOf ...)
		// ou s'il s'agit de getter/setter public (souvent appel�s par r�flexion, par exemple par tag jsp, par spring ou jpa)
		// et on filtre les constructeurs sans param�tes car :
		// - les classes utilitaires ont des constructeurs priv�s non utilis�s
		// - ou il y a un constructeur public par d�faut (pour Class#newInstance ou pour PMD)
		// - ou le constructeur a �t� g�n�r� par le compilateur
		if (methods != null && !isMethodFiltered(access)
				&& !isDefaultConstructorFiltered(access, name, desc)
				&& !isPublicAccessorFiltered(access, name, desc) && !IGNORED_METHODS.contains(name)) {
			methods.add(DcdHelper.getMethodKey(name, desc));
		}
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature,
			Object value) {
		//log(" " + desc + " " + name);
		// attribut filtr� selon visibilit� et si pas inlineable (constantes int, String...)
		if (fields != null && !isMethodFiltered(access) && !isFieldInlineable(access, desc)) {
			fields.add(DcdHelper.getMethodKey(name, desc));
		}
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void visitSource(String source, String debug) {
		// rien
	}

	/** {@inheritDoc} */
	@Override
	public void visitOuterClass(String owner, String name, String desc) {
		// rien
	}

	/** {@inheritDoc} */
	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void visitAttribute(Attribute attr) {
		// rien
	}

	/** {@inheritDoc} */
	@Override
	public void visitInnerClass(String name, String outerName, String innerName, int access) {
		// rien
	}

	/** {@inheritDoc} */
	@Override
	public void visitEnd() {
		//log("}");
	}
}
