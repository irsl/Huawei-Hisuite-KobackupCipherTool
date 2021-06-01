package irsl.misc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class C1791e_output {

	
    /* 
    private static String f5076a;

    static {
        try {
            f5076a = System.getProperty("line.separator");
        } catch (Exception e) {
            try {
                f5076a = String.format("%n", new Object[0]);
            } catch (Exception e2) {
                f5076a = "\n";
            }
        }
    }
    */

    /* renamed from: a */
    public static void m9915a(char[] cArr, OutputStream outputStream) throws IOException {
        int i = 0;
        while (i < cArr.length) {
            char c = cArr[i];
            if (c < 128) {
                outputStream.write(c);
            } else if (c < 2048) {
                outputStream.write((c >> 6) | 192);
                outputStream.write((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                outputStream.write((c >> 12) | 224);
                outputStream.write(((c >> 6) & 63) | 128); // CpioConstants.C_IWUSR
                outputStream.write((c & '?') | 128);
            } else if (i + 1 >= cArr.length) {
                throw new IllegalStateException("invalid UTF-16 codepoint");
            } else {
                i++;
                char c2 = cArr[i];
                if (c > 56319) {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                int i2 = (((c & 1023) << 10) | (c2 & 1023)) + 0;
                outputStream.write((i2 >> 18) | 240);
                outputStream.write(((i2 >> 12) & 63) | 128); // CpioConstants.C_IWUSR
                outputStream.write(((i2 >> 6) & 63) | 128); // CpioConstants.C_IWUSR
                outputStream.write((i2 & 63) | 128); // CpioConstants.C_IWUSR
            }
            i++;
        }
    }

    /* renamed from: a */
    public static byte[] m9916a(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m9915a(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }
}
