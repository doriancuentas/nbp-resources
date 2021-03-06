package org.netbeans.modules.cnd.antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.antlr.org/license.html
 */

/** A TreeElement is a block with one alternative and a root node */
class TreeElement extends AlternativeBlock {
    GrammarAtom root;

    public TreeElement(Grammar g, Token start) {
        super(g, start, false);
    }

    public void generate(Context context) {
        grammar.generator.gen(this, context);
    }

    public Lookahead look(int k) {
        return grammar.theLLkAnalyzer.look(k, this);
    }

    public String toString() {
        String s = " #(" + root;
        Alternative a = (Alternative)alternatives.elementAt(0);
        AlternativeElement p = a.head;
        while (p != null) {
            s += p;
            p = p.next;
        }
        return s + " )";
    }
}
