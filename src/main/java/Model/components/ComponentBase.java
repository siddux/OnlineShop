package Model.components;

import Model.*;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class ComponentBase{

	@BsonProperty(value = "fabricant")
	private Fabricant _fabricant;
	@BsonProperty(value = "codi_producte")
	private int _codiProducte;
	@BsonProperty(value = "descripcio_producte")
	private String _descripcioProducte;
	@BsonProperty(value = "preu_venda")
	private double _preuVenda;
	
	
	public ComponentBase (Fabricant fabricant, int codiProducte, String descripcioProducte, double preuVenda) {
		
		this._fabricant          = fabricant;
		this._codiProducte       = codiProducte;
		this._descripcioProducte = descripcioProducte;
		this._preuVenda          = preuVenda;
		
	}

	public ComponentBase  (ComponentBase c){

		this._fabricant          = c.getFabricant();
		this._codiProducte       = c.getCodiProducte();
		this._descripcioProducte = c.getDescripcioProducte();
		this._preuVenda          = c.getPreuVenda();

	}

	public ComponentBase  (int codi){

		this._codiProducte       = codi;

	}

	public ComponentBase () {}

	public Fabricant getFabricant() {
		
		return new Fabricant(_fabricant);
		
	}
	
	public int getCodiProducte() {
		
		return _codiProducte;
		
	}
	
	public String getDescripcioProducte() {
		
		return _descripcioProducte;
		
	}
	
	public double getPreuVenda() {
		
		return _preuVenda;
	}
	
	public void setFabricant(Fabricant fabricant) {
		
		this._fabricant = fabricant;
		
	}
	
	public void setCodiProducte(int codiProducte) {
		
		this._codiProducte = codiProducte;
		
	}
	
	public void setDescripcioProducte(String descripcioProducte) {
		
		this._descripcioProducte = descripcioProducte;
		
	}
	
	public void setPreuVenda(double preuVenda) {
		
		this._preuVenda = preuVenda;
	}

	public String toString (){
		return "Codi producte: " + _codiProducte + "\n" +
			   "Descripcio: " + _descripcioProducte + "\n" +
			   "PVP: " + _preuVenda + "€\n" +
			   _fabricant.toString() + "\n";
	}

	public boolean equals (Object o){
		if ( this == o ) return true;
		if ( !(o instanceof ComponentBase) ) return false;

		ComponentBase component = (ComponentBase) o;

		if ( _codiProducte == component._codiProducte ) return true;
		return false;
	}

	public int hashCode (){
		return _codiProducte;
	}

}
	
	

