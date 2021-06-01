package irsl.crypto.backupsecurityv3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import irsl.misc.C0601e_log;
import irsl.misc.C0604g_file;
import irsl.misc.C0880f_close;
import irsl.misc.C0913d_hex;


public class C0912c_hmac {
    /* renamed from: a */
    public static String m5084a(String str, String str2 /* filePath */) {
        FileInputStream fileInputStream;

        FileInputStream fileInputStream2;
        String str3 = null;
        if (str == null || str2 == null) {
            C0601e_log.m2813d("HMACHash", "[hmac] key or filePath is null");
        } else {
            File d = C0604g_file.m2837d(str2);
            if (!d.exists() || !d.isFile()) {
            	C0601e_log.m2813d("HMACHash", "[hmac] file does not exist.");
            } else {
                byte[] bArr = new byte[8192];
                try {
                    Mac instance = Mac.getInstance("HmacSHA256");
                    instance.init(new SecretKeySpec(str.getBytes(Charset.defaultCharset()), "HmacSHA256")); // was utf8
                    fileInputStream = C0604g_file.m2833b(str2);
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr, 0, 8192);
                            if (read == -1) {
                                break;
                            }
                            instance.update(bArr, 0, read);
                        } catch (IllegalStateException e3) {
                        	C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] IllegalStateException.");
                            C0880f_close.m4927a(fileInputStream);
                            return str3;
                        } catch (UnsupportedEncodingException e4) {
                        	C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] UnsupportedEncodingException.");
                            C0880f_close.m4927a(fileInputStream);
                            return str3;
                        } catch (FileNotFoundException e5) {
                        	C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] FileNotFoundException.");
                            C0880f_close.m4927a(fileInputStream);
                            return str3;
                        } catch (IOException e6) {
                        	C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] IOException.");
                            C0880f_close.m4927a(fileInputStream);
                            return str3;
                        }
                    }
                    str3 = C0913d_hex.m5086a(instance.doFinal());
                    C0880f_close.m4927a(fileInputStream);
                } catch (NoSuchAlgorithmException e7) {
                    fileInputStream = null;
                } catch (InvalidKeyException e8) {
                    fileInputStream = null;
                    C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] InvalidKeyException.");
                    C0880f_close.m4927a(fileInputStream);
                    return str3;
                } catch (IllegalStateException e9) {
                    fileInputStream = null;
                    C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] IllegalStateException.");
                    C0880f_close.m4927a(fileInputStream);
                    return str3;
                } catch (FileNotFoundException e11) {
                    fileInputStream = null;
                    C0601e_log.m2813d("HMACHash", "[hmacSHA256_file] FileNotFoundException.");
                    C0880f_close.m4927a(fileInputStream);
                    return str3;
                } catch (Throwable th3) {
                    fileInputStream2 = null;
                    C0880f_close.m4927a(fileInputStream2);
                    return str3;
                }
            }
        }
        return str3;
    }

}
