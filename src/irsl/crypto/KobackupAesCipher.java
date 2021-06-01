package irsl.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class KobackupAesCipher extends KobackupCipher {

	public KobackupAesCipher(String password) {
		super(password);
	}

    private byte[] m5046a_key_derivation(byte[] bArr) throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG");
        instance2.setSeed(bArr);
        instance.init(128, instance2); // 128 was CpioConstants.C_IWUSR in the decompiled source code :)
        return instance.generateKey().getEncoded();
    }
    
	@Override
	protected Cipher getCipher(int cryptoDirection) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(m5046a_key_derivation(password.getBytes("utf-8")), "AES");
        Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
        instance.init(cryptoDirection, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
        return instance;
	}

	
}
