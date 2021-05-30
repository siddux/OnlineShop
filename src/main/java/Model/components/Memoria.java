package Model.components;

import Model.*;

public abstract class Memoria extends ComponentBase{

    private int _capacitatMemoria;

    public Memoria (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, int capacitatMemoria){

        super(fabricant, codiProducte, descripcioProducte, preuVenda );
        this._capacitatMemoria   = capacitatMemoria;
    }

    public int getCapacitatMemoria (){
        return _capacitatMemoria;
    }

    public void setCapacitatMemoria (int capacitatMemoria){
        this._capacitatMemoria = capacitatMemoria;
    }

    @Override
    public String toString (){
        return "Capacitat: " + _capacitatMemoria + " GB\n" +
                super.toString() + "\n";
    }

}
