package Model.components;

import Model.Fabricant;

public class Ratoli extends Periferic {

    private int _nombreBotons;


    public Ratoli(Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, String tipusPort, int nombreBotons) {

        super(fabricant, codiProducte, descripcioProducte, preuVenda, tipusPort);
        this._nombreBotons       = nombreBotons;

    }

    public int getNombreBotons (){
        return _nombreBotons;
    }

    public void setNombreBotons (int nombreBotons){
        this._nombreBotons = nombreBotons;
    }

    @Override
    public String toString (){
        return "Ratolí " + ":\n" +
               "Nombre de botons: " + _nombreBotons + "\n" +
               super.toString();
    }

}
