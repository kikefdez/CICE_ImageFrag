package com.quique.imagefrag;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final NodoImagen[] listado = new NodoImagen[]{
            new NodoImagen(R.drawable.foto01),
            new NodoImagen(R.drawable.foto02),
            new NodoImagen(R.drawable.foto03),
            new NodoImagen(R.drawable.foto04),
            new NodoImagen(R.drawable.foto05),
            new NodoImagen(R.drawable.foto06),
            new NodoImagen(R.drawable.foto07),
            new NodoImagen(R.drawable.foto08),
            new NodoImagen(R.drawable.foto09),
            new NodoImagen(R.drawable.foto10),
            new NodoImagen(R.drawable.foto11),
            new NodoImagen(R.drawable.foto12)
    };
    private static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getCanonicalName(), "Entro en el onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(getClass().getCanonicalName(), "Recupero el ViewPager");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Log.d(getClass().getCanonicalName(), "Asigno el PageAdapter");
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), listado));
    }

    @Override
    public void onBackPressed() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        if(viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }

    public static ViewPager recuperarVP(){
        return viewPager;
    }
}
