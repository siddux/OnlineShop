package Model;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Objects;

public class Fabricant {

	@BsonProperty(value = "codi_fabricant")
	private int _codiFabricant;
	@BsonProperty(value = "nom_fabricant")
	private String _nomFabricant;
	@BsonProperty(value = "telefon")
	private int _telefon;
	
	public Fabricant(int codiFabricant, String nomFabricant, int telefon) {
		
		this._codiFabricant = codiFabricant;
		this._nomFabricant  = nomFabricant;
		this._telefon       = telefon;
	}
	
	public Fabricant(Fabricant fabricant) {
		
		this._codiFabricant = fabricant._codiFabricant;
		this._nomFabricant  = fabricant._nomFabricant;
		this._telefon       = fabricant._telefon;
		
	}

	public Fabricant() {}
	
	public int getCodiFabricant(){
		
		return _codiFabricant;
		
	}

	public void setCodiFabricant(int codiFabricant){

		this._codiFabricant = codiFabricant;

	}
	
	public String getNomFabricant() {
		
		return new String(_nomFabricant);
				
	}

	public void setNomFabricant(String nomFabricant) {

		this._nomFabricant = new String(nomFabricant);

	}
	
	public int getTelefon() {
		
		return _telefon;
		
	}

	public void setTelefon(int telefon) {

		this._telefon = telefon;

	}

	@Override
	public String toString (){

		return "Fabricant: " + "\n" +
			   " Codi fabricant: " + _codiFabricant + "\n" +
			   " Nom fabricant: " + _nomFabricant + "\n" +
			   " Numero telefon: " + _telefon + "\n";

	}

	@Override
	public boolean equals (Object o){
		if ( this == o ) return true;
		if ( !(o instanceof Fabricant) ) return false;
		Fabricant fabricant = (Fabricant) o;
		return _codiFabricant == fabricant._codiFabricant;
	}

	@Override
	public int hashCode (){
		return Objects.hash( _codiFabricant );
	}
}



