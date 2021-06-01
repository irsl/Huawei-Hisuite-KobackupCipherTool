package irsl.crypto.backupsecurityv3;
public class C1775b extends C1774a {

    /* renamed from: a */
    private int f5044a;

    /* renamed from: b */
    private int f5045b;

    /* renamed from: c */
    private int f5046c;

    /* renamed from: d */
    private int f5047d;

    /* renamed from: e */
    private int f5048e;

    /* renamed from: f */
    private int[] f5049f = new int[80];

    /* renamed from: g */
    private int f5050g;

    public C1775b() {
        mo5861c();
    }

    public C1775b(C1775b bVar) {
        super(bVar);
        m9857a(bVar);
    }

    /* renamed from: a */
    private int m9856a(int i, int i2, int i3) {
        return (i & i2) | ((i ^ -1) & i3);
    }

    /* renamed from: a */
    private void m9857a(C1775b bVar) {
        this.f5044a = bVar.f5044a;
        this.f5045b = bVar.f5045b;
        this.f5046c = bVar.f5046c;
        this.f5047d = bVar.f5047d;
        this.f5048e = bVar.f5048e;
        System.arraycopy(bVar.f5049f, 0, this.f5049f, 0, bVar.f5049f.length);
        this.f5050g = bVar.f5050g;
    }

    /* renamed from: b */
    private int m9858b(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: c */
    private int m9859c(int i, int i2, int i3) {
        return (i & i2) | (i & i3) | (i2 & i3);
    }

    /* renamed from: a */
    public int mo5865a(byte[] bArr, int i) {
        mo5863e();
        C1790d.m9914a(this.f5044a, bArr, i);
        C1790d.m9914a(this.f5045b, bArr, i + 4);
        C1790d.m9914a(this.f5046c, bArr, i + 8);
        C1790d.m9914a(this.f5047d, bArr, i + 12);
        C1790d.m9914a(this.f5048e, bArr, i + 16);
        mo5861c();
        return 20;
    }

    /* renamed from: a */
    public String mo5866a() {
        return "SHA-1";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5857a(long j) {
        if (this.f5050g > 14) {
            mo5864f();
        }
        this.f5049f[14] = (int) (j >>> 32);
        this.f5049f[15] = (int) j;
    }

    /* renamed from: a */
    public void mo5867a(C1789c cVar) {
        C1775b bVar = (C1775b) cVar;
        super.mo5858a((C1774a) bVar);
        m9857a(bVar);
    }

    /* renamed from: b */
    public int mo5868b() {
        return 20;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5860b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        this.f5049f[this.f5050g] = (bArr[i] << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255);
        int i4 = this.f5050g + 1;
        this.f5050g = i4;
        if (i4 == 16) {
            mo5864f();
        }
    }

    /* renamed from: c */
    public void mo5861c() {
        super.mo5861c();
        this.f5044a = 1732584193;
        this.f5045b = -271733879;
        this.f5046c = -1732584194;
        this.f5047d = 271733878;
        this.f5048e = -1009589776;
        this.f5050g = 0;
        for (int i = 0; i != this.f5049f.length; i++) {
            this.f5049f[i] = 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo5864f() {
        for (int i = 16; i < 80; i++) {
            int i2 = ((this.f5049f[i - 3] ^ this.f5049f[i - 8]) ^ this.f5049f[i - 14]) ^ this.f5049f[i - 16];
            this.f5049f[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.f5044a;
        int i4 = this.f5045b;
        int i5 = this.f5046c;
        int i6 = this.f5047d;
        int i7 = this.f5048e;
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i8 + 1;
            int a = this.f5049f[i8] + ((i3 << 5) | (i3 >>> 27)) + m9856a(i4, i5, i6) + 1518500249 + i7;
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int a2 = i6 + ((a << 5) | (a >>> 27)) + m9856a(i3, i11, i5) + this.f5049f[i10] + 1518500249;
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int a3 = i5 + ((a2 << 5) | (a2 >>> 27)) + m9856a(a, i13, i11) + this.f5049f[i12] + 1518500249;
            i7 = (a << 30) | (a >>> 2);
            int i15 = i14 + 1;
            i4 = i11 + ((a3 << 5) | (a3 >>> 27)) + m9856a(a2, i7, i13) + this.f5049f[i14] + 1518500249;
            i6 = (a2 >>> 2) | (a2 << 30);
            i8 = i15 + 1;
            i3 = i13 + m9856a(a3, i6, i7) + ((i4 << 5) | (i4 >>> 27)) + this.f5049f[i15] + 1518500249;
            i5 = (a3 >>> 2) | (a3 << 30);
        }
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = i8 + 1;
            int b = this.f5049f[i8] + ((i3 << 5) | (i3 >>> 27)) + m9858b(i4, i5, i6) + 1859775393 + i7;
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int b2 = i6 + ((b << 5) | (b >>> 27)) + m9858b(i3, i18, i5) + this.f5049f[i17] + 1859775393;
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int b3 = i5 + ((b2 << 5) | (b2 >>> 27)) + m9858b(b, i20, i18) + this.f5049f[i19] + 1859775393;
            i7 = (b << 30) | (b >>> 2);
            int i22 = i21 + 1;
            i4 = i18 + ((b3 << 5) | (b3 >>> 27)) + m9858b(b2, i7, i20) + this.f5049f[i21] + 1859775393;
            i6 = (b2 >>> 2) | (b2 << 30);
            i8 = i22 + 1;
            i3 = i20 + m9858b(b3, i6, i7) + ((i4 << 5) | (i4 >>> 27)) + this.f5049f[i22] + 1859775393;
            i5 = (b3 >>> 2) | (b3 << 30);
        }
        for (int i23 = 0; i23 < 4; i23++) {
            int i24 = i8 + 1;
            int c = ((this.f5049f[i8] + (((i3 << 5) | (i3 >>> 27)) + m9859c(i4, i5, i6))) - 1894007588) + i7;
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int c2 = i6 + (((((c << 5) | (c >>> 27)) + m9859c(i3, i25, i5)) + this.f5049f[i24]) - 1894007588);
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int c3 = i5 + (((((c2 << 5) | (c2 >>> 27)) + m9859c(c, i27, i25)) + this.f5049f[i26]) - 1894007588);
            i7 = (c << 30) | (c >>> 2);
            int i29 = i28 + 1;
            i4 = i25 + (((((c3 << 5) | (c3 >>> 27)) + m9859c(c2, i7, i27)) + this.f5049f[i28]) - 1894007588);
            i6 = (c2 >>> 2) | (c2 << 30);
            int c4 = m9859c(c3, i6, i7) + ((i4 << 5) | (i4 >>> 27));
            i8 = i29 + 1;
            i3 = i27 + ((c4 + this.f5049f[i29]) - 1894007588);
            i5 = (c3 >>> 2) | (c3 << 30);
        }
        for (int i30 = 0; i30 <= 3; i30++) {
            int i31 = i8 + 1;
            int b4 = ((this.f5049f[i8] + (((i3 << 5) | (i3 >>> 27)) + m9858b(i4, i5, i6))) - 899497514) + i7;
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int b5 = i6 + (((((b4 << 5) | (b4 >>> 27)) + m9858b(i3, i32, i5)) + this.f5049f[i31]) - 899497514);
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int b6 = i5 + (((((b5 << 5) | (b5 >>> 27)) + m9858b(b4, i34, i32)) + this.f5049f[i33]) - 899497514);
            i7 = (b4 << 30) | (b4 >>> 2);
            int i36 = i35 + 1;
            i4 = i32 + (((((b6 << 5) | (b6 >>> 27)) + m9858b(b5, i7, i34)) + this.f5049f[i35]) - 899497514);
            i6 = (b5 >>> 2) | (b5 << 30);
            int b7 = m9858b(b6, i6, i7) + ((i4 << 5) | (i4 >>> 27));
            i8 = i36 + 1;
            i3 = i34 + ((b7 + this.f5049f[i36]) - 899497514);
            i5 = (b6 >>> 2) | (b6 << 30);
        }
        this.f5044a += i3;
        this.f5045b += i4;
        this.f5046c += i5;
        this.f5047d += i6;
        this.f5048e += i7;
        this.f5050g = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            this.f5049f[i37] = 0;
        }
    }

    /* renamed from: g */
    public C1789c mo5869g() {
        return new C1775b(this);
    }
}
