package Model;

import Model.components.ComponentBase;

import java.util.*;

public class BotigaOnline implements Model{

    private final Map<Integer, Client> _clients;
    private final Map<Integer,Fabricant> _fabricants;
    private final Map<Integer, ProducteEnStock> _inventari;
    private final Map<Integer, Carro> _carrets;
    private final Map<Integer, Venda> _vendes;

    public BotigaOnline (){
        this._clients          = new HashMap<Integer, Client>();
        this._fabricants       = new HashMap<Integer, Fabricant>();
        this._inventari        = new HashMap<Integer, ProducteEnStock>();
        this._carrets          = new HashMap<Integer, Carro>();
        this._vendes           = new HashMap<Integer, Venda>();
    }

    public Iterator getClients (){
        return _clients.values().iterator();
    }

    public boolean afegirClient (Client client){

        if (!_clients.containsValue( client )){
            _clients.put( client.hashCode(), client );
            return true;
        }
        return false;
    }

    public Optional<Client> buscarClient( int codiClient){

        if (_clients.containsKey( codiClient )){
            return Optional.of( _clients.get( codiClient ) );
        }
        return Optional.empty();
    }

    public Iterator getFabricants (){
        return _fabricants.values().iterator();
    }

    public boolean afegirFabricant (Fabricant fabricant){

        if (!_fabricants.containsValue( fabricant )){
            _fabricants.put( fabricant.hashCode(), fabricant );
            return true;
        }
        return false;
    }

    public Optional<Fabricant> buscarFabricant( int codiFabricant){
       if (_fabricants.containsKey( codiFabricant )){
           return Optional.of( _fabricants.get( codiFabricant ) );
       }
       return Optional.empty();
    }

    public Iterator getInventari(){
        return _inventari.values().iterator();
    }

    public boolean afegirProducteInventari(ProducteEnStock stock){

        if ( !_inventari.containsValue(stock) ){
            _inventari.put(stock.hashCode(), stock);
            return true;
        }
        return false;
    }

    public Optional<ProducteEnStock> buscarProducteInventari(int codiProducte){

        Iterator<ProducteEnStock> iter = _inventari.values().iterator();
        while (iter.hasNext()){
            ProducteEnStock prod = iter.next();
            if (prod.getProducte().getCodiProducte() == codiProducte){
                return Optional.of(prod);
            }
        }

        return Optional.empty();
    }

    public Iterator getCarrets(){
        return _carrets.values().iterator();
    }

    public boolean afegirCarret(Carro carret){
        if (!_carrets.containsValue( carret )){
            _carrets.put( carret.hashCode(), carret );
            return true;
        }
        return false;
    }

    public boolean afegirProducteCarret(Carro carret, Integer codiProducte){

        if (_carrets.containsValue( carret ) && _inventari.containsValue( new ProducteEnStock(codiProducte) )){

            Optional<ProducteEnStock> producte = buscarProducteInventari( codiProducte );
            if (producte.isPresent()){
                 if (producte.get().getUnitatsStock() > 0){
                if (carret.afegirProducte( producte.get() )){
                    producte.get().augmentarReservades();
                    return producte.get().disminuirStock();
                }
            }
            }
        }
        return false;
    }

    public boolean eliminarProducteCarret(Carro carret, int codiProducte){
        if (_carrets.containsValue( carret ) && _inventari.containsKey( codiProducte )){

            ProducteEnStock producte = _inventari.get( codiProducte );
            if (carret.borrarProducte( codiProducte )){
                producte.augmentarStock();
                return producte.disminuirReservades();
            }
        }
        return false;
    }

    public boolean eliminarCarret(Carro carret){
        if(_carrets.containsValue( carret )){
            Iterator<ProducteEnStock> llistaProductes = carret.getProductes();
            while (llistaProductes.hasNext()){
                eliminarProducteCarret( carret, llistaProductes.next().getProducte().getCodiProducte());
            }
            _carrets.remove( carret.hashCode() );
            return true;
        }
        return false;
    }

    public String getPreuCarret(Carro _carret){
        return String.valueOf( _carret.preuTotal() );
    }

    public Optional<Venda> comprarCarret(Carro carret, boolean metodePagament){

        if (_carrets.containsValue( carret )){
            Optional<Venda> venda = carret.comprarCarro( metodePagament );
            if (venda.isPresent()){
                Iterator<ProducteEnStock> llistaProductes = carret.getProductes();
                while (llistaProductes.hasNext()){
                    Map.Entry<ProducteEnStock, Integer> pair = (Map.Entry<ProducteEnStock, Integer>) llistaProductes.next();
                    ProducteEnStock producte = pair.getKey();
                    int unitats              = pair.getValue();
                    producte.modificarUnitatsReservades( -unitats );
                }
                _carrets.remove( carret.hashCode());
                return venda;
            }
        }
        return Optional.empty();
    }

    public Iterator getVendes(){
        return _vendes.values().iterator();
    }

    public boolean afegirVenda(Venda venda){
        if (!_vendes.containsValue( venda )){
            _vendes.put( venda.hashCode(), venda );
            return true;
        }
        return false;
    }

    public boolean retornarProducte(Venda venda, int codiProducte){

        if(_vendes.containsValue( venda ) && _inventari.containsKey( codiProducte )){

            ProducteEnStock producte = _inventari.get( codiProducte );
            if (venda.retornarProducte( codiProducte )){
                producte.augmentarStock();
                return true;
            }
        }
        return false;
    }

    public boolean retornarVenda(Venda venda){

        if (_vendes.containsValue( venda )){
            Iterator<ProducteEnStock> llistaProductes = venda.getProductes();
            while (llistaProductes.hasNext()){
                Map.Entry<ProducteEnStock, Integer> pair = (Map.Entry<ProducteEnStock, Integer>) llistaProductes.next();
                ProducteEnStock producte = pair.getKey();
                int unitats              = pair.getValue();
                venda.retornarProducte( producte.hashCode() );
                producte.modificarUnitatsStock( unitats );
            }
            _vendes.remove( venda );
            return true;

        }
        return false;
    }

}
