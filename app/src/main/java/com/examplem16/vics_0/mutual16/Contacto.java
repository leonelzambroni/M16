package com.examplem16.vics_0.mutual16;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

public class Contacto extends AppCompatActivity {


    ListView contactos;
    String[][] datos ={
            {"Telefono Fijo","0351-4235244"},
            {"Whatsapp","351-2002828"},
            {"Direccion","Av. Colón 1151 /53"},
            {"E-Mail","info@mutual16.org"}
    };

    int [] datosImg = {R.drawable.baseline_phone_black_48,R.drawable.ic_whatsapp_black_48dp,R.drawable.baseline_location_on_black_48,R.drawable.baseline_email_black_48};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        contactos =  (ListView) findViewById(R.id.lvContacto);

        contactos.setAdapter(new Adaptador(this,datos,datosImg));


        contactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0)
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:03514235244"));
                    startActivity(intent);
                }
                else if (position == 1)
                {
                    PackageManager pm=getPackageManager();
                    try {

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        String url = "https://api.whatsapp.com/send?phone="+"543512002828" ;
                        i.setPackage("com.whatsapp");
                        i.setData(Uri.parse(url));
                        startActivity(i);





                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),"Whatsapp no se encuentra instalado",Toast.LENGTH_LONG);
                    }



                }

                else if (position == 2)
                {
                    String uri = String.format(Locale.ENGLISH, "geo:0,0?q=Av.+Colón+1151,+X5000EPL+Córdoba");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);




                }

                else
                {

                    Intent intent=new Intent(Intent.ACTION_SEND);
                    String[] recipients={"info@mutual16.org"};
                    intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                    intent.setType("text/html");
                    intent.setPackage("com.google.android.gm");
                    startActivity(Intent.createChooser(intent, "Send mail"));



                }

                Log.i("testy", "I Clicked on Row " + position + " and it worked!");
            }


        });
    }
}