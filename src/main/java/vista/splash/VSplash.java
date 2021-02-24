package vista.splash;

import componentes.CBarraProgreso;
import mdlaf.MaterialLookAndFeel;
import vista.splash.paneles.PanelContenedor;

import javax.swing.*;
import java.awt.*;

import static recursos.R_Colores.LADRILLO;
import static recursos.R_Colores.TRANSPARENCIA;

public class VSplash extends JDialog {

    public VSplash() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.panelPrincipal();
        this.margenesPaneles();
        this.panelCentro();
        this.barraProgreso();

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
        this.panels = new JPanel[2];
        for (var i = 0; i < panels.length; i++) {
            this.panels[i] = new JPanel();
            this.panels[i].setLayout(new BorderLayout());
            this.panels[i].setBackground(TRANSPARENCIA);
            this.panels[i].setPreferredSize(new Dimension(100, 500));
        }

        this.panelContenedor.add(this.panels[0], BorderLayout.WEST);
        this.panelContenedor.add(this.panels[1], BorderLayout.EAST);

    }

    private void panelCentro() {
        this.pnlCentro = new JPanel();
        this.pnlCentro.setLayout(new BorderLayout());
        this.pnlCentro.setPreferredSize(new Dimension(600, 500));
        this.pnlCentro.setBackground(LADRILLO);
        this.panelContenedor.add(this.pnlCentro, BorderLayout.CENTER);
    }

    private void barraProgreso() {
        this.cBarraProgreso = new CBarraProgreso();
        this.pnlCentro.add(this.cBarraProgreso);
    }

    //variables
    private PanelContenedor panelContenedor;
    private JPanel[] panels;
    private JPanel pnlCentro;
    private CBarraProgreso cBarraProgreso;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new VSplash();
    }
}
