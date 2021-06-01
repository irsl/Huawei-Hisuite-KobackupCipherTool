package irsl.crypto.backupsecurityv3;

import java.util.Hashtable;

import irsl.misc.C1788b_int;

public class C1780a_hasher implements C1783e {

    /* renamed from: h */
    private static Hashtable f5064h = new Hashtable();

    /* renamed from: a */
    private C1779c f5065a;

    /* renamed from: b */
    private int f5066b;

    /* renamed from: c */
    private int f5067c;

    /* renamed from: d */
    private C1789c f5068d;

    /* renamed from: e */
    private C1789c f5069e;

    /* renamed from: f */
    private byte[] f5070f;

    /* renamed from: g */
    private byte[] f5071g;

    static {
        f5064h.put("GOST3411", C1788b_int.m9911a(32));
        f5064h.put("MD2", C1788b_int.m9911a(16));
        f5064h.put("MD4", C1788b_int.m9911a(64));
        f5064h.put("MD5", C1788b_int.m9911a(64));
        f5064h.put("RIPEMD128", C1788b_int.m9911a(64));
        f5064h.put("RIPEMD160", C1788b_int.m9911a(64));
        f5064h.put("SHA-1", C1788b_int.m9911a(64));
        f5064h.put("SHA-224", C1788b_int.m9911a(64));
        f5064h.put("SHA-256", C1788b_int.m9911a(64));
        f5064h.put("SHA-384", C1788b_int.m9911a(128)); // CpioConstants.C_IWUSR
        f5064h.put("SHA-512", C1788b_int.m9911a(128)); // CpioConstants.C_IWUSR
        f5064h.put("Tiger", C1788b_int.m9911a(64));
        f5064h.put("Whirlpool", C1788b_int.m9911a(64));
    }

    public C1780a_hasher(C1779c cVar) {
        this(cVar, m9894a(cVar));
    }

    private C1780a_hasher(C1779c cVar, int i) {
        this.f5065a = cVar;
        this.f5066b = cVar.mo5868b();
        this.f5067c = i;
        this.f5070f = new byte[this.f5067c];
        this.f5071g = new byte[(this.f5067c + this.f5066b)];
    }

    /* renamed from: a */
    private static int m9894a(C1779c cVar) {
        if (cVar instanceof C1781d) {
            return ((C1781d) cVar).mo5862d();
        }
        Integer num = (Integer) f5064h.get(cVar.mo5866a());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + cVar.mo5866a());
    }

    /* renamed from: a */
    private static void m9895a(byte[] bArr, int i, byte b) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b);
        }
    }

    /* renamed from: a */
    public int mo5872a() {
        return this.f5066b;
    }

    /* renamed from: a */
    public int mo5873a(byte[] bArr, int i) {
        this.f5065a.mo5865a(this.f5071g, this.f5067c);
        if (this.f5069e != null) {
            ((C1789c) this.f5065a).mo5867a(this.f5069e);
            this.f5065a.mo5859a(this.f5071g, this.f5067c, this.f5065a.mo5868b());
        } else {
            this.f5065a.mo5859a(this.f5071g, 0, this.f5071g.length);
        }
        int a = this.f5065a.mo5865a(bArr, i);
        for (int i2 = this.f5067c; i2 < this.f5071g.length; i2++) {
            this.f5071g[i2] = 0;
        }
        if (this.f5068d != null) {
            ((C1789c) this.f5065a).mo5867a(this.f5068d);
        } else {
            this.f5065a.mo5859a(this.f5070f, 0, this.f5070f.length);
        }
        return a;
    }

    /* renamed from: a */
    public void mo5874a(C1773a aVar) {
        this.f5065a.mo5861c();
        byte[] a = ((C1782a) aVar).mo5876a();
        int length = a.length;
        if (length > this.f5067c) {
            this.f5065a.mo5859a(a, 0, length);
            this.f5065a.mo5865a(this.f5070f, 0);
            length = this.f5066b;
        } else {
            System.arraycopy(a, 0, this.f5070f, 0, length);
        }
        while (length < this.f5070f.length) {
            this.f5070f[length] = 0;
            length++;
        }
        System.arraycopy(this.f5070f, 0, this.f5071g, 0, this.f5067c);
        m9895a(this.f5070f, this.f5067c, (byte) 54); // TarConstants.LF_FIFO
        m9895a(this.f5071g, this.f5067c, (byte) 92);
        if (this.f5065a instanceof C1789c) {
            this.f5069e = ((C1789c) this.f5065a).mo5869g();
            ((C1779c) this.f5069e).mo5859a(this.f5071g, 0, this.f5067c);
        }
        this.f5065a.mo5859a(this.f5070f, 0, this.f5070f.length);
        if (this.f5065a instanceof C1789c) {
            this.f5068d = ((C1789c) this.f5065a).mo5869g();
        }
    }

    /* renamed from: a */
    public void mo5875a(byte[] bArr, int i, int i2) {
        this.f5065a.mo5859a(bArr, i, i2);
    }
}
