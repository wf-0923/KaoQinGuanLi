package com.example.wangfan.wf_kaoqin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView)findViewById(R.id.activity_main_webview);
        //这句可以让界面跳转时，不自动打开手机默认浏览器，让程序只在webview中运行
//        如果换网络的话需要改
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://10.115.1.241:8080/WF_KQGL_Server_war_exploded/");
    }
}
