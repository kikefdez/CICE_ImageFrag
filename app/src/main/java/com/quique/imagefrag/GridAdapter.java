package com.quique.imagefrag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Quique on 18/03/2017.
 */

public class GridAdapter extends BaseAdapter {
    private Context contexto;
    private NodoImagen[] galeria;

    public GridAdapter(NodoImagen[] galeria, Context contexto){
        this.contexto = contexto;
        this.galeria = galeria;
    }

    @Override
    public int getCount() { return galeria.length; }

    @Override
    public Object getItem(int position) { return galeria[position]; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nodo_gridview, parent, false);
        }
        ((ImageView) convertView.findViewById(R.id.imagen)).setImageResource(galeria[position].getRecurso());
        ((TextView) convertView.findViewById(R.id.leyenda)).setText(galeria[position].getEstado() ? "LIKE" : "DISLIKE");
        return convertView;
    }
}
