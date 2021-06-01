package irsl.crypto.backupsecurityv3;

import irsl.misc.C0601e_log;
import irsl.misc.C0913d_hex;

public class C0914e_pbkdf2_top {
    /* renamed from: a */
    public static String m5088a(String password, String seed) {
        if (password != null && seed != null) {
            return m5089a(password.toCharArray(), C0913d_hex.m5087a(seed));
        }
        C0601e_log.m2813d("Pbkdf2Hash", "[createHash] parameter is null.");
        return null;
    }

    /* renamed from: a */
    private static String m5089a(char[] cArr, byte[] bArr) {
        if (cArr == null || bArr == null) {
        	C0601e_log.m2813d("Pbkdf2Hash", "[createHash] parameter is null.");
            return null;
        }
        byte[] a = m5090a(cArr, bArr, 5000, 32);
        if (a != null) {
            return C0913d_hex.m5086a(a);
        }
        return null;
    }

    /* renamed from: a */
    private static byte[] m5090a(char[] cArr, byte[] bArr, int i, int i2) {
        C1778a aVar = new C1778a(new C1776c());
        aVar.mo5877a(C1785f.m9907a(cArr), bArr, i);
        return ((C1782a) aVar.mo5871b(i2 * 8)).mo5876a();
    }
}