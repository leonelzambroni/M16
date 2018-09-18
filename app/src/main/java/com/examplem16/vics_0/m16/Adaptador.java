package com.examplem16.vics_0.m16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    String datos[][];
    int datosImg[];

    public Adaptador(Context contexto, String[][] datos,int[] datosImg){

        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = datosImg;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView tipo = (TextView) vista.findViewById(R.id.txtContactType);
        TextView contenido = (TextView)vista.findViewById(R.id.txtContactContent);
        ImageView imgContacto = (ImageView) vista.findViewById(R.id.imgContactImage);

        tipo.setText(datos[i][0]);
        contenido.setText(datos[i][1]);
        imgContacto.setImageResource(datosImg[i]);
        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }




}
