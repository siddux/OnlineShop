package Model;

import java.util.Iterator;
import java.util.Optional;

public interface Model {

    public boolean afegirProducteCarret(Carro carret, Integer codiProducte);

    public Iterator getInventari();

    public boolean afegirFabricant (Fabricant fabricant);

    public boolean afegirProducteInventari(ProducteEnStock stock);

    public boolean afegirCarret(Carro carret);

    public boolean afegirClient(Client client);

    public String getPreuCarret(Carro _carret);

    public Optional<Venda> comprarCarret(Carro _carret, boolean pagament);

    public boolean afegirVenda(Venda venda);
}
