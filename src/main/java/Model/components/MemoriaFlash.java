package Model.components;

import Model.*;

public class MemoriaFlash extends Memoria {

    private int _velocitatLectura;


    public MemoriaFlash (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, int capacitatMemoria, int velocitatLectura) {

        super(fabricant, codiProducte, descripcioProducte, preuVenda, capacitatMemoria);
        this._velocitatLectura   = velocitatLectura;

    }

    public int getVelocitatLectura (){
        return _velocitatLectura;
    }

    public void setVelocitatLectura (int velocitatLectura){
        this._velocitatLectura = velocitatLectura;
    }

    @Override
    public String toString (){
        return "Memoria Flash:\n " +
               "Velocitat de lectura: " + _velocitatLectura + " Mb/s\n" +
               super.toString();
    }
}