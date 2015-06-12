namespace std
{
  /**
   *  @brief  Part of RTTI.
   *
   *  The @c type_info class describes type information generated by
   *  an implementation.
  */
  class type_info
  {
  protected:
    const char *__name;

  protected:
    explicit type_info(const char *__n): __name(__n) { }

  public:
    // the public interface
    /** Returns an @e implementation-defined byte string; this is not
     *  portable between compilers!  */
    const char* name() const
    { return __name; }
  };
}