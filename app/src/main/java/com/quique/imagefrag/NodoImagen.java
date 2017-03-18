package com.quique.imagefrag;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Quique on 17/03/2017.
 */

public class NodoImagen implements Serializable {
    private int Recurso;
    private boolean Estado;
    private boolean Visitado;

    public int getRecurso() { return this.Recurso; }
    public boolean getEstado() { return this.Estado; }
    public boolean getVisitado() {return this.Visitado; }

    public void setRecuros(int valor) { this.Recurso = valor; }
    public void setEstado(boolean valor) { this.Estado = valor; }
    public void setVisitado(boolean valor) {this.Visitado = valor; }

    public NodoImagen(int valorRecurso) {
        this.Recurso = valorRecurso;
        this.Estado = false;
        this.Visitado = false;
    }
}
