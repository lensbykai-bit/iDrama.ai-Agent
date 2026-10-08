package ai.idrama.agent;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.Gravity;
public class MainActivity extends Activity {
    private static final String APP_URL = "https://lensbykai-bit.github.io/iDrama.ai-Agent/";
    private static final String APP_HOST = "lensbykai-bit.github.io";
    private WebView web;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(Color.rgb(9,15,30));
        getWindow().setNavigationBarColor(Color.rgb(9,15,30));
        FrameLayout layout = new FrameLayout(this);
        layout.setBackgroundColor(Color.rgb(9,15,30));
        web = new WebView(this);
        layout.addView(web,new FrameLayout.LayoutParams(-1,-1));
        setContentView(layout);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(false);
        s.setAllowContentAccess(false);
        s.setJavaScriptCanOpenWindowsAutomatically(false);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient() {
           @Override public boolean shouldOverrideUrlLoading(WebView view,WebResourceRequest request) {
              Uri uri=request.getUrl();
              if ("https".equalsIgnoreCase(uri.getScheme()) && APP_HOST.equalsIgnoreCase(uri.getHost()) && uri.getPath()!=null && uri.getPath().startsWith("/iDrama.ai-Agent/")) return false;
              try {startActivity(new Intent(Intent.ACTION_VIEW,uri));} catch(Exception ignored){}
              return true;
           }
           @Override public void onReceivedError(WebView view,WebResourceRequest request,android.webkit.WebResourceError error) {
              if (request.isForMainFrame()) showError(layout);
           }
        });
        web.loadUrl(APP_URL);
    }
    private void showError(FrameLayout layout) {
        if(isFinishing()) return;
        layout.removeAllViews();
        TextView text=new TextView(this);
        text.setText("Unable to open iDrama.ai Agent. Check your internet connection.\n\nTap here to retry.");
        text.setTextColor(Color.WHITE);
        text.setTextSize(17);
        text.setGravity(Gravity.CENTER);
        text.setPadding(36,36,36,36);
        layout.addView(text,new FrameLayout.LayoutParams(-1,-1));
        text.setOnClickListener(v->{layout.removeView(text);layout.addView(web,new FrameLayout.LayoutParams(-1,-1));web.loadUrl(APP_URL);});
    }
    @Override public void onBackPressed() { if(web!=null && web.getParent()!=null && web.canGoBack()) web.goBack(); else super.onBackPressed(); }
    @Override protected void onDestroy() { if(web!=null){if(web.getParent() instanceof ViewGroup)((ViewGroup)web.getParent()).removeView(web);web.destroy();web=null;}super.onDestroy(); }
}
