package com.bgs.adblockerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;

import com.bgs.adblocker.Mywebview.MyCWebview;
import com.bgs.adblocker.WebViewAdBlock;

public class MainActivity extends AppCompatActivity {

    private WebViewAdBlock webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview_view);
        webView.setWebViewClient(new MyCWebview());
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);


        webView.loadUrl("https://www.novelupdates.com");

    }
}