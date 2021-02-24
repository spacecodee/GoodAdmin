package vista.login;

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

        this.setUndecorated(true);
        this.setSize(1280, 720);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VLogin();
    }
}
