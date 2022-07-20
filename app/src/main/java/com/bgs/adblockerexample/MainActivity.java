package com.bgs.adblockerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bgs.adblocker.Mywebview.AdBlocker;
import com.bgs.adblocker.Mywebview.MyCWebview;
import com.bgs.adblocker.WebViewAdBlock;


public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdBlocker.init(this);

        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview_view);
        Log.d("MainActivity", "this is ");
        webView.setWebViewClient(new MyCWebview(){
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:window.HtmlViewer.showHTML('<head>' + document.getElementsByTagName('html')[0].innerHTML + '</head>');");
                super.onPageFinished(view, url);

            }
        });
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);
        MyJavascriptInterface jInterface = new MyJavascriptInterface(this);
        webView.addJavascriptInterface(jInterface, "HtmlViewer");

        webView.loadUrl(" ");

        Log.d("MainActivity", ""+ webView.getUrl());
    }
}