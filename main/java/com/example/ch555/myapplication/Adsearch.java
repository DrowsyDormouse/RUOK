package com.example.ch555.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import android.os.Handler;
import android.widget.Toast;

public class Adsearch extends AppCompatActivity{

    private WebView webView;
    private TextView adresult;
    private Handler handler;
    private String addtxt, type, uri;
    private Intent adSearch;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adsearch);

        adSearch = getIntent();
        type = adSearch.getStringExtra("type");
        uri = adSearch.getStringExtra("URI");

        adresult =(TextView)findViewById(R.id.adresult);
        addtxt = adresult.getText().toString();

        Log.e("type : ", type);
        Log.e("addtxt : ", addtxt);
        init_webView();

        handler = new Handler();

        Button btn = (Button)findViewById(R.id.addtxtbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addtxt == null && addtxt.equals("")){
                    Log.e("addtxt : ", addtxt);
                    Toast.makeText(getApplicationContext(),"주소가 입력되지 않았습니다.", Toast.LENGTH_SHORT);
                }else{
                    Intent it;
                    if (type.equals("0")) {     // 타입이 0이면 회원가입 화면으로
                        it = new Intent(Adsearch.this, Register.class);
                        Log.e("addtxt : ", addtxt);
                        it.putExtra("address", addtxt);
                        it.putExtra("URI", uri);
                        startActivity(it);
                        finish();
                    }else if(type.equals("1")){     // 타입이 1이면 알림 설정 창으로
                        it = new Intent( Adsearch.this, reliefarea.class);
                        it.putExtra("address", addtxt);
                        startActivity(it);
                        finish();
                    }else{
                        Log.e("Error/Type", "타입 오류");}
                }
            }
        });

    }

    @SuppressLint("JavascriptInterface")
    private void init_webView() {

        webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.addJavascriptInterface(new AndroidBridge(), "TestApp");
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://codeman77.ivyro.net/getAddress.php");
    }

    private class AndroidBridge{
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3){
            handler.post(new Runnable(){
                public void run(){
                    //@Override
                    adresult.setText(String.format("(%s) %s %s",arg1,arg2,arg3));
                    addtxt = adresult.getText().toString();
                    init_webView();
                }
            });
        }
    }
}
