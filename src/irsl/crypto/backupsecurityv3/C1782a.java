package irsl.crypto.backupsecurityv3;
public class C1782a implements C1773a {

    /* renamed from: a */
    private byte[] f5072a;

    public C1782a(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public C1782a(byte[] bArr, int i, int i2) {
        this.f5072a = new byte[i2];
        System.arraycopy(bArr, i, this.f5072a, 0, i2);
    }

    /* renamed from: a */
    public byte[] mo5876a() {
        return this.f5072a;
    }
}
