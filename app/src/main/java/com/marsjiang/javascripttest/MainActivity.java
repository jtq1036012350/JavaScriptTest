package com.marsjiang.javascripttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShow;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        btnShow = (Button) findViewById(R.id.btn_show);
        webView = (WebView) findViewById(R.id.webView);
    }

    private void initData() {
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings set = webView.getSettings();
        //设置webview支持js
        set.setJavaScriptEnabled(true);
        //设置本地调用对象及其接口
        webView.addJavascriptInterface(new JsInteraction(this), "control");
        webView.loadUrl("file:///android_asset/test.html");
    }

    private void initEvent() {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //本地调用js方法
                webView.loadUrl("javascript:sayHello()");
            }
        });
    }

}
