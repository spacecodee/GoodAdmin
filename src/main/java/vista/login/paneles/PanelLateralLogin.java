package vista.login.paneles;

import recursos.RColores;

import javax.swing.*;
import java.awt.*;

public class PanelLateralLogin extends JPanel {

    public PanelLateralLogin() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setSize(280, 660);
        this.setPreferredSize(new Dimension(400, 660));
        this.setBackground(RColores.NEGRO_OPCACO);
    }
}
