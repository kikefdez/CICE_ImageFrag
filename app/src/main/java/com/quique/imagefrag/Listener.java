package com.quique.imagefrag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Quique on 18/03/2017.
 */

public class Listener implements View.OnClickListener {
    private NodoImagen[] galeria;
    private int position;

    public Listener(NodoImagen[] valorImagen, int valorPosition) {
        this.galeria = valorImagen;
        this.position = valorPosition;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLike:
                galeria[position].setEstado(true);
                break;
            case R.id.btnDislike:
                galeria[position].setEstado(false);
                break;
        }

        galeria[position].setVisitado(true);

        Activity actividadPadre = (Activity)v.getContext();
        ViewPager viewPager = (ViewPager)actividadPadre.findViewById(R.id.viewPager);

        if((position + 1) < galeria.length){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        } else {
            Intent intent = new Intent(v.getContext(), Resultados.class);
            Bundle b = new Bundle();
            b.putSerializable("galeria", galeria);
            intent.putExtras(b);
            v.getContext().startActivity(intent);
        }
    }
}
