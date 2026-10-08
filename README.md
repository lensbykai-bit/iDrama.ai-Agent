# iDrama.ai Agent — Web App UI Prototype

This is an independent **demonstration-only** static app for GitHub Pages. It has a premium dark navy, cyan and pink UI.

## Demo features
- Khmer register/login screen (local UI demo only; no real user authentication)
- Dashboard, referral link sharing, wallet, profile
- Illustrative referral figures: 410 referrals × $0.025 = $10.25
- Monthly withdrawal schedule displayed as the 5th; withdrawal action disabled

## Security and limitations
- Sample values are **not real earnings**. App does not process actual purchases or payments.
- Fake registration does not verify identity, and passwords are not stored or authenticated. Do **not** enter a real password.
- Sample referral link points to the existing iDrama.ai website but **does not track referrals**.
- No Telegram or KHQR integration yet. Never store bot tokens or backend secrets in static frontend files.
- For production, implement Supabase Auth, secure server-side paid order verification and idempotent referral ledger, RLS, withdrawal approvals, and Telegram access control on server.

## GitHub Pages
Use Settings > Pages > Deploy from a branch > main > / (root). This demo can be previewed at the repository's Pages address once Pages is enabled.
