package irsl;

import irsl.crypto.backupsecurityv3.KobackupBackupSecurityv3Cipher;

public class BackupSecurityV3DecryptionTool {
	public static void main(String[] args) throws Exception{

		if(args.length != 4) {
			System.err.println("Usage: java irsl.BackupSecurityV3DecryptionTool path-to-encrypted-file password encmsgv3 path-to-result");
			return;
		}
		
		String encryptedFilePath = args[0];
		String password = args[1];
		String encMsgV3 = args[2];
		String filePathResult = args[3];
		
		KobackupBackupSecurityv3Cipher ksc = KobackupBackupSecurityv3Cipher.init(password, encMsgV3);
		ksc.DecryptFile(encryptedFilePath, filePathResult);
	}
}
