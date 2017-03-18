package com.quique.imagefrag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Quique on 17/03/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    private NodoImagen[] galeria;

    public PageAdapter(FragmentManager fm, NodoImagen[] listado){
        super(fm);
        galeria = listado;
    }

    @Override
    public int getCount() { return galeria.length; }

    @Override
    public Fragment getItem(int position) {
        Log.d(getClass().getCanonicalName(), "Recupero el elemento con posicion - " + position);
        return new ScreenFragment(galeria, position);
    }
}
