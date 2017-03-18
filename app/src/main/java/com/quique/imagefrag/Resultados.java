package com.quique.imagefrag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Resultados extends AppCompatActivity {
    private NodoImagen[] galeria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Intent intent = getIntent();
        galeria = (NodoImagen[]) intent.getSerializableExtra("galeria");

        GridView gridView = (GridView)findViewById(R.id.grid);
        gridView.setAdapter(new GridAdapter(galeria, this));
    }
}
