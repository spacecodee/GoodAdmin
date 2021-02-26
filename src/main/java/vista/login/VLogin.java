package vista.login;

import mdlaf.MaterialLookAndFeel;
import recursos.RAgrImg;
import recursos.REfectoIniciarFrame;
import recursos.RFuentes;
import vista.login.paneles.PanelCenterLogin;
import vista.login.paneles.PanelLateralLogin;
import vista.login.paneles.PanelTopBotones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VLogin extends JFrame {

    private final PanelLateralLogin panelLateralLogin = new PanelLateralLogin();
    private final PanelCenterLogin panelCenterLogin = new PanelCenterLogin(this);
    private String sms;

    public VLogin() {
        super("Good Admin");
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new PanelTopBotones(this), BorderLayout.NORTH);
        this.add(this.panelLateralLogin, BorderLayout.WEST);
        this.add(this.panelCenterLogin, BorderLayout.CENTER);

        this.esteFrame();
    }

    private void esteFrame() {
        this.setUndecorated(true);
        this.setSize(1280, 720);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setLocationRelativeTo(null);

        REfectoIniciarFrame.iniciarTransparencia(this, 0.9F);
        this.addWindowStateListener(
                new WindowAdapter() {
                    @Override
                    public void windowStateChanged(WindowEvent e) {
                        super.windowStateChanged(e);
                        if (e.getSource() == VLogin.this) {
                            if (VLogin.this.getExtendedState() == Frame.MAXIMIZED_BOTH) {
                                VLogin.this.panelLateralLogin.getFlowLayout().setVgap(174); //espacio entre la imagen y el boton

                                VLogin.this.panelCenterLogin.getGridLayout().setVgap(50);
                                VLogin.this.panelCenterLogin.getGridLayout().setHgap(40);

                                for (var i = 0; i < VLogin.this.panelCenterLogin.getLblAvatares().length; i++) {
                                    VLogin.this.panelCenterLogin.getPnlUsuarios()[i].setLayout(
                                            new FlowLayout(FlowLayout.CENTER, 40, 20)
                                    );

                                    VLogin.this.panelCenterLogin.getLblAvatares()[i].setPreferredSize(new Dimension(300, 180));
                                    VLogin.this.panelCenterLogin.getLblAvatares()[i].setSize(new Dimension(300, 180));
                                    VLogin.this.panelCenterLogin.getLblAvatares()[i].setHorizontalAlignment(SwingConstants.CENTER);

                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setPreferredSize(new Dimension(300, 40));
                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setSize(new Dimension(300, 40));
                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setHorizontalAlignment(SwingConstants.CENTER);
                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setFont(RFuentes.getFuenteNegrita(20));

                                    //VLogin.this.panelCenterLogin.getPnlUsuarios()[i].setPreferredSize(new Dimension(300, 300));
                                    //VLogin.this.panelCenterLogin.getPnlUsuarios()[i].setSize(new Dimension(300, 300));

                                    if (i < 4) {
                                        VLogin.this.panelCenterLogin.getPnlMargenes()[i].setPreferredSize(new Dimension(80, 80));
                                        VLogin.this.panelCenterLogin.getPnlMargenes()[i].setSize(new Dimension(80, 80));
                                    }

                                }
                            } else if (VLogin.this.getHeight() == 720) {
                                VLogin.this.panelLateralLogin.getFlowLayout().setVgap(10);

                                VLogin.this.panelCenterLogin.getGridLayout().setHgap(15);
                                VLogin.this.panelCenterLogin.getGridLayout().setVgap(15);

                                for (var i = 0; i < VLogin.this.panelCenterLogin.getLblAvatares().length; i++) {
                                    VLogin.this.panelCenterLogin.getPnlUsuarios()[i].setLayout(
                                            new FlowLayout(FlowLayout.CENTER, 40, 15)
                                    );

                                    VLogin.this.panelCenterLogin.getLblAvatares()[i].setPreferredSize(new Dimension(90, 150));
                                    VLogin.this.panelCenterLogin.getLblAvatares()[i].setSize(new Dimension(90, 150));

                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setPreferredSize(new Dimension(250, 20));
                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setSize(new Dimension(250, 20));
                                    VLogin.this.panelCenterLogin.getLblNombres()[i].setFont(RFuentes.getFuenteNegrita(16));

                                    //VLogin.this.panelCenterLogin.getPnlUsuarios()[i].setPreferredSize(new Dimension(280, 280));
                                    //VLogin.this.panelCenterLogin.getPnlUsuarios()[i].setSize(new Dimension(280, 280));

                                    if (i < 4) { //se asignan tamaños a los paneles donde iran los usuarios
                                        VLogin.this.panelCenterLogin.getPnlMargenes()[i].setPreferredSize(new Dimension(20, 20));
                                        VLogin.this.panelCenterLogin.getPnlMargenes()[i].setSize(new Dimension(20, 20));
                                    }
                                }
                            }
                        }
                    }
                }
        );
        RAgrImg.setIconWindow(this, "Logo-Good-Admin.png");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new VLogin();
    }
}
