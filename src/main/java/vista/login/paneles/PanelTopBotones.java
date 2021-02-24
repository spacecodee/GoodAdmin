package vista.login.paneles;

import recursos.RAgrImg;
import recursos.RColores;
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

        this.setBackground(RColores.BLANCO_OPACO);
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
        this.paneles[0].setBackground(RColores.NEGRO_OPCACO);
        this.add(this.paneles[0], BorderLayout.WEST);

        this.flowLayout.setVgap(18);
        this.paneles[1].setPreferredSize(new Dimension(1180, 60));
        this.paneles[1].setBackground(RColores.NEGRO_OPCACO);
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

        this.lblIconos[1].addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if (e.getSource() == PanelTopBotones.this.lblIconos[1]) {
                            if (PanelTopBotones.this.vLogin.getExtendedState() == Frame.MAXIMIZED_BOTH) {
                                RAgrImg.agrImg(PanelTopBotones.URL_ICONOS[1], PanelTopBotones.this.lblIconos[1]);
                                PanelTopBotones.this.vLogin.setSize(new Dimension(1280, 720));
                                PanelTopBotones.this.vLogin.setLocationRelativeTo(null);
                            } else {
                                RAgrImg.agrImg("maximizar.png", PanelTopBotones.this.lblIconos[1]);
                                PanelTopBotones.this.vLogin.setExtendedState(Frame.MAXIMIZED_BOTH);
                            }
                        }
                    }
                }
        );

        this.lblIconos[2].addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if (e.getSource() == PanelTopBotones.this.lblIconos[2]) {
                            PanelTopBotones.this.vLogin.setExtendedState(Frame.ICONIFIED);
                        }
                    }
                }
        );


    }
}
