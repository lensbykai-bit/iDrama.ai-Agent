# iDrama.ai Agent Android release preparation

The GitHub Actions workflow always builds a DEBUG TEST APK, **not suitable for production distribution**.

A signed release build is generated only after configuring GitHub Actions repository secrets:
- IDRAMA_KEYSTORE_BASE64 — base64 of an Android release signing .jks key store
- IDRAMA_KEYSTORE_PASSWORD
- IDRAMA_KEY_ALIAS
- IDRAMA_KEY_PASSWORD

Keep the .jks offline with secure backups: losing it can prevent future signed app updates. Do not share any key, password, or encoded keystore in chat or commit it to the repository.

After setting secrets, manually run "Build Android APK" in the Actions tab. The artifact "iDrama-Agent-Android-Signed-Release" will be produced only if signing succeeds. Verify signed APK on a test device and scan/review before public release.

The application is currently a WebView wrapper of a UI demo. It has no production referral tracking, wallet, payment processing or real account authentication. Do not advertise it as a live earnings app.
