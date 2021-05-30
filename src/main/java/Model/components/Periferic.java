package Model.components;

import Model.*;

public abstract class Periferic extends ComponentBase {

    private String _tipusPort;

    public Periferic (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, String tipusPort){

        super(fabricant, codiProducte, descripcioProducte, preuVenda );
        this._tipusPort = tipusPort;
    }

    public String getTipusPort (){
        return _tipusPort;
    }

    public void setTipusPort (String tipusPort){
        this._tipusPort = tipusPort;
    }

    @Override
    public String toString (){
        return "Tipus de port: " + _tipusPort + "\n" +
               super.toString() + "\n";
    }


}
