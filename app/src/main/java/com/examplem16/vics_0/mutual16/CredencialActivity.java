package com.examplem16.vics_0.mutual16;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CredencialActivity extends AppCompatActivity {


    private View btnGenerar;
    EditText etDNI;
    TextView txtNombre, txtCategoria,txtDNI,txtEstado;
    ImageView imgTarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credencial);


        txtNombre = findViewById(R.id.txtContNombre);
        txtCategoria = findViewById(R.id.txtContCategoria);
        txtDNI = findViewById(R.id.txtContDni);
        txtEstado = findViewById(R.id.txtContEstado);
        btnGenerar = findViewById(R.id.btnGenerar);
        etDNI = findViewById(R.id.etDNI);
        imgTarjeta = findViewById(R.id.imgTarjeta);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new ConsultarDatos().execute("https://m16.gestionempresacba.com/mobile/consulta.php?DNI=" + etDNI.getText().toString());


                //if (txtCategoria.getText()!="") {
                    btnGenerar.setVisibility(View.INVISIBLE);
                    etDNI.setVisibility(View.INVISIBLE);
                    txtCategoria.setVisibility(View.VISIBLE);
                    txtDNI.setVisibility(View.VISIBLE);
                    txtEstado.setVisibility(View.VISIBLE);
                    txtNombre.setVisibility(View.VISIBLE);
                    imgTarjeta.setVisibility(View.VISIBLE);

                //}
                //else
//                {
  //                  Toast.makeText(getApplicationContext(),"DNI Incorrecto",Toast.LENGTH_LONG).show();
    //            }

            }
        });



    }

    private class ConsultarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            JSONArray ja = null;
            try {
                ja = new JSONArray(result);
                txtNombre.setText(ja.getString(0) +" " + ja.getString(1));
                txtCategoria.setText(ja.getString(2));
                txtDNI.setText(ja.getString(3));
                txtEstado.setText(ja.getString(4));



            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }



}
