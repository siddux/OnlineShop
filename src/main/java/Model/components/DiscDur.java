package Model.components;

import Model.*;

public class DiscDur extends Memoria {

    private String _tipusDisc;


    public DiscDur (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, int capacitatMemoria, String tipusDisc) {

        super(fabricant, codiProducte, descripcioProducte, preuVenda, capacitatMemoria);
        this._tipusDisc          = tipusDisc;

    }

    public String getTipusDisc (){
        return _tipusDisc;
    }

    public void setTipusDisc (String tipusDisc){
        this._tipusDisc = tipusDisc;
    }

    @Override
    public String toString (){
        return "Disc dur " + _tipusDisc + "\n" +
               super.toString();
    }

}