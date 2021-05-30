package Model.components;

import Model.*;

public class MemoriaRAM extends Memoria {

    private String _tipusMemoria;


    public MemoriaRAM (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, int capacitatMemoria, String tipusMemoria) {

        super(fabricant, codiProducte, descripcioProducte, preuVenda, capacitatMemoria);
        this._tipusMemoria       = tipusMemoria;

    }

    public String getTipusMemoria (){
        return _tipusMemoria;
    }

    public void setTipusMemoria (String tipusMemoria){
        this._tipusMemoria = tipusMemoria;
    }

    @Override
    public String toString (){
        return "Memoria RAM " + _tipusMemoria + ":\n" +
               super.toString();
    }
}
