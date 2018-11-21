package com.digitalcoaster.webviewflap;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    String url = "https://prepro.adquiracloud.mx/clb/endpoint/flapMexico";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());


        setContentView(webView);
        postDataWeb2();


    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webView.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                       SslError error) {
            handler.proceed();
        }
    }


    public void postDataWeb2(){
        Log.i("INFO","enviarPOSTWEB");
        String url = "https://prepro.adquiracloud.mx/clb/endpoint/flapMexico";
        String postData = null;
        try{
        postData = "mp_account=3202" +
                "&mp_customername="+URLEncoder.encode("PRUEBAS BANCOMER", "UTF-8") +
                "&mp_order=2018111500000" +
                "&mp_reference=ABCDE12345" +
                "&mp_product=1" +
                "&mp_node=1" +
                "&mp_concept=99" +
                "&mp_amount="+URLEncoder.encode("150.00","UTF-8") +
                "&mp_currency=1" +
                "&mp_urlsuccess="+URLEncoder.encode("https://www.egbs5.com.mx/egobierno/operacion/respuesta.jsp","UTF-8") +
                "&mp_urlfailure="+URLEncoder.encode("https://www.egbs5.com.mx/egobierno/operacion/respuesta.jsp","UTF-8") +
                "&mp_signature=MrQSwFwMlr834ZCsvINkWsAW2KQ=";


            Log.i("INFO",postData);
        }
        catch(IOException ioe){
            //Handle exception here, most of the time you will just log it.
        }
        webView.postUrl(url,postData.getBytes());

        //webView.postUrl(url,EncodingUtils.getBytes(postData, "utf-8"));

    }



}
