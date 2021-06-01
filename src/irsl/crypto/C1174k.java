package irsl.crypto;
class C1174k {

    /* renamed from: a */
    private int[] f3204a;

    /* renamed from: b */
    private long f3205b;

    /* renamed from: c */
    private byte[] f3206c;

    C1174k() {
        this.f3206c = new byte[64];
        this.f3205b = 0;
        this.f3204a = new int[4];
        this.f3204a[0] = 1732584193;
        this.f3204a[1] = -271733879;
        this.f3204a[2] = -1732584194;
        this.f3204a[3] = 271733878;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    C1174k(C1174k kVar) {
        this();
        for (int i = 0; i < this.f3206c.length; i++) {
            this.f3206c[i] = kVar.f3206c[i];
        }
        for (int i2 = 0; i2 < this.f3204a.length; i2++) {
            this.f3204a[i2] = kVar.f3204a[i2];
        }
        this.f3205b = kVar.f3205b;
    }

    /* renamed from: a */
    public int[] mo3544a() {
        return this.f3204a;
    }

    /* renamed from: a */
    public void mo3543a(int[] iArr) {
        this.f3204a = iArr;
    }

    /* renamed from: b */
    public long mo3545b() {
        return this.f3205b;
    }

    /* renamed from: a */
    public void mo3541a(long j) {
        this.f3205b = j;
    }

    /* renamed from: c */
    public byte[] mo3546c() {
        return this.f3206c;
    }

    /* renamed from: a */
    public void mo3542a(byte[] bArr) {
        this.f3206c = bArr;
    }
}
