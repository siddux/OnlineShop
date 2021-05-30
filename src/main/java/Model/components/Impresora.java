package Model.components;

import Model.*;

public class Impresora extends Periferic {

    private String _tipusImpresio;


    public Impresora(Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, String tipusPort, String tipusImpresio) {

        super(fabricant, codiProducte, descripcioProducte, preuVenda, tipusPort);
        this._tipusImpresio      = tipusImpresio;

    }

    public String getTipusImpresio (){
        return _tipusImpresio;
    }

    public void setTipusImpresio (String tipusImpresio){
        this._tipusImpresio = tipusImpresio;
    }

    @Override
    public String toString (){
        return "Impresora " + ":\n" +
               "Tipus de impresio: " + _tipusImpresio + "\n" +
               super.toString();
    }

}
