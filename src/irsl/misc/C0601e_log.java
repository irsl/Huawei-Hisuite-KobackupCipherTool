package irsl.misc;

// this is some Log variant
public class C0601e_log {

	public static void m2813d(String tag, String msg) {
		System.err.println(String.format("[%s]: %s", tag, msg));		
	}

	public static void m2814d(String tag, String str2, Integer valueOf) {
		m2813d(tag, str2+": "+valueOf);		
	}

}
