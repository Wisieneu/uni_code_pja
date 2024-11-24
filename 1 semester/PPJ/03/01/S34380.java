public class S34380 {

  public void method() {
    // boolean
    boolean bool1 = true;
    boolean bool2 = false;

    // byte
    byte byte_highest_01 = 0b1111111;
    byte byte_highest_10 = 127;
    byte byte_highest_8 = 0177;
    byte byte_highest_16 = 0x7F;

    byte byte_lowest_01 = -0b10000000;
    byte byte_lowest_10 = 127;
    byte byte_lowest_8 = -0200;
    byte byte_lowest_16 = -0x80;

    // short
    short short_highest_01 = 0b111111111111111;
    short short_highest_10 = 32767;
    short short_highest_8 = 077777;
    short short_highest_16 = 0x7FFF;

    short short_lowest_01 = 0b100000000000000;
    short short_lowest_10 = -32768;
    short short_lowest_8 = -0100000;
    short short_lowest_16 = -0x8000;

    // long
    long long_highest_01 =
      0b111111111111111111111111111111111111111111111111111111111111111L;
    long long_highest_10 = 9223372036854775807L;
    long long_highest_8 = 0777777777777777777777L;
    long long_highest_16 = 0x7fffffffffffffffL;

    long long_lowest_01 =
      0b1000000000000000000000000000000000000000000000000000000000000000L;
    long long_lowest_10 = -9223372036854775808L;
    long long_lowest_16 = 0x8000000000000000L;
    long long_lowest_8 = 01000000000000000000000L;

    // int
    int int_highest_10 = 2147483647;
    int int_biggest_01 = 0b1111111111111111111111111111111;
    int int_biggest_8 = 07777777777;
    int int_biggest_16 = 0x8FFFFFFF;

    int int_lowest_01 = 0b10000000000000000000000000000000;
    int int_lowest_10 = -2147483648;
    int int_lowest_8 = -020000000000;
    int int_lowest_16 = 0x80000000;

    // float
    float float_max_10 = 3.4028235e38f;
    float float_min_10 = -3.4028235e38f;

    // double
    double double_max_10 = 999999999;
    double double_min_10 = 0.1;

    // char
    char char_highest = 'z';
  }
}
