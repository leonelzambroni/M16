package com.examplem16.vics_0.m16;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private View btnServicios;
    private View btnBeneficios;
    private View btnRadio;
    private View btnCursos;
    private View btnCredencial;
    private View btnContacto;
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


    btnServicios =  (Button) findViewById(R.id.btnServicios);

        btnServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent servicios = new Intent(MainActivity.this,ServiciosActivity.class);
                startActivity(servicios);

            }
        });

        btnBeneficios = (Button) findViewById(R.id.btnBeneficios);

        btnBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent beneficios = new Intent(MainActivity.this,BeneficiosActivity.class);
                startActivity(beneficios);
            }
        });
        btnCursos = (Button) findViewById(R.id.btnCursos);
        btnCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cursos = new Intent(MainActivity.this,CursosActivity.class);
                startActivity(cursos);
            }
        });
        btnRadio = (Button) findViewById(R.id.btnRadio);
        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent radio = new Intent(MainActivity.this,RadioActivity.class);
                startActivity(radio);
            }
        });

        btnContacto = (Button) findViewById(R.id.btnContactos);
        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contacto = new Intent(MainActivity.this,Contacto.class);
                startActivity(contacto);
            }
        });

        btnCredencial = (Button) findViewById(R.id.btnCredencial);
        btnCredencial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"En construccion",Toast.LENGTH_LONG).show();
            }
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
