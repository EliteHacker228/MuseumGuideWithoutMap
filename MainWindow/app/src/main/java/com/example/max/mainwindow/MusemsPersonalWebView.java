package com.example.max.mainwindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MusemsPersonalWebView extends AppCompatActivity {

    WebView webview;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musems_personal_web_view);
        webview=findViewById(R.id.museums_webview);
        setTitle("Веб-сайт музея");
        Intent intent = getIntent();
        URL=intent.getStringExtra("URL");
        Log.d("URL loading: ", intent.getStringExtra("URL"));
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(URL);

        webview.setWebViewClient(new MyWebViewClient());

    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
