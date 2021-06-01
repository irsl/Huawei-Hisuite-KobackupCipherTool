package irsl.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C0604g_file {
	/* renamed from: d */
	public static File m2837d(String str) {
	    if (TextUtils.isEmpty(str)) {
	        return new File("");
	    }
	    
	    return new File(str);
	    
	}
	
    /* renamed from: b */
    public static FileInputStream m2833b(String str) throws FileNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }

        return new FileInputStream(str);
    }
}

