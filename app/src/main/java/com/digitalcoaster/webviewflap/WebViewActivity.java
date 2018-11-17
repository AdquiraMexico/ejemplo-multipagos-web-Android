package com.digitalcoaster.webviewflap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        setContentView(webView);
        postDataWeb2();


    }

    public void postDataWeb(){
        String postData = null;
        try {
            postData =
            "mp_account=" + URLEncoder.encode("3202", "UTF-8") +
            "&mp_customername=" + URLEncoder.encode("PRUEBAS BANCOMER", "UTF-8")+
            "&mp_order=" + URLEncoder.encode("2018111500000", "UTF-8") +
            "&mp_reference=" + URLEncoder.encode("ABCDE12345", "UTF-8")+
            "&mp_product=" + URLEncoder.encode("1", "UTF-8") +
            "&mp_node=" + URLEncoder.encode("1", "UTF-8")+
            "&mp_concept=" + URLEncoder.encode("99", "UTF-8") +
            "&mp_amount=" + URLEncoder.encode("150.00", "UTF-8")+
            "&mp_currency=" + URLEncoder.encode("1", "UTF-8")+
            "&mp_urlsuccess=" + URLEncoder.encode("https://www.egbs5.com.mx/egobierno/operacion/respuesta.jsp", "UTF-8") +
            "&mp_urlfailure=" + URLEncoder.encode("https://www.egbs5.com.mx/egobierno/operacion/respuesta.jsp", "UTF-8")+
            "&mp_signature=" + URLEncoder.encode("MrQSwFwMlr834ZCsvINkWsAW2KQ=");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        webView.postUrl(url,postData.getBytes());
    }

    public void postDataWeb2(){
        String url = "https://prepro.adquiracloud.mx/clb/endpoint/flapMexico";
        String postData = null;
        postData = "mp_account=3202" +
                "&mp_customername=PRUEBAS BANCOMER" +
                "&mp_order=2018111500000" +
                "&mp_reference=ABCDE12345" +
                "&mp_product=1" +
                "&mp_node=1" +
                "&mp_concept=99" +
                "&mp_amount=150.00" +
                "&mp_currency=1" +
                "&mp_urlsuccess=https://www.egbs5.com.mx/egobierno/operacion/respuesta.jsp" +
                "&mp_urlfailure=https://www.egbs5.com.mx/egobierno/operacion/respuesta.jsp" +
                "&mp_signature=MrQSwFwMlr834ZCsvINkWsAW2KQ=";

        webView.postUrl(url,postData.getBytes());

        //webView.postUrl(url,EncodingUtils.getBytes(postData, "utf-8"));

    }


}
