package recursos;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class REfectoIniciarFrame {

    public static void iniciarTransparencia(JFrame jFrame, float opacidad) {
        jFrame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        super.windowOpened(e);
                        jFrame.setBackground(RColores.BLANCO_MENOS_OPACO);
                        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
                            String val = i + "";
                            float f = Float.parseFloat(val);
                            jFrame.setOpacity(f);
                            try {
                                Thread.sleep(30);
                            } catch (InterruptedException ex) {
                                System.err.println("Ocurrio un Error: " + ex);
                            }
                        }

                        jFrame.setOpacity(opacidad);
                    }
                }
        );
    }

    public static void iniciarTransparencia(JDialog jDialog, float opacidad) {
        jDialog.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        super.windowOpened(e);
                        jDialog.setBackground(RColores.TRANSPARENCIA);
                        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
                            String val = i + "";
                            float f = Float.parseFloat(val);
                            jDialog.setOpacity(f);
                            try {
                                Thread.sleep(30);
                            } catch (InterruptedException ex) {
                                System.err.println("Ocurrio un Error: " + ex);
                            }
                        }

                        jDialog.setOpacity(opacidad);
                    }
                }
        );
    }

    public static void iniciarTransparenciaDialogo(JDialog jDialog, float opacidad) {
        jDialog.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        super.windowOpened(e);
                        jDialog.setBackground(RColores.BLANCO_OPACO);
                        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
                            String val = i + "";
                            float f = Float.parseFloat(val);
                            jDialog.setOpacity(f);
                            try {
                                Thread.sleep(30);
                            } catch (InterruptedException ex) {
                                System.err.println("Ocurrio un Error: " + ex);
                            }
                        }

                        jDialog.setOpacity(opacidad);
                    }
                }
        );
    }


}
