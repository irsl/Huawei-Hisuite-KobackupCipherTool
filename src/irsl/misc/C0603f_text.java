package irsl.misc;

public class C0603f_text {
    public static int m2818a(String str, int i, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str, i);
        } catch (NumberFormatException e) {
            C0601e_log.m2814d("ParseNumberUtils", str2, Integer.valueOf(i2));
            return -1;
        }
    }
}
