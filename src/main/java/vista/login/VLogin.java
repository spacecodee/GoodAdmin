package vista.login;

import recursos.REfectoIniciarFrame;
import vista.login.paneles.PanelLateralLogin;
import vista.login.paneles.PanelTopBotones;

import javax.swing.*;
import java.awt.*;

public class VLogin extends JFrame {

    public VLogin() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(new PanelTopBotones(this), BorderLayout.NORTH);
        this.add(new PanelLateralLogin(), BorderLayout.WEST);

        this.esteFrame();

    }

    private void esteFrame() {
        this.setUndecorated(true);
        this.setSize(1280, 720);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setLocationRelativeTo(null);

        REfectoIniciarFrame.iniciarTransparencia(this, 0.8F);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VLogin();
    }
}
