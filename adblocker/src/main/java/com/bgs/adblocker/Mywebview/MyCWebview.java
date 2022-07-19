package com.bgs.adblocker.Mywebview;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.bgs.adblocker.WebViewAdBlock;

import java.util.HashMap;
import java.util.Map;


public abstract class MyCWebview extends WebViewClient {


    public static String myUrl = "";


    public static String currentUrl(String current_url){
        current_url = myUrl;
        return current_url;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {


//        myUrl = url;

        super.onPageStarted(view, url, favicon);
    }

    public abstract void pageFinished();

    @Override
    public void onPageFinished(WebView view, String url) {

        view.loadUrl("javascript:window.HtmlViewer.showHTML('<head>' + document.getElementsByTagName('html')[0].innerHTML + '</head>');");
        pageFinished();
        super.onPageFinished(view, url);
    }



    //    @Override
//    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
//
//        currentUrl(url);
//        Log.d("TAG", "This is the url in the webview:" + myUrl);
//
//        super.doUpdateVisitedHistory(view, url, isReload);
//    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {


        view.loadUrl(url);
        return true;
    }

    private Map<String, Boolean> loadedUrls = new HashMap<>();
    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        boolean ad;
        if (!loadedUrls.containsKey(url)) {
            ad = AdBlocker.isAd(url);
            loadedUrls.put(url, ad);
        } else {
            ad = loadedUrls.get(url);
        }
        return ad ? AdBlocker.createEmptyResource() :
                super.shouldInterceptRequest(view, url);
    }

}


