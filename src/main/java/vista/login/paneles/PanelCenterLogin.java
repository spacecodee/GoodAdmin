package vista.login.paneles;

import recursos.RAgrImg;
import recursos.RColores;
import recursos.RFuentes;

import javax.swing.*;
import java.awt.*;

public class PanelCenterLogin extends JPanel {

    private JPanel[] pnlMargenes;
    private JPanel[] pnlUsuarios;
    private JPanel pnlCenter;
    private final PanelCentro panelCentro = new PanelCentro();
    private GridLayout gridLayout;
    private JLabel[] lblAvatares;
    private final String[] urlAvatars = {
            "login/avatares/usuario1.png", "login/avatares/usuario2.png", "login/avatares/usuario3.png",
            "login/avatares/usuario4.png", "login/avatares/usuario5.png"
    };
    private final JLabel[] lblNombreUsuarios = {
            new JLabel("Usuario 1"), new JLabel("Usuario 2"), new JLabel("Usuario 3"),
            new JLabel("Usuario 4"), new JLabel("Usuario 5")
    };

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
        this.agregarLlblImg();

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
            this.pnlUsuarios[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.pnlCenter.add(this.pnlUsuarios[i]);
        }
    }

    private void agregarLlblImg() {
        this.lblAvatares = new JLabel[5];
        for (var i = 0; i < this.pnlUsuarios.length; i++) {
            this.lblAvatares[i] = new JLabel();
            this.lblAvatares[i].setSize(new Dimension(90, 150));
            this.lblAvatares[i].setPreferredSize(new Dimension(90, 150));
            RAgrImg.agrImg(this.urlAvatars[i], this.lblAvatares[i]);
            this.pnlUsuarios[i].add(this.lblAvatares[i]);

            this.lblNombreUsuarios[i].setFont(RFuentes.getFuenteNegrita(16));
            this.lblNombreUsuarios[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.lblNombreUsuarios[i].setSize(205, 15);
            this.lblNombreUsuarios[i].setPreferredSize(new Dimension(205, 15));
            this.pnlUsuarios[i].add(this.lblNombreUsuarios[i]);
        }
    }

    public JLabel[] getLblAvatares() {
        return lblAvatares;
    }

    public void setLblAvatares(JLabel[] lblAvatares) {
        this.lblAvatares = lblAvatares;
    }

    public JLabel[] getLblNombreUsuarios() {
        return lblNombreUsuarios;
    }

    public JPanel[] getPnlUsuarios() {
        return pnlUsuarios;
    }

    public void setPnlUsuarios(JPanel[] pnlUsuarios) {
        this.pnlUsuarios = pnlUsuarios;
    }

    public GridLayout getGridLayout() {
        return gridLayout;
    }

    public void setGridLayout(GridLayout gridLayout) {
        this.gridLayout = gridLayout;
    }

    public JPanel[] getPnlMargenes() {
        return pnlMargenes;
    }

    public void setPnlMargenes(JPanel[] pnlMargenes) {
        this.pnlMargenes = pnlMargenes;
    }
}
