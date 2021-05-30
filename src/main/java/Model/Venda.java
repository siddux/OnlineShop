package Model;

import Model.components.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Venda{

	private Map<ProducteEnStock, Integer> _llistaProductes;
	private LocalDateTime _data;
	private Client _client;
	private boolean _metodePagament; //0 per transferencia 1 per targeta bancaria


	public Venda (Map llistaProductes, LocalDateTime data, Client client, boolean metodePagament){

		this._llistaProductes = new HashMap<ProducteEnStock, Integer>();
		_llistaProductes.putAll( llistaProductes );
		this._data            = data;
		this._client          = client;
		this._metodePagament  = metodePagament;

	}

	public Iterator getProductes(){
		return _llistaProductes.entrySet().iterator();
	}

	public LocalDateTime getData (){

		return _data;

	}

	public Client getClient (){

		return new Client( _client );

	}

	public int getNumProductes (){
		return _llistaProductes.size();
	}

	public boolean getMetodePagament (){

		return _metodePagament;

	}

	public void setMetodePagament (boolean _metodePagament){

		this._metodePagament = _metodePagament;

	}

	public boolean retornarProducte(int codiProducte){

		ProducteEnStock producte = new ProducteEnStock( new ComponentBase( codiProducte ));
		Integer unitats = _llistaProductes.get(producte);
		if (unitats > 1){
			_llistaProductes.put( producte, unitats-- );
		}
		else if (unitats == 1){
			_llistaProductes.remove( producte );
		}

		return (unitats > 0) ? true : false;

	}

	public double preuTotal(){

		double preuTotal = 0.00;
		for (Map.Entry<ProducteEnStock, Integer> producte : _llistaProductes.entrySet()) {
			ProducteEnStock key = producte.getKey();
			Integer value = producte.getValue();
			preuTotal += (key.getProducte().getPreuVenda() * value);
		}

		return preuTotal;

	}

	@Override
	public String toString (){

		double preuTotal = preuTotal();
		StringBuilder cadena = new StringBuilder();
		String metodePag;

		if ( _llistaProductes.size() != 0 ){

			for (Map.Entry<ProducteEnStock, Integer> producte : _llistaProductes.entrySet()) {

				ProducteEnStock key = producte.getKey();
				Integer value = producte.getValue();
				cadena.append( key.toString() + "\n");
				cadena.append( "UNITATS: " + value + "\n");

			}

			if ( _metodePagament ){

				metodePag = " TARGETA DE CREDIT";

			} else{

				metodePag = " TRANSFERENCIA";

			}


			cadena = new StringBuilder( _client.toString() + cadena + "\n" + "Preu total: " + preuTotal + " €" + "\n" + "El metode de venta escollit es: " + metodePag );

		} else{

			cadena = new StringBuilder( "El carro esta buit" );

		}


		return cadena + "\n";

	}

	@Override
	public boolean equals (Object o){
		if ( this == o ) return true;
		if ( !(o instanceof Venda) ) return false;
		Venda venda = (Venda) o;
		return _data.equals( venda._data ) &&
			   _client.equals( venda._client );
	}

	@Override
	public int hashCode (){
		return Objects.hash( _data, _client );
	}

}

