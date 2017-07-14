package com.marsjiang.javascripttest;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Jiang on 2017-07-14.
 */

public class JsInteraction {
    private Context context;
    public JsInteraction(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void toastMessage(String message) {   //提供给js调用的方法
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
