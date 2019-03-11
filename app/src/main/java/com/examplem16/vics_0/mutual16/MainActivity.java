package com.examplem16.vics_0.mutual16;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.IOException;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class MainActivity extends AppCompatActivity {

    private GifImageView btnServicios;
    private GifImageView btnBeneficios;
    private GifImageView btnRadio;
    private GifImageView btnCursos;
    private GifImageView btnCredencial;
    private GifImageView btnContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    btnServicios =  (GifImageView) findViewById(R.id.btnServicios);

        btnServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent servicios = new Intent(MainActivity.this,ServiciosActivity.class);
                startActivity(servicios);

            }
        });

        btnBeneficios = (GifImageView) findViewById(R.id.btnBeneficios);

        btnBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent beneficios = new Intent(MainActivity.this,BeneficiosActivity.class);
                startActivity(beneficios);
            }
        });
        btnCursos = (GifImageView) findViewById(R.id.btnCursos);
        btnCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cursos = new Intent(MainActivity.this,CursosActivity.class);
                startActivity(cursos);
            }
        });
        btnRadio = (GifImageView) findViewById(R.id.btnRadio);
        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent radio = new Intent(MainActivity.this,RadioActivity.class);
                startActivity(radio);
            }
        });

        btnContacto = (GifImageView) findViewById(R.id.btnContactos);
        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contacto = new Intent(MainActivity.this,Contacto.class);
                startActivity(contacto);
            }
        });

        btnCredencial = (GifImageView) findViewById(R.id.btnCredencial);
        btnCredencial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent credencial = new Intent(MainActivity.this,CredencialActivity.class);
                startActivity(credencial);            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
