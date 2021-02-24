package vista.login.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelUsuarios extends JPanel {
    private ImageIcon img;

    public PanelUsuarios() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        this.setSize(205, 205);
    }

    @Override
    public void paint(Graphics g) {
        var imagen = new ImageIcon("src/main/java/img/paneles/panel-usuarios.png");
        this.img = new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        g.drawImage(this.img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);
    }
}
