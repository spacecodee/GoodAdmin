package vista.login.paneles;

import recursos.RAgrImg;
import recursos.R_Colores;
import vista.login.VLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTopBotones extends JPanel {

    private JLabel[] lblIconos;
    private JPanel[] paneles;
    private static final String[] URL_ICONOS = {
            "close.png", "maximizae.png", "minimizar.png"
    };
    private FlowLayout flowLayout;
    private VLogin vLogin;

    public PanelTopBotones() {
        super();
        this.initComponents();
    }

    public PanelTopBotones(VLogin vLogin) {
        super();
        this.initComponents();
        this.vLogin = vLogin;
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.panelesMargenes();
        this.botonesIconos();

        this.setBackground(R_Colores.BLANCO_OPACO);
        this.setSize(new Dimension(1280, 60));
    }

    private void panelesMargenes() {
        this.flowLayout = new FlowLayout(FlowLayout.CENTER);
        this.paneles = new JPanel[2];

        for (var i = 0; i < this.paneles.length; i++) {
            this.paneles[i] = new JPanel();
            this.paneles[i].setLayout(this.flowLayout);
        }

        this.paneles[0].setPreferredSize(new Dimension(100, 60));
        this.paneles[0].setBackground(R_Colores.NEGRO_OPCACO);
        this.add(this.paneles[0], BorderLayout.WEST);

        this.flowLayout.setVgap(18);
        this.paneles[1].setPreferredSize(new Dimension(1180, 60));
        this.paneles[1].setBackground(R_Colores.NEGRO_OPCACO);
        this.add(this.paneles[1], BorderLayout.CENTER);
    }

    private void botonesIconos() {
        this.lblIconos = new JLabel[3];

        for (var i = 0; i < this.lblIconos.length; i++) {
            this.lblIconos[i] = new JLabel();
            this.lblIconos[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.lblIconos[i].setPreferredSize(new Dimension(24, 24));
            this.lblIconos[i].setSize(new Dimension(24, 24));
            this.lblIconos[i].setSize(new Dimension(24, 24));
            RAgrImg.agrImg(URL_ICONOS[i], this.lblIconos[i]);
            this.paneles[0].add(this.lblIconos[i]);
        }

        this.lblIconos[0].addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if (e.getSource() == PanelTopBotones.this.lblIconos[0]) {
                            PanelTopBotones.this.vLogin.dispose();
                        }
                    }
                }
        );
    }
}
