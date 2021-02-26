package recursos;

import javax.swing.*;
import java.awt.*;

public class RAgrImg {

    public static void agrImg(String URL, JLabel lbl) {
        try {
            var img = new ImageIcon("src/main/java/img/" + URL);
            var icono = new ImageIcon(img.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
            lbl.setIcon(icono);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.err.println("No existe la imagen");
        }
    }

    public static void agrImg(String URL, JButton btn) {
        try {
            var img = new ImageIcon("src/main/java/img/" + URL);
            var icon = new ImageIcon(img.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_DEFAULT));
            btn.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.err.println("No existe la imagen");
        }
    }

    public void pasarMauseBoton(String URL, JButton btn) {
        try {
            btn.setRolloverIcon(new ImageIcon(getClass().getResource(URL)));
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.err.println("No existe la imagen");
        }
    }

    public static void setIconWindow(Window ventana, String rutaIcono) {
        try {
            ventana.setIconImage((new ImageIcon("src/main/java/img/" + rutaIcono)).getImage());
        } catch (Exception ex) {
            System.out.println("Al parecer no existe la imagen\n");
            ex.printStackTrace(System.out);
        }
    }
}
