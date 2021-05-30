package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public interface View {

    public void mostrarInfoProducte(String titolProducte, double preuProducte, String fabricantProducte, String imatgeProducte, String codiProducte) throws IOException;

    public void setVisible (boolean b);

    public void addEventListenerAfegirCarro(ActionListener l);

    public void addEventListenerBotoComprar(ActionListener l);

    public int comprarCarret(String preu);

    public void addComponents() throws IOException;
}
