package com.examplem16.vics_0.mutual16;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity {

    private TextView txtRadio;
    private Button googlePlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_radio);
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

        final Intent intent = new Intent(Intent.ACTION_VIEW);


        googlePlay =  findViewById(R.id.btnGooglePlay);
        googlePlay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setData(Uri.parse("market://details?id=republica.hosting.RadioM16"));
                startActivity(intent);

            }
        });
        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Raleway-Regular.ttf");
        //txtRadio = (TextView) findViewById(R.id.txtRadio);

        //  txtRadio.setTypeface(type);

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
