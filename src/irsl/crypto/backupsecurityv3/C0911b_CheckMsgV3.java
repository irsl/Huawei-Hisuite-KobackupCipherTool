package irsl.crypto.backupsecurityv3;

import java.security.SecureRandom;

import irsl.misc.C0601e_log;
import irsl.misc.C0913d_hex;
import irsl.misc.C0915f_bytearr;

public class C0911b_CheckMsgV3 {

    public static String CalculateCheckMsgV3(String password, String pathToEncryptedFile) {
        
    	byte[] seed = new byte[32];
    	SecureRandom sr = new SecureRandom();
    	sr.nextBytes(seed);
    	
    	String seedHexStr = C0913d_hex.m5086a(seed);
        String a = C0914e_pbkdf2_top.m5088a(password, seedHexStr);
        if (a == null) {
        	C0601e_log.m2813d("BackupSecurityV3", "couldn't derive hmac key.");
            return null;
        }
        String calculatedHmac = C0912c_hmac.m5084a(a, pathToEncryptedFile); // hmac of the file
        
        return calculatedHmac+seedHexStr;
    }
    
    public static boolean Verify(String password /* str */, String checkMsgV3 /* str2 */, String filePath  /* str3 */) {
        if (checkMsgV3 == null || checkMsgV3.length() != 128) {
        	C0601e_log.m2813d("BackupSecurityV3", "validateEncryptFile: checkInfo is empty.");
            return false;
        }
        
        String expectedHmac = checkMsgV3.substring(0, 64);

        //  m5088a is PBKDF2
        String a = C0914e_pbkdf2_top.m5088a(password, checkMsgV3.substring(64, 128)); // was CpioConstants.C_IWUSR
        if (a == null) {
        	C0601e_log.m2813d("BackupSecurityV3", "validateEncryptFile: hmacKey is empty.");
            return false;
        }
        String calculatedHmac = C0912c_hmac.m5084a(a, filePath); // hmac of the file
        if (calculatedHmac == null || !C0915f_bytearr.m5093a(C0913d_hex.m5087a(expectedHmac), C0913d_hex.m5087a(calculatedHmac))) {
            return false;
        }
        return true;
    }
}
