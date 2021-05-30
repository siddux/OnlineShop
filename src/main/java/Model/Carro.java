package Model;
import Model.components.*;

import java.time.LocalDateTime;
import java.util.*;

public class Carro {
	
	private Map<ProducteEnStock, Integer> _llistaProductes;
	private LocalDateTime _data;
	private Client _client;
	
	public Carro(Client client) {
		
		this._llistaProductes = new HashMap<ProducteEnStock, Integer>();
		this._client          = client;
		this._data            = LocalDateTime.now();
		
	}

	public Iterator getProductes() {
		return _llistaProductes.entrySet().iterator();
	}
	
	public LocalDateTime getData() {
		
		return _data;
		
	}
	
	public Client getClient() {
		
		return new Client(_client);
		
	}
	
	public int getNumProductes() {

		return _llistaProductes.size();
		
	}

	public boolean afegirProducte(ProducteEnStock producte) {

		Integer unitatsPrevies = _llistaProductes.putIfAbsent( producte, 1 );

		if (unitatsPrevies != null){
			_llistaProductes.put( producte, unitatsPrevies++ );
		}
		return true;
	}
	
	public boolean borrarProducte(int codiProducte){

		ProducteEnStock producte = new ProducteEnStock( new ComponentBase( codiProducte ) );
		int unitats = _llistaProductes.get( producte );

		if (_llistaProductes.containsKey( producte )){

			if ( unitats > 1){
				_llistaProductes.put( producte, unitats-- );
			}
			else if (unitats == 1){
				_llistaProductes.remove( producte );
			}

		}
		return (unitats > 0 ) ? true:false;

	}

	public boolean buidarCarro(){
		_llistaProductes.clear();
		return true;
	}
	
	public Optional<Venda> comprarCarro(boolean metodePagament){
		if(!_llistaProductes.isEmpty()){
			Venda venda = new Venda(_llistaProductes, LocalDateTime.now(), this._client, metodePagament );
			buidarCarro();
			return Optional.of( venda );
		}
		else {
			return Optional.empty();
		}
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
	public String toString() {

		StringBuilder cadena = new StringBuilder();
		
		if (!_llistaProductes.isEmpty()) {

			for (Map.Entry<ProducteEnStock, Integer> producte : _llistaProductes.entrySet()) {

				ProducteEnStock key = producte.getKey();
				Integer value = producte.getValue();
				cadena.append( key.toString() + "\n");
				cadena.append( "UNITATS: " + value + "\n");

			}

			cadena.append( "Preu total: " ).append( preuTotal() ).append( " €" );
			
		}
		
		else {

			cadena = new StringBuilder( "El carro esta buit" );
					
		}
		
		
		return _client.toString() +
			   "Data de creacio: " + _data.toString() + "\n" +
			   "\n" + cadena + "\n";
		
	}

	@Override
	public boolean equals (Object o){
		if ( this == o ) return true;
		if ( !(o instanceof Carro) ) return false;
		Carro carro = (Carro) o;
		return _client.equals( carro._client );
	}

	@Override
	public int hashCode (){
		return Objects.hash( _client );
	}

}
