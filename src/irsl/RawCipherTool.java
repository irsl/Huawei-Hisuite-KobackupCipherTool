package irsl;

import java.security.InvalidParameterException;

import irsl.crypto.KobackupCipher;

public class RawCipherTool {

	public static void main(String[] args) throws Exception{

		if(args.length != 5) {
			System.err.println("Usage: java irsl.RawCipherTool inputfile outputfile direction ciphertype password");
			System.err.println("Where:");
			System.err.println("  direction 1 - encrypt, 2 - decrypt");
			System.err.println("  ciphertype is AES, AES2");
			System.err.println("For BackupSecurityV3 use the dedicated tools");
			return;
		}
		
		String in = args[0];
		String out = args[1];
		int dir = Integer.valueOf(args[2]);
		String cipherType = args[3];
		String password = args[4];
		
		KobackupCipher kc = KobackupCipher.Create(cipherType, password);
		switch(dir) {
		case 1: kc.EncryptFile(in, out); break;
		case 2: kc.DecryptFile(in, out); break;
		default:
			throw new InvalidParameterException("Invalid direction: "+dir);
		}
		
	}
}
