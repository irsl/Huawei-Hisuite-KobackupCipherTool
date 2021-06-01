package irsl.crypto.backupsecurityv3;

import irsl.misc.C1790d;

public class C1776c extends C1774a {

    /* renamed from: a */
    static final int[] f5051a = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: b */
    private int f5052b;

    /* renamed from: c */
    private int f5053c;

    /* renamed from: d */
    private int f5054d;

    /* renamed from: e */
    private int f5055e;

    /* renamed from: f */
    private int f5056f;

    /* renamed from: g */
    private int f5057g;

    /* renamed from: h */
    private int f5058h;

    /* renamed from: i */
    private int f5059i;

    /* renamed from: j */
    private int[] f5060j = new int[64];

    /* renamed from: k */
    private int f5061k;

    public C1776c() {
        mo5861c();
    }

    public C1776c(C1776c cVar) {
        super(cVar);
        m9871a(cVar);
    }

    /* renamed from: a */
    private int m9869a(int i) {
        return (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19))) ^ ((i >>> 22) | (i << 10));
    }

    /* renamed from: a */
    private int m9870a(int i, int i2, int i3) {
        return (i & i2) ^ ((i ^ -1) & i3);
    }

    /* renamed from: a */
    private void m9871a(C1776c cVar) {
        super.mo5858a((C1774a) cVar);
        this.f5052b = cVar.f5052b;
        this.f5053c = cVar.f5053c;
        this.f5054d = cVar.f5054d;
        this.f5055e = cVar.f5055e;
        this.f5056f = cVar.f5056f;
        this.f5057g = cVar.f5057g;
        this.f5058h = cVar.f5058h;
        this.f5059i = cVar.f5059i;
        System.arraycopy(cVar.f5060j, 0, this.f5060j, 0, cVar.f5060j.length);
        this.f5061k = cVar.f5061k;
    }

    /* renamed from: b */
    private int m9872b(int i) {
        return (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21))) ^ ((i >>> 25) | (i << 7));
    }

    /* renamed from: b */
    private int m9873b(int i, int i2, int i3) {
        return ((i & i2) ^ (i & i3)) ^ (i2 & i3);
    }

    /* renamed from: c */
    private int m9874c(int i) {
        return (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14))) ^ (i >>> 3);
    }

    /* renamed from: d */
    private int m9875d(int i) {
        return (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13))) ^ (i >>> 10);
    }

    /* renamed from: a */
    public int mo5865a(byte[] bArr, int i) {
        mo5863e();
        C1790d.m9914a(this.f5052b, bArr, i);
        C1790d.m9914a(this.f5053c, bArr, i + 4);
        C1790d.m9914a(this.f5054d, bArr, i + 8);
        C1790d.m9914a(this.f5055e, bArr, i + 12);
        C1790d.m9914a(this.f5056f, bArr, i + 16);
        C1790d.m9914a(this.f5057g, bArr, i + 20);
        C1790d.m9914a(this.f5058h, bArr, i + 24);
        C1790d.m9914a(this.f5059i, bArr, i + 28);
        mo5861c();
        return 32;
    }

    /* renamed from: a */
    public String mo5866a() {
        return "SHA-256";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5857a(long j) {
        if (this.f5061k > 14) {
            mo5864f();
        }
        this.f5060j[14] = (int) (j >>> 32);
        this.f5060j[15] = (int) (-1 & j);
    }

    /* renamed from: a */
    public void mo5867a(C1789c cVar) {
        m9871a((C1776c) cVar);
    }

    /* renamed from: b */
    public int mo5868b() {
        return 32;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5860b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        this.f5060j[this.f5061k] = (bArr[i] << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255);
        int i4 = this.f5061k + 1;
        this.f5061k = i4;
        if (i4 == 16) {
            mo5864f();
        }
    }

    /* renamed from: c */
    public void mo5861c() {
        super.mo5861c();
        this.f5052b = 1779033703;
        this.f5053c = -1150833019;
        this.f5054d = 1013904242;
        this.f5055e = -1521486534;
        this.f5056f = 1359893119;
        this.f5057g = -1694144372;
        this.f5058h = 528734635;
        this.f5059i = 1541459225;
        this.f5061k = 0;
        for (int i = 0; i != this.f5060j.length; i++) {
            this.f5060j[i] = 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo5864f() {
        for (int i = 16; i <= 63; i++) {
            this.f5060j[i] = m9875d(this.f5060j[i - 2]) + this.f5060j[i - 7] + m9874c(this.f5060j[i - 15]) + this.f5060j[i - 16];
        }
        int i2 = this.f5052b;
        int i3 = this.f5053c;
        int i4 = this.f5054d;
        int i5 = this.f5055e;
        int i6 = this.f5056f;
        int i7 = this.f5057g;
        int i8 = this.f5058h;
        int i9 = this.f5059i;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int b = i9 + m9872b(i6) + m9870a(i6, i7, i8) + f5051a[i10] + this.f5060j[i10];
            int i12 = i5 + b;
            int a = b + m9869a(i2) + m9873b(i2, i3, i4);
            int i13 = i10 + 1;
            int b2 = i8 + m9872b(i12) + m9870a(i12, i6, i7) + f5051a[i13] + this.f5060j[i13];
            int i14 = i4 + b2;
            int a2 = b2 + m9869a(a) + m9873b(a, i2, i3);
            int i15 = i13 + 1;
            int b3 = i7 + m9872b(i14) + m9870a(i14, i12, i6) + f5051a[i15] + this.f5060j[i15];
            int i16 = i3 + b3;
            int a3 = b3 + m9869a(a2) + m9873b(a2, a, i2);
            int i17 = i15 + 1;
            int b4 = i6 + m9872b(i16) + m9870a(i16, i14, i12) + f5051a[i17] + this.f5060j[i17];
            int i18 = i2 + b4;
            int a4 = b4 + m9869a(a3) + m9873b(a3, a2, a);
            int i19 = i17 + 1;
            int b5 = i12 + m9872b(i18) + m9870a(i18, i16, i14) + f5051a[i19] + this.f5060j[i19];
            i9 = a + b5;
            i5 = b5 + m9869a(a4) + m9873b(a4, a3, a2);
            int i20 = i19 + 1;
            int b6 = i14 + m9872b(i9) + m9870a(i9, i18, i16) + f5051a[i20] + this.f5060j[i20];
            i8 = a2 + b6;
            i4 = b6 + m9869a(i5) + m9873b(i5, a4, a3);
            int i21 = i20 + 1;
            int b7 = i16 + m9872b(i8) + m9870a(i8, i9, i18) + f5051a[i21] + this.f5060j[i21];
            i7 = a3 + b7;
            i3 = b7 + m9869a(i4) + m9873b(i4, i5, a4);
            int i22 = i21 + 1;
            int b8 = i18 + m9872b(i7) + m9870a(i7, i8, i9) + f5051a[i22] + this.f5060j[i22];
            i6 = a4 + b8;
            i2 = b8 + m9869a(i3) + m9873b(i3, i4, i5);
            i10 = i22 + 1;
        }
        this.f5052b += i2;
        this.f5053c += i3;
        this.f5054d += i4;
        this.f5055e += i5;
        this.f5056f += i6;
        this.f5057g += i7;
        this.f5058h += i8;
        this.f5059i += i9;
        this.f5061k = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.f5060j[i23] = 0;
        }
    }

    /* renamed from: g */
    public C1789c mo5869g() {
        return new C1776c(this);
    }
}
