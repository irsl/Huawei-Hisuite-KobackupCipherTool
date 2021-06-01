package irsl.misc;

public class C0915f_bytearr {
    public static boolean m5093a(byte[] bArr, byte[] bArr2) { // compare byte arrays
        if (bArr == null || bArr2 == null) {
            return false;
        }
        byte length = (byte) (bArr2.length ^ bArr.length);
        int i = 0;
        while (i < bArr.length && i < bArr2.length) {
            length |= bArr[i] ^ bArr2[i];
            i++;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }
}
