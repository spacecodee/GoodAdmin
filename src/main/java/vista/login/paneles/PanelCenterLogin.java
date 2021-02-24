package vista.login.paneles;

import recursos.RColores;

import javax.swing.*;
import java.awt.*;

public class PanelCenterLogin extends JPanel {

    private JPanel[] pnlMargenes;
    private JPanel[] pnlUsuarios;
    private JPanel pnlCenter;
    private final PanelCentro panelCentro = new PanelCentro();
    private GridLayout gridLayout;

    public PanelCenterLogin() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.margenes();
        this.add(this.panelCentro, BorderLayout.CENTER);
        this.margenes2();
        this.panelUsuarios();
        this.panelPerfilesUsuarios();

        this.setSize(883, 660);
        this.setPreferredSize(new Dimension(883, 660));
        this.setBackground(RColores.BLANCO_MENOS_OPACO);
    }

    private void margenes() {
        this.pnlMargenes = new JPanel[4];

        for (var i = 0; i < this.pnlMargenes.length; i++) {
            this.pnlMargenes[i] = new JPanel();
            //top
            this.pnlMargenes[i].setPreferredSize(new Dimension(46, 90));
            this.pnlMargenes[i].setBackground(RColores.BLANCO_MENOS_OPACO);
            if (i >= 2) {
                //laterales
                this.pnlMargenes[i].setPreferredSize(new Dimension(34, 480));
                this.pnlMargenes[i].setBackground(RColores.BLANCO_MENOS_OPACO);
            }

        }

        //top
        this.add(this.pnlMargenes[0], BorderLayout.NORTH);
        this.add(this.pnlMargenes[1], BorderLayout.SOUTH);

        //laterales
        this.add(this.pnlMargenes[2], BorderLayout.WEST);
        this.add(this.pnlMargenes[3], BorderLayout.EAST);
    }

    private void margenes2() {
        this.pnlMargenes = new JPanel[4];

        for (var i = 0; i < this.pnlMargenes.length; i++) {
            this.pnlMargenes[i] = new JPanel();
            this.pnlMargenes[i].setPreferredSize(new Dimension(20, 20));
            this.pnlMargenes[i].setBackground(RColores.TRANSPARENCIA);
        }

        //top
        this.panelCentro.add(this.pnlMargenes[0], BorderLayout.NORTH);
        this.panelCentro.add(this.pnlMargenes[1], BorderLayout.SOUTH);

        //laterales
        this.panelCentro.add(this.pnlMargenes[2], BorderLayout.WEST);
        this.panelCentro.add(this.pnlMargenes[3], BorderLayout.EAST);
    }

    private void panelUsuarios() {
        this.pnlCenter = new JPanel();
        this.gridLayout = new GridLayout(2, 6, 10, 10);

        this.pnlCenter.setLayout(this.gridLayout);
        this.pnlCenter.setSize(720, 460);
        this.pnlCenter.setBackground(RColores.BLANCO_MENOS_OPACO);
        this.panelCentro.add(this.pnlCenter, BorderLayout.CENTER);
    }

    private void panelPerfilesUsuarios() {
        this.pnlUsuarios = new JPanel[5];

        for (var i = 0; i < this.pnlUsuarios.length; i++) {
            this.pnlUsuarios[i] = new PanelUsuarios();
            this.pnlCenter.add(this.pnlUsuarios[i]);
        }
    }
}
