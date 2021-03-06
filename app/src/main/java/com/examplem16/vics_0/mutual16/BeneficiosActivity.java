package com.examplem16.vics_0.mutual16;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class BeneficiosActivity extends AppCompatActivity {

    String ShowOrHideWebViewInitialUse = "show";
    private WebView webView;
    private ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_beneficios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_whatsapp_white_48dp);
        fab.setBackgroundTintList(ColorStateList.valueOf(Color
                .parseColor("#4674B7")));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    onClickWhatsApp();
                }
                catch(Exception e)
                {

                }
            };
        });

        spinner = (ProgressBar) findViewById(R.id.progressBar1);
        spinner.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN);

        String url = "https://mutual16.org/prestadores/";
        webView = (WebView) findViewById(R.id.webViewBeneficios);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setUseWideViewPort(true);

        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);


        webView.setWebViewClient(new MyWebViewClient() {



            @Override
            public void onLoadResource(WebView view, String url)
            {

                try {

                    webView.loadUrl("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");

                    webView.loadUrl("javascript:(function() { " +
                            "var head = document.getElementsByTagName('footer')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                    webView.loadUrl("javascript:(function() { " +
                            "var head = document.getElementsByClassName('ssbp-container')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                    webView.loadUrl("javascript:(function getStyle(elem, name) {" +
                            "    // J/S Pro Techniques p136" +
                            "    if (elem.style[name]) {" +
                            "        return elem.style[name];" +
                            "    } else if (elem.currentStyle) {" +
                            "        return elem.currentStyle[name];" +
                            "    }" +
                            "    else if (document.defaultView && document.defaultView.getComputedStyle) {" +
                            "        name = name.replace(/([A-Z])/g, \"-$1\");" +
                            "        name = name.toLowerCase();" +
                            "        s = document.defaultView.getComputedStyle(elem, \"\");" +
                            "        return s && s.getPropertyValue(name);" +
                            "    } else {" +
                            "        return null;" +
                            "    }" + "})()");

                    webView.loadUrl("javascript:(function() {" +
                          "var element = document.getElementById('page-container')," +
                          "padding = getStyle(element, 'paddingTop'); " +
                            "element.style.paddingTop = parseInt(padding, 0) + 0 + 'px';" +"})()");
                    //webView.loadUrl("javascript:(function(){ document.body.style.paddingTop = '0px'})();");
                    //webView.loadUrl("javascript:(function(){ document.body.style.marginTop = '0px'})();");











                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }



            }

            @Override
            public void onPageFinished(WebView web, String url) {
                super.onPageFinished(web, url);
                spinner.setVisibility(View.INVISIBLE);
                setTitle(web.getTitle());

            }

        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }



    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String urlHost = Uri.parse(url).getHost();

            switch (urlHost) {
                case "mutual16.org":
                    return false;
                case "www.mutual16.org":
                    return false;
                case "https://mutual16.org":
                    return false;
                default:
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
            }
        }
        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            super.onPageStarted(webView, url, favicon);
            spinner.setVisibility(View.VISIBLE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
            spinner.setVisibility(View.INVISIBLE);
            setTitle(view.getTitle());

        }


    }

    public void onClickWhatsApp() {

        try {
            PackageManager packageManager = this.getPackageManager();
            Intent i = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone="+"543512002828" ;
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                this.startActivity(i);
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }


}


