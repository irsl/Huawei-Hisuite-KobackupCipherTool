package irsl.crypto.backupsecurityv3;
public abstract class C1774a implements C1781d, C1789c {

    /* renamed from: a */
    private final byte[] f5041a;

    /* renamed from: b */
    private int f5042b;

    /* renamed from: c */
    private long f5043c;

    protected C1774a() {
        this.f5041a = new byte[4];
        this.f5042b = 0;
    }

    protected C1774a(C1774a aVar) {
        this.f5041a = new byte[4];
        mo5858a(aVar);
    }

    /* renamed from: a */
    public void mo5856a(byte b) {
        byte[] bArr = this.f5041a;
        int i = this.f5042b;
        this.f5042b = i + 1;
        bArr[i] = b;
        if (this.f5042b == this.f5041a.length) {
            mo5860b(this.f5041a, 0);
            this.f5042b = 0;
        }
        this.f5043c++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5857a(long j);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5858a(C1774a aVar) {
        System.arraycopy(aVar.f5041a, 0, this.f5041a, 0, aVar.f5041a.length);
        this.f5042b = aVar.f5042b;
        this.f5043c = aVar.f5043c;
    }

    /* renamed from: a */
    public void mo5859a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, i2);
        if (this.f5042b != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= max) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.f5041a;
                int i5 = this.f5042b;
                this.f5042b = i5 + 1;
                int i6 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (this.f5042b == 4) {
                    mo5860b(this.f5041a, 0);
                    this.f5042b = 0;
                    i3 = i6;
                    break;
                }
                i4 = i6;
            }
        }
        int i7 = ((max - i3) & -4) + i3;
        while (i3 < i7) {
            mo5860b(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < max) {
            byte[] bArr3 = this.f5041a;
            int i8 = this.f5042b;
            this.f5042b = i8 + 1;
            bArr3[i8] = bArr[i3 + i];
            i3++;
        }
        this.f5043c += (long) max;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo5860b(byte[] bArr, int i);

    /* renamed from: c */
    public void mo5861c() {
        this.f5043c = 0;
        this.f5042b = 0;
        for (int i = 0; i < this.f5041a.length; i++) {
            this.f5041a[i] = 0;
        }
    }

    /* renamed from: d */
    public int mo5862d() {
        return 64;
    }

    /* renamed from: e */
    public void mo5863e() {
        long j = this.f5043c << 3;
        mo5856a(Byte.MIN_VALUE);
        while (this.f5042b != 0) {
            mo5856a((byte) 0);
        }
        mo5857a(j);
        mo5864f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract void mo5864f();
}
