package irsl;

import irsl.crypto.backupsecurityv3.C0911b_CheckMsgV3;
import irsl.crypto.backupsecurityv3.KobackupBackupSecurityv3Cipher;

public class BackupSecurityV3EncryptionTool {
	public static void main(String[] args) throws Exception{

		if(args.length != 3) {
			System.err.println("Usage: java irsl.BackupSecurityV3EncryptionTool path-to-clear-file password path-to-result");
			return;
		}
		
		String clearFilePath = args[0];
		String password = args[1];
		String filePathResult = args[2];
		
		KobackupBackupSecurityv3Cipher ksc = KobackupBackupSecurityv3Cipher.createNew(password);
		ksc.EncryptFile(clearFilePath, filePathResult);
		System.out.println(String.format("encMsgV3: %s", ksc.getEncMsgV3()));
		String checkMsgV3 = C0911b_CheckMsgV3.CalculateCheckMsgV3(password, filePathResult);
		System.out.println(String.format("checkMsgV3: %s", checkMsgV3));
	}
}
