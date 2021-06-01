# KobackupCipherTool

This is the result of my reverse engineering effort of the Huawei Kobackup application. Kobackup is a backend component of Hisuite, an app running on Android handsets. 

You can use this tool to decrypt backup packages created by Hisuite and also to craft backup packages yourself.

Examples:

```
java irsl.CheckMsgV3Tool com.amazon.mShop.android.shopping.tar 12345678xX df264714a68a9224fef4302b29f8eea7ac11f5baada015a55b6e7f43190ba9f379c89c57d17d4eb1df0259c24c56b045dacc39a45275ea9be3b4d465f57583b3
java irsl.BackupSecurityV3DecryptionTool setting.db 12345678xX ca8ae6026225e3fc04cab5287ab84179705bb8216463d2f843bdc8ebb9c02128e0fbc0ba76d282b3df46db45c9cdfcc6 setting.db.clear
java irsl.BackupSecurityV3DecryptionTool wifiConfig.db 12345678xX 1ffeee986ed96ac3177888ab8899bfe0b9a46820cea632dc44658557164255b8952dd7ff156bb8fa26ca1a03279350f4 wifiConfig.db.clear
java irsl.BackupSecurityV3DecryptionTool com.amazon.mShop.android.shopping.tar 12345678xX cc34f2df1066e4125019b227e2cb01e3d08878f8ac1bb3c6fd5e7b54f715520be87ee9ada5945646260619fee3051911 com.amazon.mShop.android.shopping.tar.tar
```
