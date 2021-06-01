package irsl;

import irsl.crypto.backupsecurityv3.C0911b_CheckMsgV3;

public class CheckMsgV3Tool {
	
	public static void main(String[] args) throws Exception{

		if((args.length != 2) && (args.length != 3)) {
			System.err.println("Usage: java irsl.CheckMsgV3Tool path-to-encrypted-file password [checkmsgv3]");
			return;
		}
		
		String filePath = args[0];
		String password = args[1];
		if(args.length == 3)
		{
			String checkMsgV3 = args[2];
			
			boolean b = C0911b_CheckMsgV3.Verify(password, checkMsgV3, filePath);
			System.out.println("Verify result: "+b);
			
		} else {			
			String calculated = C0911b_CheckMsgV3.CalculateCheckMsgV3(password, filePath);
			System.out.println("CheckMsgV3: "+calculated);

		}
	}

}
