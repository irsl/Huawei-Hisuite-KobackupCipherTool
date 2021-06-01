package irsl.misc;
public final class C1787a {
    /* renamed from: a */
    private static int m9909a(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            return i3;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(" > ").append(i2);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* renamed from: a */
    public static byte[] m9910a(byte[] bArr, int i, int i2) {
        int a = m9909a(i, i2);
        byte[] bArr2 = new byte[a];
        if (bArr.length - i < a) {
            System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
        } else {
            System.arraycopy(bArr, i, bArr2, 0, a);
        }
        return bArr2;
    }
}
