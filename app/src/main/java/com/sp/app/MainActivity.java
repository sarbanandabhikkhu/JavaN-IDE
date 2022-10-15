package com.sp.app;

import android.app.Activity;
import android.os.Bundle;
// import android.view.View;
// import android.view.Window;
// import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sp.app.R;

public class MainActivity extends Activity {

  private WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // View decorView = getWindow().getDecorView();
    // int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
    // decorView.setSystemUiVisibility(uiOptions);

    // Window window = this.getWindow();
    // window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    // window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

    webView = (WebView) findViewById(R.id.webView);

    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setDatabaseEnabled(true);
    webView.getSettings().setDomStorageEnabled(true);
    webView.getSettings().setAllowContentAccess(true);
    webView.getSettings().setAllowFileAccess(true);

    webView.setWebViewClient(new WebViewClient());
    webView.setWebChromeClient(new WebChromeClient());
    webView.loadUrl("https://sammapanna.blogspot.com/");
  }
}
