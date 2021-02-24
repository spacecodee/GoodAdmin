package vista.login;

import mdlaf.MaterialLookAndFeel;
import recursos.REfectoIniciarFrame;
import vista.login.paneles.PanelLateralLogin;
import vista.login.paneles.PanelTopBotones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VLogin extends JFrame {

    private final PanelLateralLogin panelLateralLogin = new PanelLateralLogin();
    private String sms;

    public VLogin() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(new PanelTopBotones(this), BorderLayout.NORTH);
        this.add(this.panelLateralLogin, BorderLayout.WEST);

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
                                VLogin.this.panelLateralLogin.getFlowLayout().setVgap(50);
                            } else if (VLogin.this.getHeight() == 720) {
                                VLogin.this.panelLateralLogin.getFlowLayout().setVgap(15);
                            }
                        }
                    }
                }
        );

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
