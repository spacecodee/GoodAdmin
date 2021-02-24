package componentes;

import recursos.R_Colores;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class CBarraProgreso extends JProgressBar {
    private Color colorBackBarraProgreso = R_Colores.LADRILLO;
    private Color colorBackground = R_Colores.BLANCO_MENOS_OPACO;
    private Color colorPorcentaje = R_Colores.NEGRO_OPCACO;
    private Color colorLetras = R_Colores.NEGRO_OPCACO;
    private int grosorBorde = 1;
    private Color colorBorde = R_Colores.LADRILLO;

    private Border borde = new LineBorder(this.colorBorde, this.grosorBorde, true);
    private boolean horizontalOrientacion = true;

    public CBarraProgreso() {
        this.setBorder(this.borde);
        this.setValue(50);
        this.setStringPainted(true);
        this.setFont(new Font("Gilroy", Font.BOLD, 20));
        this.setForeground(this.colorBackBarraProgreso);
        this.setBackground(this.colorBackground);
        this.setPreferredSize(new Dimension(200, 30));
        this.setSize(new Dimension(200, 30));
        this.setOrientation(0);
        this.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() {
                return CBarraProgreso.this.colorPorcentaje;
            }

            protected Color getSelectionForeground() {
                return CBarraProgreso.this.colorLetras;
            }
        });
    }

    public Color getColorPorcentaje() {
        return this.colorPorcentaje;
    }

    public void setColorPorcentaje(final Color colorPorcentaje) {
        this.colorPorcentaje = colorPorcentaje;
        setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() {
                return colorPorcentaje;
            }

            protected Color getSelectionForeground() {
                return CBarraProgreso.this.colorLetras;
            }
        });
    }

    public Color getColorLetras() {
        return this.colorLetras;
    }

    public void setColorLetras(final Color colorLetras) {
        this.colorLetras = colorLetras;
        setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() {
                return CBarraProgreso.this.colorPorcentaje;
            }

            protected Color getSelectionForeground() {
                return colorLetras;
            }
        });
    }

    public int getGrosorBorde() {
        return this.grosorBorde;
    }

    public void setGrosorBorde(int grosorBorde) {
        this.grosorBorde = grosorBorde;
        setBorder(BorderFactory.createMatteBorder(grosorBorde, grosorBorde, grosorBorde, grosorBorde, this.colorBorde));
    }

    public Color getColorBorde() {
        return this.colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
        setBorder(BorderFactory.createMatteBorder(this.grosorBorde, this.grosorBorde, this.grosorBorde, this.grosorBorde, colorBorde));
    }

    public boolean getHorizontalOrientacion() {
        return this.horizontalOrientacion;
    }

    public void setHorizontalOrientacion(boolean horizontalOrientacion) {
        this.horizontalOrientacion = horizontalOrientacion;
        if (this.horizontalOrientacion) {
            setOrientation(0);
            setPreferredSize(new Dimension(200, 30));
            setSize(new Dimension(200, 30));
        } else {
            setOrientation(1);
            setPreferredSize(new Dimension(30, 200));
            setSize(new Dimension(30, 200));
        }
    }
}
