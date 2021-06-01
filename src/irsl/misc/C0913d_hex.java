package irsl.misc;

// this is just a simple hex converter
public class C0913d_hex {
    /* renamed from: a */
    public static String m5086a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m5087a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) C0603f_text.m2818a(str.substring(i * 2, (i * 2) + 2), 16, "HexConvert,fromHex:", i);
        }
        return bArr;
    }
}