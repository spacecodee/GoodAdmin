package vista.login.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelCentro extends JPanel {

    private ImageIcon img;

    public PanelCentro() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 480));
    }

    @Override
    public void paint(Graphics g) {
        var imagen = new ImageIcon("src/main/java/img/paneles/panel-centro.png");
        this.img = new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        g.drawImage(this.img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
}
