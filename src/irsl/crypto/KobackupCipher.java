package irsl.crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public abstract class KobackupCipher {

	protected abstract Cipher getCipher(int cryptoDirection) throws Exception;
	protected String password;
	
	public KobackupCipher(String password) {
		this.password = password;
	}
	
	public void EncryptFile(String in, String out) throws Exception 
	{
		try(FileInputStream fis = new FileInputStream(in)) {
			try(FileOutputStream fos = new FileOutputStream(out)) {
				EncryptStream(fis, fos);
			}
		}		
	}
	public void EncryptStream(InputStream in, OutputStream out) throws Exception 
	{
		Cipher c = getCipher(Cipher.ENCRYPT_MODE);
		try(CipherInputStream csin = new CipherInputStream(in, c)) {
			copyData(csin, out);
		}		
	}

	public void DecryptFile(String in, String out) throws Exception 
	{
		try(FileInputStream fis = new FileInputStream(in)) {
			try(FileOutputStream fos = new FileOutputStream(out)) {
				DecryptStream(fis, fos);
			}
		}
	}
	public void DecryptStream(InputStream in, OutputStream out) throws Exception 
	{
		Cipher c = getCipher(Cipher.DECRYPT_MODE);
		try(CipherInputStream csin = new CipherInputStream(in, c)) {
			copyData(csin, out);
		}
	}
	
	public void TransformStream(int cryptoDirection, InputStream in, OutputStream out) 
	{
	}
	
	// we are on java 1.8
	private static void copyData(InputStream in, OutputStream out) throws Exception {
	    byte[] buffer = new byte[8 * 1024];
	    int len;
	    while ((len = in.read(buffer)) > 0) {
	        out.write(buffer, 0, len);
	    }
	}

	public static KobackupCipher Create(String cipherType, String password) {
		switch(cipherType) {
		case "AES": return new KobackupAesCipher(password);
		case "AES2": return new KobackupAes2Cipher(password);
		default:
			throw new InvalidParameterException("Ciphertype is not supported: "+cipherType);
		}
	}
}
