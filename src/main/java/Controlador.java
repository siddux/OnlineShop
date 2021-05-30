import Model.*;
import Vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

public class Controlador {

    private View _vista;
    private Model _model;
    private Carro _carret;

    public Controlador(Model model, View vista, Carro carret) throws IOException{
        this._model  = model;
        this._vista  = vista;
        this._carret = carret;
    }

    protected void veureProducte() throws IOException{
        Iterator<ProducteEnStock> inventari = this._model.getInventari();
        while (inventari.hasNext()){
            ProducteEnStock item = inventari.next();
            String titol     = item.getProducte().getDescripcioProducte();
            double preu      = item.getProducte().getPreuVenda();
            String fabricant = item.getProducte().getFabricant().getNomFabricant();
            String codi      = Integer.toString( item.getProducte().getCodiProducte() );
            String imatge    = "media/Imatges/" + codi + ".png";
            this._vista.mostrarInfoProducte( titol, preu, fabricant, imatge, codi);
            this._vista.addComponents();
            _vista.setVisible( true );
        }

        this._vista.addEventListenerAfegirCarro(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codi = e.getActionCommand();
                afegirProducte(codi);
            }
        });

        this._vista.addEventListenerBotoComprar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarCarro();
            }
        });
    }

    protected void afegirProducte(String codi){
        Integer codiProducte = Integer.parseInt( codi );
        _model.afegirProducteCarret(_carret, codiProducte );
    }

    protected void comprarCarro(){
        String preu = _model.getPreuCarret(_carret);
        int pagament = _vista.comprarCarret(preu);
        if ( pagament == 0){
            Optional<Venda> venda = _model.comprarCarret( _carret, true );
            if(venda.isPresent()){
                _model.afegirVenda( venda.get() );
            }
        }
        else if (pagament == 1){
            Optional<Venda> venda = _model.comprarCarret( _carret, true );
            if(venda.isPresent()){
                _model.afegirVenda( venda.get() );
            }
        }

    }
}
