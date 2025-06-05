public class S34380 {
  public void method() {
    MethodCurrier mc = new MethodCurrier();
    mc.setValue(12);
    mc.setValue(33.21f);
    mc.setValue('d');
    byte argByte = 0b111;
    mc.setValue(argByte);
  }
}
