package com.example.dhammachakka;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.dhammachakka.R;

public class MainActivity extends Activity {

  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

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

    // WebView webView = new WebView(context);
    WebView webView = findViewById(R.id.webView);

    webView.getSettings().setAppCacheMaxSize(5 * 1024 * 1024); // 5MB
    webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
    webView.getSettings().setAllowFileAccess(true);
    webView.getSettings().setAppCacheEnabled(true);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setDatabaseEnabled(true);
    webView.getSettings().setDomStorageEnabled(true);
    webView.getSettings().setAllowContentAccess(true);

    webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

    webView.setWebViewClient(new WebViewClient());
    webView.setWebChromeClient(new WebChromeClient());

    if (isNetworkAvailable()) {
      // loading online
      webView.loadUrl("https://sarbanandabhikkhu.github.io/DhammaChakka/");
    } else {
      // loading offline
      webView.loadUrl("file:///android_asset/offline.html");
      webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }
  }
}
