import Model.components.ComponentBase;
import Vista.*;
import Model.*;
import Model.Fabricant;

import javax.swing.*;
import java.io.IOException;


public class test {

    public static void main(String[] args) throws IOException{

        final Model _model = new BotigaOnline();
        final View _vista  = new InterficieClient();


        Fabricant fabricant1 = new Fabricant( 1234, "ASUS", 123456789);
        Fabricant fabricant2 = new Fabricant( 4567, "DELL", 987654321);
        Fabricant fabricant3 = new Fabricant( 1357, "Hewlett-Packard", 135792468);
        Fabricant fabricant4 = new Fabricant( 2468, "LG", 246813579);
        ComponentBase producte1 = new ComponentBase( fabricant1, 1111, "Asus VA24EHE 23.8'' LED IPS FullHD FreeSync", 106 );
        ComponentBase producte2 = new ComponentBase( fabricant2, 2222, "Dell S Series S2721HGF 27'' LED Premium", 239.99 );
        ComponentBase producte3 = new ComponentBase( fabricant3, 3333, "HP 24f 24'' LED IPS FullHD", 126 );
        ComponentBase producte4 = new ComponentBase( fabricant1, 4444, "ASUS VA24DQ 23.8 '' LED IPS FullHD FreeSync", 119 );
        ComponentBase producte5 = new ComponentBase( fabricant2, 5555, "Dell P2719H 27'' LED IPS FullHD", 199.99 );
        ComponentBase producte6 = new ComponentBase( fabricant4, 6666, "LG 27GL63T-B 27'' LED IPS FullHD 144Hz", 269.99 );
        ComponentBase producte7 = new ComponentBase( fabricant1, 7777, "Asus VZ279HE-W 27'' LED IPS FullHD", 10.55 );
        ComponentBase producte8 = new ComponentBase( fabricant4, 8888, "LG 27MP59G-P 27'' LED IPS FullHD FreeSync", 170.55 );
        ComponentBase producte9 = new ComponentBase( fabricant4, 9999, "LG 27GL850-B 27'' Nano IPS QuadHD 144Hz", 459 );
        ComponentBase producte10 = new ComponentBase( fabricant2, 1010, "Dell P2419H 23.8'' LED IPS FullHD", 179 );
        ProducteEnStock pStock1 = new ProducteEnStock( producte1, 10 );
        ProducteEnStock pStock2 = new ProducteEnStock( producte2, 20 );
        ProducteEnStock pStock3 = new ProducteEnStock( producte3, 30 );
        ProducteEnStock pStock4 = new ProducteEnStock( producte4, 40 );
        ProducteEnStock pStock5 = new ProducteEnStock( producte5, 50 );
        ProducteEnStock pStock6 = new ProducteEnStock( producte6, 60 );
        ProducteEnStock pStock7 = new ProducteEnStock( producte7, 70 );
        ProducteEnStock pStock8 = new ProducteEnStock( producte8, 80 );
        ProducteEnStock pStock9 = new ProducteEnStock( producte9, 90 );
        ProducteEnStock pStock10 = new ProducteEnStock( producte10, 100 );

        _model.afegirFabricant( fabricant1 );
        _model.afegirFabricant( fabricant2 );
        _model.afegirFabricant( fabricant3 );
        _model.afegirFabricant( fabricant4 );


        _model.afegirProducteInventari( pStock1 );
        _model.afegirProducteInventari( pStock2 );
        _model.afegirProducteInventari( pStock3 );
        _model.afegirProducteInventari( pStock4 );
        _model.afegirProducteInventari( pStock5 );
        _model.afegirProducteInventari( pStock6 );
        _model.afegirProducteInventari( pStock7 );
        _model.afegirProducteInventari( pStock8 );
        _model.afegirProducteInventari( pStock9 );
        _model.afegirProducteInventari( pStock10 );

        Client client = new Client(1237, "Eduard", "Rius", "Martínez", "999999");
        _model.afegirClient( client );
        Carro carret = new Carro( client );
        _model.afegirCarret(carret);



        final Controlador botiga = new Controlador( _model, _vista, carret);



        SwingUtilities.invokeLater( new Runnable() {
            public void run (){
                _vista.setVisible( true );
                try {
                    botiga.veureProducte();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } );
    }
}
