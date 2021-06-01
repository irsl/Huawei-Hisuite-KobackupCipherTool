package irsl.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class KobackupAes2Cipher extends KobackupCipher {

	public KobackupAes2Cipher(String password) {
		super(password);
	}

    
	@Override
	protected Cipher getCipher(int cryptoDirection) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
		byte[] keyBytes = new C1173j_md5(password).mo3540b();
		
		// note: the original implementation specified "AES2" as algorithm here; 
		// oracle jdk throws an exception for AES2 but produces the same key with simple "AES"
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES"); 
        Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
        instance.init(cryptoDirection, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
        return instance;
	}

}
