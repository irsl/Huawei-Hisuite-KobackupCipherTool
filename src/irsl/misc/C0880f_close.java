package irsl.misc;

import java.io.Closeable;
import java.io.IOException;

public class C0880f_close {
    /* renamed from: a */
    public static void m4927a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C0601e_log.m2813d("IoUtils", "close failed.");
            }
        }
    }
}