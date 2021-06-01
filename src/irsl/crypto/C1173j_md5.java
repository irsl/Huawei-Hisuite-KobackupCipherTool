package irsl.crypto;

import java.io.UnsupportedEncodingException;

import irsl.misc.C0601e_log;

// this is some MD5 implementation
public class C1173j_md5 {

    /* renamed from: a */
    private static byte[] f3199a = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b */
    private static final char[] f3200b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static final Object f3201c = new Object();

    /* renamed from: d */
    private C1174k f3202d;

    /* renamed from: e */
    private C1174k f3203e;

    public C1173j_md5(String str) {
        m6781c();
        m6775a(str);
    }

    /* renamed from: c */
    private synchronized void m6781c() {
        this.f3202d = new C1174k();
        this.f3203e = null;
    }

    /* renamed from: a */
    private int m6770a(byte[] bArr, int i, int i2) {
        return (bArr[i + i2] & 255) | ((bArr[(i + i2) + 1] & 255) << 8) | ((bArr[(i + i2) + 2] & 255) << 16) | (bArr[(i + i2) + 3] << 24);
    }

    /* renamed from: a */
    private void m6777a(byte[] bArr, int i, int[] iArr) {
        iArr[0] = m6770a(bArr, i, 0);
        iArr[1] = m6770a(bArr, i, 4);
        iArr[2] = m6770a(bArr, i, 8);
        iArr[3] = m6770a(bArr, i, 12);
        iArr[4] = m6770a(bArr, i, 16);
        iArr[5] = m6770a(bArr, i, 20);
        iArr[6] = m6770a(bArr, i, 24);
        iArr[7] = m6770a(bArr, i, 28);
        iArr[8] = m6770a(bArr, i, 32);
        iArr[9] = m6770a(bArr, i, 36);
        iArr[10] = m6770a(bArr, i, 40);
        iArr[11] = m6770a(bArr, i, 44);
        iArr[12] = m6770a(bArr, i, 48);
        iArr[13] = m6770a(bArr, i, 52);
        iArr[14] = m6770a(bArr, i, 56);
        iArr[15] = m6770a(bArr, i, 60);
    }

    /* renamed from: a */
    private void m6774a(C1174k kVar, byte[] bArr, int i, int[] iArr) {
        int[] a = kVar.mo3544a();
        if (a == null || a.length != 4) {
            C0601e_log.m2813d("MD5", "transform fail.");
            return;
        }
        int i2 = a[0];
        int i3 = a[1];
        int i4 = a[2];
        int i5 = a[3];
        m6777a(bArr, i, iArr);
        int[] d = m6784d(m6782c(m6780b(m6779a(new int[]{i2, i3, i4, i5}, iArr), iArr), iArr), iArr);
        int[] a2 = this.f3202d.mo3544a();
        if (d == null || d.length != 4) {
            C0601e_log.m2813d("MD5", "roundFourthArray is error.");
        } else {
            a2[0] = a2[0] + d[0];
            a2[1] = a2[1] + d[1];
            a2[2] = a2[2] + d[2];
            a2[3] = d[3] + a2[3];
        }
        this.f3202d.mo3543a(a2);
    }

    /* renamed from: a */
    private int[] m6779a(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length != 4) {
            C0601e_log.m2813d("MD5", "generateRound1 fail.");
            return iArr;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i + ((((i2 & i3) | ((i2 ^ -1) & i4)) + iArr2[0]) - 680876936);
        int i6 = ((i5 >>> 25) | (i5 << 7)) + i2;
        int i7 = i4 + ((((i6 & i2) | ((i6 ^ -1) & i3)) + iArr2[1]) - 389564586);
        int i8 = ((i7 >>> 20) | (i7 << 12)) + i6;
        int i9 = i3 + ((i8 & i6) | ((i8 ^ -1) & i2)) + iArr2[2] + 606105819;
        int i10 = ((i9 >>> 15) | (i9 << 17)) + i8;
        int i11 = i2 + ((((i10 & i8) | ((i10 ^ -1) & i6)) + iArr2[3]) - 1044525330);
        int i12 = ((i11 >>> 10) | (i11 << 22)) + i10;
        int i13 = i6 + ((((i12 & i10) | ((i12 ^ -1) & i8)) + iArr2[4]) - 176418897);
        int i14 = ((i13 >>> 25) | (i13 << 7)) + i12;
        int i15 = i8 + ((i14 & i12) | ((i14 ^ -1) & i10)) + iArr2[5] + 1200080426;
        int i16 = ((i15 >>> 20) | (i15 << 12)) + i14;
        int i17 = i10 + ((((i16 & i14) | ((i16 ^ -1) & i12)) + iArr2[6]) - 1473231341);
        int i18 = ((i17 >>> 15) | (i17 << 17)) + i16;
        int i19 = i12 + ((((i18 & i16) | ((i18 ^ -1) & i14)) + iArr2[7]) - 45705983);
        int i20 = ((i19 >>> 10) | (i19 << 22)) + i18;
        int i21 = i14 + ((i20 & i18) | ((i20 ^ -1) & i16)) + iArr2[8] + 1770035416;
        int i22 = ((i21 >>> 25) | (i21 << 7)) + i20;
        int i23 = i16 + ((((i22 & i20) | ((i22 ^ -1) & i18)) + iArr2[9]) - 1958414417);
        int i24 = ((i23 >>> 20) | (i23 << 12)) + i22;
        int i25 = i18 + ((((i24 & i22) | ((i24 ^ -1) & i20)) + iArr2[10]) - 42063);
        int i26 = ((i25 >>> 15) | (i25 << 17)) + i24;
        int i27 = i20 + ((((i26 & i24) | ((i26 ^ -1) & i22)) + iArr2[11]) - 1990404162);
        int i28 = ((i27 >>> 10) | (i27 << 22)) + i26;
        int i29 = i22 + ((i28 & i26) | ((i28 ^ -1) & i24)) + iArr2[12] + 1804603682;
        int i30 = ((i29 >>> 25) | (i29 << 7)) + i28;
        int i31 = i24 + ((((i30 & i28) | ((i30 ^ -1) & i26)) + iArr2[13]) - 40341101);
        int i32 = ((i31 >>> 20) | (i31 << 12)) + i30;
        int i33 = i26 + ((((i32 & i30) | ((i32 ^ -1) & i28)) + iArr2[14]) - 1502002290);
        int i34 = ((i33 >>> 15) | (i33 << 17)) + i32;
        int i35 = i28 + ((i34 & i32) | ((i34 ^ -1) & i30)) + iArr2[15] + 1236535329;
        return new int[]{i30, ((i35 >>> 10) | (i35 << 22)) + i34, i34, i32};
    }

    /* renamed from: b */
    private int[] m6780b(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length != 4) {
            C0601e_log.m2813d("MD5", "generateRound1 fail.");
            return iArr;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i + ((((i2 & i4) | ((i4 ^ -1) & i3)) + iArr2[1]) - 165796510);
        int i6 = ((i5 >>> 27) | (i5 << 5)) + i2;
        int i7 = i4 + ((((i6 & i3) | ((i3 ^ -1) & i2)) + iArr2[6]) - 1069501632);
        int i8 = ((i7 >>> 23) | (i7 << 9)) + i6;
        int i9 = i3 + ((i8 & i2) | ((i2 ^ -1) & i6)) + iArr2[11] + 643717713;
        int i10 = ((i9 >>> 18) | (i9 << 14)) + i8;
        int i11 = i2 + ((((i10 & i6) | ((i6 ^ -1) & i8)) + iArr2[0]) - 373897302);
        int i12 = ((i11 >>> 12) | (i11 << 20)) + i10;
        int i13 = i6 + ((((i12 & i8) | ((i8 ^ -1) & i10)) + iArr2[5]) - 701558691);
        int i14 = ((i13 >>> 27) | (i13 << 5)) + i12;
        int i15 = i8 + ((i14 & i10) | ((i10 ^ -1) & i12)) + iArr2[10] + 38016083;
        int i16 = ((i15 >>> 23) | (i15 << 9)) + i14;
        int i17 = i10 + ((((i16 & i12) | ((i12 ^ -1) & i14)) + iArr2[15]) - 660478335);
        int i18 = ((i17 >>> 18) | (i17 << 14)) + i16;
        int i19 = i12 + ((((i18 & i14) | ((i14 ^ -1) & i16)) + iArr2[4]) - 405537848);
        int i20 = ((i19 >>> 12) | (i19 << 20)) + i18;
        int i21 = i14 + ((i20 & i16) | ((i16 ^ -1) & i18)) + iArr2[9] + 568446438;
        int i22 = ((i21 >>> 27) | (i21 << 5)) + i20;
        int i23 = i16 + ((((i22 & i18) | ((i18 ^ -1) & i20)) + iArr2[14]) - 1019803690);
        int i24 = ((i23 >>> 23) | (i23 << 9)) + i22;
        int i25 = i18 + ((((i24 & i20) | ((i20 ^ -1) & i22)) + iArr2[3]) - 187363961);
        int i26 = ((i25 >>> 18) | (i25 << 14)) + i24;
        int i27 = i20 + ((i26 & i22) | ((i22 ^ -1) & i24)) + iArr2[8] + 1163531501;
        int i28 = ((i27 >>> 12) | (i27 << 20)) + i26;
        int i29 = i22 + ((((i28 & i24) | ((i24 ^ -1) & i26)) + iArr2[13]) - 1444681467);
        int i30 = ((i29 >>> 27) | (i29 << 5)) + i28;
        int i31 = i24 + ((((i30 & i26) | ((i26 ^ -1) & i28)) + iArr2[2]) - 51403784);
        int i32 = ((i31 >>> 23) | (i31 << 9)) + i30;
        int i33 = i26 + ((i32 & i28) | ((i28 ^ -1) & i30)) + iArr2[7] + 1735328473;
        int i34 = ((i33 >>> 18) | (i33 << 14)) + i32;
        int i35 = i28 + ((((i34 & i30) | ((i30 ^ -1) & i32)) + iArr2[12]) - 1926607734);
        return new int[]{i30, ((i35 >>> 12) | (i35 << 20)) + i34, i34, i32};
    }

    /* renamed from: c */
    private int[] m6782c(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length != 4) {
            C0601e_log.m2813d("MD5", "generateRound1 fail.");
            return iArr;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i + ((((i2 ^ i3) ^ i4) + iArr2[5]) - 378558);
        int i6 = ((i5 >>> 28) | (i5 << 4)) + i2;
        int i7 = i4 + ((((i6 ^ i2) ^ i3) + iArr2[8]) - 2022574463);
        int i8 = ((i7 >>> 21) | (i7 << 11)) + i6;
        int i9 = i3 + ((i8 ^ i6) ^ i2) + iArr2[11] + 1839030562;
        int i10 = ((i9 >>> 16) | (i9 << 16)) + i8;
        int i11 = i2 + ((((i10 ^ i8) ^ i6) + iArr2[14]) - 35309556);
        int i12 = ((i11 >>> 9) | (i11 << 23)) + i10;
        int i13 = i6 + ((((i12 ^ i10) ^ i8) + iArr2[1]) - 1530992060);
        int i14 = ((i13 >>> 28) | (i13 << 4)) + i12;
        int i15 = i8 + ((i14 ^ i12) ^ i10) + iArr2[4] + 1272893353;
        int i16 = ((i15 >>> 21) | (i15 << 11)) + i14;
        int i17 = i10 + ((((i16 ^ i14) ^ i12) + iArr2[7]) - 155497632);
        int i18 = ((i17 >>> 16) | (i17 << 16)) + i16;
        int i19 = i12 + ((((i18 ^ i16) ^ i14) + iArr2[10]) - 1094730640);
        int i20 = ((i19 >>> 9) | (i19 << 23)) + i18;
        int i21 = i14 + ((i20 ^ i18) ^ i16) + iArr2[13] + 681279174;
        int i22 = ((i21 >>> 28) | (i21 << 4)) + i20;
        int i23 = i16 + ((((i22 ^ i20) ^ i18) + iArr2[0]) - 358537222);
        int i24 = ((i23 >>> 21) | (i23 << 11)) + i22;
        int i25 = i18 + ((((i24 ^ i22) ^ i20) + iArr2[3]) - 722521979);
        int i26 = ((i25 >>> 16) | (i25 << 16)) + i24;
        int i27 = i20 + ((i26 ^ i24) ^ i22) + iArr2[6] + 76029189;
        int i28 = ((i27 >>> 9) | (i27 << 23)) + i26;
        int i29 = i22 + ((((i28 ^ i26) ^ i24) + iArr2[9]) - 640364487);
        int i30 = ((i29 >>> 28) | (i29 << 4)) + i28;
        int i31 = i24 + ((((i30 ^ i28) ^ i26) + iArr2[12]) - 421815835);
        int i32 = ((i31 >>> 21) | (i31 << 11)) + i30;
        int i33 = i26 + ((i32 ^ i30) ^ i28) + iArr2[15] + 530742520;
        int i34 = ((i33 >>> 16) | (i33 << 16)) + i32;
        int i35 = i28 + ((((i34 ^ i32) ^ i30) + iArr2[2]) - 995338651);
        return new int[]{i30, ((i35 >>> 9) | (i35 << 23)) + i34, i34, i32};
    }

    /* renamed from: d */
    private int[] m6784d(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length != 4) {
            C0601e_log.m2813d("MD5", "generateRound1 fail.");
            return iArr;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i + (((((i4 ^ -1) | i2) ^ i3) + iArr2[0]) - 198630844);
        int i6 = ((i5 >>> 26) | (i5 << 6)) + i2;
        int i7 = i4 + (((i3 ^ -1) | i6) ^ i2) + iArr2[7] + 1126891415;
        int i8 = ((i7 >>> 22) | (i7 << 10)) + i6;
        int i9 = i3 + (((((i2 ^ -1) | i8) ^ i6) + iArr2[14]) - 1416354905);
        int i10 = ((i9 >>> 17) | (i9 << 15)) + i8;
        int i11 = i2 + (((((i6 ^ -1) | i10) ^ i8) + iArr2[5]) - 57434055);
        int i12 = ((i11 >>> 11) | (i11 << 21)) + i10;
        int i13 = i6 + (((i8 ^ -1) | i12) ^ i10) + iArr2[12] + 1700485571;
        int i14 = ((i13 >>> 26) | (i13 << 6)) + i12;
        int i15 = i8 + (((((i10 ^ -1) | i14) ^ i12) + iArr2[3]) - 1894986606);
        int i16 = ((i15 >>> 22) | (i15 << 10)) + i14;
        int i17 = i10 + (((((i12 ^ -1) | i16) ^ i14) + iArr2[10]) - 1051523);
        int i18 = ((i17 >>> 17) | (i17 << 15)) + i16;
        int i19 = i12 + (((((i14 ^ -1) | i18) ^ i16) + iArr2[1]) - 2054922799);
        int i20 = ((i19 >>> 11) | (i19 << 21)) + i18;
        int i21 = i14 + (((i16 ^ -1) | i20) ^ i18) + iArr2[8] + 1873313359;
        int i22 = ((i21 >>> 26) | (i21 << 6)) + i20;
        int i23 = i16 + (((((i18 ^ -1) | i22) ^ i20) + iArr2[15]) - 30611744);
        int i24 = ((i23 >>> 22) | (i23 << 10)) + i22;
        int i25 = i18 + (((((i20 ^ -1) | i24) ^ i22) + iArr2[6]) - 1560198380);
        int i26 = ((i25 >>> 17) | (i25 << 15)) + i24;
        int i27 = i20 + (((i22 ^ -1) | i26) ^ i24) + iArr2[13] + 1309151649;
        int i28 = ((i27 >>> 11) | (i27 << 21)) + i26;
        int i29 = i22 + (((((i24 ^ -1) | i28) ^ i26) + iArr2[4]) - 145523070);
        int i30 = ((i29 >>> 26) | (i29 << 6)) + i28;
        int i31 = i24 + (((((i26 ^ -1) | i30) ^ i28) + iArr2[11]) - 1120210379);
        int i32 = ((i31 >>> 22) | (i31 << 10)) + i30;
        int i33 = i26 + (((i28 ^ -1) | i32) ^ i30) + iArr2[2] + 718787259;
        int i34 = ((i33 >>> 17) | (i33 << 15)) + i32;
        int i35 = i28 + (((((i30 ^ -1) | i34) ^ i32) + iArr2[9]) - 343485551);
        return new int[]{i30, ((i35 >>> 11) | (i35 << 21)) + i34, i34, i32};
    }

    /* renamed from: a */
    private void m6773a(C1174k kVar, byte[] bArr, int i, int i2) {
        int i3;
        m6772a((C1174k) null);
        if (i2 - i > bArr.length) {
            i2 = bArr.length - i;
        }
        int b = (int) (kVar.mo3545b() & 63);
        kVar.mo3541a(kVar.mo3545b() + ((long) i2));
        int i4 = 64 - b;
        if (i2 >= i4) {
            int[] iArr = new int[16];
            if (i4 == 64) {
                i4 = 0;
            } else {
                byte[] c = kVar.mo3546c();
                for (int i5 = 0; i5 < i4; i5++) {
                    c[i5 + b] = bArr[i5 + i];
                }
                kVar.mo3542a(c);
                m6774a(kVar, kVar.mo3546c(), 0, iArr);
            }
            i3 = i4;
            while (i3 + 63 < i2) {
                m6774a(kVar, bArr, i3 + i, iArr);
                i3 += 64;
            }
            b = 0;
        } else {
            i3 = 0;
        }
        if (i3 < i2) {
            byte[] c2 = kVar.mo3546c();
            for (int i6 = i3; i6 < i2; i6++) {
                c2[(b + i6) - i3] = bArr[i6 + i];
            }
            kVar.mo3542a(c2);
        }
    }

    /* renamed from: a */
    private void m6776a(byte[] bArr, int i) {
        m6773a(this.f3202d, bArr, 0, i);
    }

    /* renamed from: a */
    private void m6775a(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            bArr = new byte[0];
        }
        m6776a(bArr, bArr.length);
    }

    /* renamed from: a */
    private byte[] m6778a(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            bArr[i2] = (byte) (iArr[i3] & 255);
            bArr[i2 + 1] = (byte) ((iArr[i3] >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((iArr[i3] >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((iArr[i3] >>> 24) & 255);
            i2 += 4;
            i3++;
        }
        return bArr;
    }

    /* renamed from: d */
    private byte[] m6783d() {
        byte[] a;
        synchronized (f3201c) {
            if (this.f3203e == null) {
                C1174k kVar = new C1174k(this.f3202d);
                byte[] a2 = m6778a(new int[]{(int) (kVar.mo3545b() << 3), (int) (kVar.mo3545b() >> 29)}, 8);
                int b = (int) (kVar.mo3545b() & 63);
                m6773a(kVar, f3199a, 0, b < 56 ? 56 - b : 120 - b);
                m6773a(kVar, a2, 0, 8);
                this.f3203e = kVar;
            }
            a = m6778a(this.f3203e.mo3544a(), 16);
        }
        return a;
    }

    /* renamed from: a */
    private synchronized void m6772a(C1174k kVar) {
        this.f3203e = kVar;
    }

    /* renamed from: a */
    private static String m6771a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= bArr.length) {
                return new String(cArr);
            }
            int i4 = i2 + 1;
            cArr[i2] = f3200b[(bArr[i3] >>> 4) & 15];
            i2 = i4 + 1;
            cArr[i4] = f3200b[bArr[i3] & 15];
            i = i3 + 1;
        }
    }

    /* renamed from: a */
    public String mo3539a() {
        return m6771a(m6783d());
    }

    /* renamed from: b */
    public byte[] mo3540b() {
        return m6783d();
    }

}
