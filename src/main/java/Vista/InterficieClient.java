package Vista;

import Model.ProducteEnStock;
import Model.components.ComponentBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class InterficieClient extends JFrame implements View {

    private JPanel _finestraPrincipal, _barraFiltre, _llistaProductes;
    private JButton _botoComprar;
    private Set<JButton> _afegirCarro = new HashSet<JButton>();

    private static final String TITLE = "Products catalog";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public InterficieClient () throws IOException{

        _llistaProductes = new JPanel();
        _llistaProductes.setLayout( new BoxLayout( _llistaProductes, BoxLayout.Y_AXIS ) );
        this.init();

    }

    private void init() throws IOException{
        this.setSize( WIDTH, HEIGHT );
        this.setTitle( TITLE );
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setLocation( 540,300 );
        this.setResizable(true) ;
    }

    public void addComponents() throws IOException{
        _finestraPrincipal = new JPanel(new BorderLayout());
        _finestraPrincipal.setPreferredSize(new Dimension(WIDTH,5*HEIGHT));
        JLabel titol = new JLabel("BOTIGA ONLINE", JLabel.CENTER);
        titol.setFont(new Font("Helvetica Neue", Font.BOLD, 32));
        _finestraPrincipal.add( titol, BorderLayout.NORTH );
        _finestraPrincipal.add(_llistaProductes,BorderLayout.CENTER);
        _finestraPrincipal.add( crearBarraComprar(), BorderLayout.SOUTH );
        this.setContentPane(new JScrollPane(_finestraPrincipal));
    }


    public void mostrarInfoProducte(String titolProducte, double preuProducte, String fabricantProducte, String imatgeProducte, String codiProducte) throws IOException{

        JPanel infoProducte = new JPanel();
        GroupLayout gLayout = new GroupLayout( infoProducte );
        infoProducte.setLayout( gLayout );
        gLayout.setAutoCreateGaps(true);
        gLayout.setAutoCreateContainerGaps(true);
        JLabel titol = new JLabel( majuscula(titolProducte));
        titol.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        JLabel preu  = new JLabel(Double.toString( preuProducte ) + " €");
        preu.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        BufferedImage imatge;
        JLabel fabricant = new JLabel(majuscula(fabricantProducte));
        fabricant.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
        try {
            imatge = ImageIO.read(new File( imatgeProducte ) );
        }
        catch (Exception e){
            imatge = null;
        }
        JLabel imatgeProd = new JLabel(new ImageIcon(escalarImatge( imatge, 100, 100 )));
        imatgeProd.setMinimumSize( new Dimension(200, 200 ));
        imatgeProd.setMaximumSize( new Dimension(200, 200 ));
        JButton afegirCarro = new JButton();
        afegirCarro.setText("Afegir carret");
        afegirCarro.setSize( 20, 20 );
        afegirCarro.setBackground( Color.RED );
        afegirCarro.setActionCommand( codiProducte );
        _afegirCarro.add( afegirCarro );

        gLayout.setHorizontalGroup(
                gLayout.createSequentialGroup()
                        .addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                          .addComponent(titol)
                                          .addComponent(imatgeProd))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                         GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fabricant)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                         GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                          .addComponent(preu)
                                          .addComponent(afegirCarro))
        );gLayout.setVerticalGroup(
                gLayout.createSequentialGroup()
                        .addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                          .addComponent(titol)
                                          .addComponent(fabricant)
                                          .addComponent(preu))
                        .addGroup(gLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                          .addComponent(imatgeProd)
                                          .addComponent(afegirCarro))
        );


        _llistaProductes.add( infoProducte );
    }

    private JPanel crearBarraComprar(){
        JPanel barraComprar = new JPanel();
        _botoComprar = new JButton("Comprar");
        barraComprar.add( _botoComprar );
        return barraComprar;
    }

    private static String majuscula(String str){
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private Image escalarImatge(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    @Override
    public int comprarCarret (String preu){
        double preuInt = Double.parseDouble( preu );
        String[] options = new String[2];
        options[0] = new String("Targeta");
        options[1] = new String("Transferencia");
        if (preuInt > 0){
            int option = JOptionPane.showConfirmDialog( this, "El total es de " + preu + " €. Desitja realitzar la compra?", "Confirmar compra",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE );
            if (option == JOptionPane.OK_OPTION){
                return JOptionPane.showOptionDialog( this, "Quin metode de pagament desitja utilitzar?", "Metode de pagament",0, JOptionPane.INFORMATION_MESSAGE,null,options,null );
            }
        }
        else{
            JOptionPane.showMessageDialog( this, "El carret esta buit", "Dialog box", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    public void addEventListenerAfegirCarro(ActionListener l) {
        Iterator<JButton> botons = _afegirCarro.iterator();
        while (botons.hasNext()){
            botons.next().addActionListener( l );
        }
    }

    public void addEventListenerBotoComprar(ActionListener l) {
        _botoComprar.addActionListener( l );
    }

}
