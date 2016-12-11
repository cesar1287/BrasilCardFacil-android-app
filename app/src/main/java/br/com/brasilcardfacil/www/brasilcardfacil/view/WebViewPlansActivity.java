package br.com.brasilcardfacil.www.brasilcardfacil.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.com.brasilcardfacil.www.brasilcardfacil.R;

public class WebViewPlansActivity extends AppCompatActivity {

    WebView myWebView;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_plans);

        link = getIntent().getStringExtra("link");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                myWebView = (WebView) findViewById(R.id.webview);
                myWebView.setWebViewClient(new WebViewClient());
                WebSettings webSettings = myWebView.getSettings();
                webSettings.setUseWideViewPort(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setJavaScriptEnabled(true);
                webSettings.setBuiltInZoomControls(true);
                myWebView.loadUrl(link);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
