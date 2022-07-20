package com.bgs.adblockerexample;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class MyJavascriptInterface {

    private Context context;
    private String Html;

    public String getHtml() {
        return Html;
    }

    public void setHtml(String html) {
        Html = html;
    }

    public MyJavascriptInterface(Context context) {
        this.context = context;
    }
    @JavascriptInterface
    public void showHTML(String _html) {
        setHtml(_html);        //Toast.makeText(ctx, "starting read html intent", Toast.LENGTH_SHORT).show();
        Log.d("javaScript", ""+ getHtml());
    }
}
