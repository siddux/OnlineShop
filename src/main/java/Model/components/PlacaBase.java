package Model.components;

import Model.*;

public class PlacaBase extends ComponentBase {

    private String _tipusProcessador;
    private int[] _tamany;
    private String _ranuraMemoria;

    public PlacaBase (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, String tipusProcesador, int amplada, int llargada, String ranuraMemoria){

        super(fabricant, codiProducte, descripcioProducte, preuVenda );
        this._tipusProcessador = tipusProcesador;
        this._tamany           = new int[2];
        this._tamany[0]        = amplada;
        this._tamany[1]        = llargada;
        this._ranuraMemoria    = ranuraMemoria;
    }

    public String getTipusProcessador (){
        return _tipusProcessador;
    }

    public void setTipusProcessador (String tipusProcessador){
        this._tipusProcessador = tipusProcessador;
    }

    public int[] getTamany (){
        return _tamany;
    }

    public void setTamany (int[] tamany){
        this._tamany = tamany;
    }

    public String getRanuraMemoria (){
        return _ranuraMemoria;
    }

    public void setRanuraMemoria (String ranuraMemoria){
        this._ranuraMemoria = ranuraMemoria;
    }

    @Override
    public String toString (){
        return "Placa base :" + "\n" +
               "Tipus de processador: " + _tipusProcessador + "\n" +
               "Tamany: " + _tamany[0] + "x" + _tamany[1] + "\n" +
               "Ranura memoria: " + _ranuraMemoria + "\n" +
               super.toString() + "\n";
    }
}
