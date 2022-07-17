package com.bgs.adblocker;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bgs.adblocker.Mywebview.AdBlocker;

public class WebViewAdBlock extends WebView {

    private Context context;
    private AttributeSet attributeSet;
    private int defStyleAttr;
    private int defStyleRes;
    private WebView webView;

    //private WebviewBinding binding = WebviewBinding.inflate(LayoutInflater.from(getContext()), this, true);


    public WebViewAdBlock(@NonNull Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public WebViewAdBlock(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attributeSet = attrs;
        initView();
    }

    public WebViewAdBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attributeSet = attrs;
        this.defStyleAttr = defStyleAttr;
        initView();
    }


    public WebViewAdBlock(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        this.context = context;
        this.attributeSet = attrs;
        this.defStyleAttr = defStyleAttr;
        this.defStyleRes = defStyleRes;
        initView();
    }

    private void  initView(){

        AdBlocker.init(this.context);
//        webView = binding.getRoot();
//        webView.setWebViewClient(new MyCWebview());

    }
}
