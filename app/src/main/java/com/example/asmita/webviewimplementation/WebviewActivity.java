package com.example.asmita.webviewimplementation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    private WebView webview;
    String userQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webview = (WebView)findViewById(R.id.webview);

        if(savedInstanceState==null) {
            Bundle extras = getIntent().getExtras();
            userQuery = extras.getString("key");
        }
        else {
            userQuery = (String)savedInstanceState.getSerializable("key");
        }

        WebSettings mySettings = webview.getSettings();
        mySettings.setJavaScriptEnabled(true);
        webview.loadUrl("http://www.downloads-nl.net/results/mp3/1/"+userQuery);
        webview.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack())
            webview.goBack();
        else {
            WebviewActivity.this.finish();
            Intent intent = new Intent(WebviewActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
