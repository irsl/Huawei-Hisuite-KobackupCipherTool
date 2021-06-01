package irsl.crypto.backupsecurityv3;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import irsl.crypto.KobackupCipher;
import irsl.misc.C0913d_hex;

public class KobackupBackupSecurityv3Cipher extends KobackupCipher {

	private byte[] initializationVector = new byte[16];
	private byte[] aesKey;
	private String encMsgV3;
	
	private KobackupBackupSecurityv3Cipher(String password) {
		super(password);
	}
	
	public String getEncMsgV3()
	{
		return encMsgV3;
	}
	
	public static KobackupBackupSecurityv3Cipher createNew(String password)
	{
		KobackupBackupSecurityv3Cipher ksc = new KobackupBackupSecurityv3Cipher(password);
		ksc.generateNewKeys();
		return ksc;
	}
	private void generateNewKeys() {
		SecureRandom sr = new SecureRandom();
		byte[] pwSeed = new byte[32];				
		sr.nextBytes(pwSeed);
		sr.nextBytes(initializationVector);
		
		String pwSeedHexStr = C0913d_hex.m5086a(pwSeed);
		String ivHexStr = C0913d_hex.m5086a(initializationVector);
		String aesKeyStr = C0914e_pbkdf2_top.m5088a(password, pwSeedHexStr);
		aesKey = C0913d_hex.m5087a(aesKeyStr);
		this.encMsgV3 = pwSeedHexStr + ivHexStr;
	}

	public static KobackupBackupSecurityv3Cipher init(String password, String encMsgV3) throws InvalidAlgorithmParameterException
	{
		KobackupBackupSecurityv3Cipher ksc = new KobackupBackupSecurityv3Cipher(password);
		ksc.processEncMsgV3(encMsgV3);
		return ksc;
	}

	private void processEncMsgV3(String encMsgV3) throws InvalidAlgorithmParameterException {
		if((encMsgV3 == null) || (encMsgV3.length() != 96))
			throw new InvalidAlgorithmParameterException("encMsgV3 must be 96 characters");
		String keyDerivationSeedHexStr = encMsgV3.substring(0, 64);
		String initVectorHexStr = encMsgV3.substring(64);
		this.initializationVector = C0913d_hex.m5087a(initVectorHexStr);
		String aesKeyStr = C0914e_pbkdf2_top.m5088a(password, keyDerivationSeedHexStr);
		aesKey = C0913d_hex.m5087a(aesKeyStr);
		this.encMsgV3 = encMsgV3;		
	}

	@Override
	protected Cipher getCipher(int cryptoDirection) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey, "AES");
        Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
        instance.init(cryptoDirection, secretKeySpec, new IvParameterSpec(initializationVector));
        return instance;
	}

	
}
