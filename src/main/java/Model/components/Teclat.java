package Model.components;

import Model.Fabricant;

public class Teclat extends Periferic{

    private String _idioma;


    public Teclat (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda, String tipusPort, String idioma) {

        super(fabricant, codiProducte, descripcioProducte, preuVenda, tipusPort);
        this._idioma       = idioma;

    }

    public String getIdioma (){
        return _idioma;
    }

    public void setIdioma (String idioma){
        this._idioma = idioma;
    }

    @Override
    public String toString (){
        return "Teclat " + ":\n" +
               "Idioma: " + _idioma + "\n" +
               super.toString();
    }

}
