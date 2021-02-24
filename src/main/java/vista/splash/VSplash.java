package vista.splash;

import componentes.CBarraProgreso;
import controlador.splash.CSplash;
import mdlaf.MaterialLookAndFeel;
import recursos.RAgrImg;
import recursos.RFuentes;
import vista.splash.paneles.PanelContenedor;

import javax.swing.*;
import java.awt.*;

import static recursos.R_Colores.*;

public class VSplash extends JDialog {
    //width => ancho; heigth => alto

    private final CSplash cSplash = new CSplash();

    public VSplash() {
        super();
        this.initComponents();
        this.cSplash.starThread(this.cBarraProgreso, this, this.lblSms, this.lblPorcentaje);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.panelPrincipal();
        this.margenesPaneles();
        this.panelCentro();
        this.panelesElementos();
        this.imgLogo();
        this.panelDeCarga();

        this.setSize(new Dimension(800, 500));
        this.setUndecorated(true);
        this.setBackground(TRANSPARENCIA);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void panelPrincipal() {
        this.panelContenedor = new PanelContenedor();
        this.panelContenedor.setLayout(new BorderLayout());
        this.add(this.panelContenedor);
    }

    private void margenesPaneles() {
        this.pnlMargenes = new JPanel[2];
        for (var i = 0; i < pnlMargenes.length; i++) {
            this.pnlMargenes[i] = new JPanel();
            this.pnlMargenes[i].setLayout(new BorderLayout());
            this.pnlMargenes[i].setBackground(TRANSPARENCIA);
            this.pnlMargenes[i].setPreferredSize(new Dimension(100, 500));
        }

        this.panelContenedor.add(this.pnlMargenes[0], BorderLayout.WEST);
        this.panelContenedor.add(this.pnlMargenes[1], BorderLayout.EAST);

    }

    private void panelCentro() {
        this.pnlCentro = new JPanel();
        this.pnlCentro.setLayout(new BorderLayout());
        this.pnlCentro.setPreferredSize(new Dimension(600, 500));
        this.pnlCentro.setBackground(LADRILLO);
        this.panelContenedor.add(this.pnlCentro, BorderLayout.CENTER);
    }

    private void panelesElementos() {
        this.pnlElementos = new JPanel[2];
        this.flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);

        for (var i = 0; i < this.pnlElementos.length; i++) {
            this.pnlElementos[i] = new JPanel();
        }

        //panel arriba
        this.pnlElementos[0].setLayout(this.flowLayout);
        this.pnlElementos[0].setPreferredSize(new Dimension(600, 300));
        this.pnlElementos[0].setBackground(BLANCO_MENOS_OPACO);
        this.pnlCentro.add(this.pnlElementos[0], BorderLayout.CENTER);

        //panel abajo
        this.flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 10);

        this.pnlElementos[1].setLayout(this.flowLayout);
        this.pnlElementos[1].setPreferredSize(new Dimension(600, 200));
        this.pnlElementos[1].setBackground(BLANCO_MENOS_OPACO);
        this.pnlCentro.add(this.pnlElementos[1], BorderLayout.SOUTH);
    }

    private void imgLogo() {
        this.lblLogo = new JLabel();
        this.lblLogo.setSize(new Dimension(280, 280));
        RAgrImg.agrImg("Logo-Good-Admin.png", this.lblLogo);
        this.pnlElementos[0].add(this.lblLogo);
    }

    private void panelDeCarga() {
        this.lblCopy = new JLabel("Derechos Reservados: Space Code".toUpperCase());
        this.cBarraProgreso = new CBarraProgreso();
        this.lblSms = new JLabel("Cargando Módulos".toUpperCase());
        this.lblPorcentaje = new JLabel("0%");

        this.lblCopy.setFont(RFuentes.getFuentePlana(20));
        this.lblCopy.setPreferredSize(new Dimension(600, 25));
        this.lblCopy.setForeground(NEGRO_OPCACO);

        this.lblSms.setFont(RFuentes.getFuentePlana(20));
        this.lblSms.setPreferredSize(new Dimension(550, 25));
        this.lblSms.setForeground(NEGRO_OPCACO);

        this.lblPorcentaje.setFont(RFuentes.getFuenteNegrita(20));
        this.lblPorcentaje.setPreferredSize(new Dimension(50, 25));
        this.lblPorcentaje.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.lblPorcentaje.setForeground(LADRILLO);

        this.cBarraProgreso.setPreferredSize(new Dimension(600, 75));
        this.cBarraProgreso.setValue(0);

        this.pnlElementos[1].add(this.lblCopy);
        this.pnlElementos[1].add(this.cBarraProgreso);
        this.pnlElementos[1].add(this.lblSms);
        this.pnlElementos[1].add(this.lblPorcentaje);
    }

    //variables
    private JLabel lblLogo;
    private JLabel lblCopy;
    private JLabel lblSms;
    private JLabel lblPorcentaje;

    private PanelContenedor panelContenedor;
    private JPanel[] pnlMargenes;
    private JPanel[] pnlElementos;
    private JPanel pnlCentro;

    private CBarraProgreso cBarraProgreso;

    private FlowLayout flowLayout;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new VSplash();
    }
}
