package vista.splash.paneles;

import recursos.RColores;

import javax.swing.*;
import java.awt.*;

public class PanelContenedor extends JPanel {
    private Image img;

    public PanelContenedor() {
        super();
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 500));
    }

    @Override
    public void paint(Graphics g) {
        this.img = new ImageIcon("src/main/java/img/paneles/PanelSplash.png").getImage();
        g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
}
