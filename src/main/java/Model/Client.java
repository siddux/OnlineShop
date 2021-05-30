package Model;

import java.util.Objects;

public class Client {
	
	private int _codiClient;
	private String _nomClient;
	private String _cognom1;
	private String _cognom2;
	private String _codiTargeta;
	
	public Client(int codiClient, String nomClient, String cognom1, String cognom2, String codiTargeta) {
		
		this._codiClient  = codiClient;
		this._nomClient   = nomClient;
		this._cognom1     = cognom1;
		this._cognom2     = cognom2;
		this._codiTargeta = codiTargeta;
	}

	public Client(){}
	
	public Client(Client client) {
		
		this._codiClient  = client._codiClient;
		this._nomClient   = client._nomClient;
		this._cognom1     = client._cognom1;
		this._cognom2     = client._cognom2;
		this._codiTargeta = client._codiTargeta;
	}
	
	public int getCodiClient() {
		
		return _codiClient;
		
	}
	
	public String getNomClient() {
		
		return _nomClient;
		
	}
	
	public String getCognom1() {
		
		return _cognom1;
		
	}
	
	public String getCognom2( ) {
		
		return _cognom2;
		
	}
	
	public String getCodiTargeta() {
		
		return _codiTargeta;
		
	}
	
	public void setCodiClient(int codiClient) {
		
		this._codiClient = codiClient;
		
	}
	
	public void setNomClient(String nomClient) {
		
		this._nomClient = nomClient;
		
	}
	
	public void setCognom1(String cognom1) {
		
		this._cognom1 = cognom1;
		
	}
	
	public void setCognom2(String cognom2 ) {
		
		this._cognom2 = cognom2;
		
	}
	
	public void setCodiTargeta(String codiTargeta) {
		
		this._codiTargeta = codiTargeta;
		
	}

	@Override
	public String toString (){

		return "Client: " + "\n" +
			   " Codi client: " + _codiClient + "\n" +
			   " Nom client: " + _nomClient + " " + _cognom1 + " " + _cognom2 + "\n" +
			   " Codi targeta: " + _codiTargeta + "\n";

	}

	@Override
	public boolean equals (Object o){
		if ( this == o ) return true;
		if ( !(o instanceof Client) ) return false;
		Client client = (Client) o;
		return _codiClient == client._codiClient;
	}

	@Override
	public int hashCode (){
		return Objects.hash( _codiClient );
	}
}
