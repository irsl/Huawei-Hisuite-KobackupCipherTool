package irsl.crypto.backupsecurityv3;

import irsl.misc.C1787a;

public class C1778a extends C1785f {

    /* renamed from: d */
    private C1783e f5062d;

    /* renamed from: e */
    private byte[] f5063e;

    public C1778a() {
        this(C1784a.m9906a());
    }

    public C1778a(C1779c cVar) {
        this.f5062d = new C1780a_hasher(cVar);
        this.f5063e = new byte[this.f5062d.mo5872a()];
    }

    /* renamed from: a */
    private void m9885a(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2) {
        if (i == 0) {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }
        if (bArr != null) {
            this.f5062d.mo5875a(bArr, 0, bArr.length);
        }
        this.f5062d.mo5875a(bArr2, 0, bArr2.length);
        this.f5062d.mo5873a(this.f5063e, 0);
        System.arraycopy(this.f5063e, 0, bArr3, i2, this.f5063e.length);
        for (int i3 = 1; i3 < i; i3++) {
            this.f5062d.mo5875a(this.f5063e, 0, this.f5063e.length);
            this.f5062d.mo5873a(this.f5063e, 0);
            for (int i4 = 0; i4 != this.f5063e.length; i4++) {
                int i5 = i2 + i4;
                bArr3[i5] = (byte) (bArr3[i5] ^ this.f5063e[i4]);
            }
        }
    }

    /* renamed from: c */
    private byte[] m9886c(int i) {
        int a = this.f5062d.mo5872a();
        int i2 = ((i + a) - 1) / a;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[(i2 * a)];
        int i3 = 0;
        this.f5062d.mo5874a(new C1782a(this.f5073a));
        for (int i4 = 1; i4 <= i2; i4++) {
            int i5 = 3;
            while (true) {
                byte b = (byte) (bArr[i5] + 1);
                bArr[i5] = b;
                if (b != 0) {
                    break;
                }
                i5--;
            }
            m9885a(this.f5074b, this.f5075c, bArr, bArr2, i3);
            i3 += a;
        }
        return bArr2;
    }

    /* renamed from: a */
    public C1773a mo5870a(int i) {
        int i2 = i / 8;
        return new C1782a(C1787a.m9910a(m9886c(i2), 0, i2), 0, i2);
    }

    /* renamed from: b */
    public C1773a mo5871b(int i) {
        return mo5870a(i);
    }
}
