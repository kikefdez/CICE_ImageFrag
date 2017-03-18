package com.quique.imagefrag;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Quique on 17/03/2017.
 */

public class ScreenFragment extends Fragment {
    private NodoImagen[] datosImagen;
    private int position;

    public ScreenFragment() {}
    public ScreenFragment(NodoImagen[] valorImagen, int valorPosition) {
        this.datosImagen = valorImagen;
        this.position = valorPosition;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(getClass().getCanonicalName(), "Intento inflar la vista con los datos de la imagen");
        View nodo_viewPager = inflater.inflate(R.layout.nodo_viewpager, container, false);
        ((ImageView)nodo_viewPager.findViewById(R.id.imagenNodo)).setImageResource(datosImagen[position].getRecurso());

        ImageButton btnLike = (ImageButton) nodo_viewPager.findViewById(R.id.btnLike);
        ImageButton btnDislike = (ImageButton) nodo_viewPager.findViewById(R.id.btnDislike);

        btnLike.setOnClickListener(new Listener(datosImagen, position));
        btnDislike.setOnClickListener(new Listener(datosImagen, position));

        /*
        if(datosImagen[position].getVisitado()){
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setStroke(5, Color.MAGENTA);
            drawable.setColor(Color.BLACK);

            if(datosImagen[position].getEstado())
                btnLike.setBackgroundDrawable(drawable);
            else
                btnDislike.setBackgroundDrawable(drawable);
        }
        */

        return nodo_viewPager;
    }
}
