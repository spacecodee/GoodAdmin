package vista.login.dialogos;

import mdlaf.MaterialLookAndFeel;
import recursos.RAgrImg;
import recursos.RColores;
import recursos.REfectoIniciarFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IniciarSesionUsuario extends JDialog {

    private JPanel[] pnlLados;
    private JPanel pnlTop;
    private JPanel pnlCentro;

    private JLabel lblCerrar;
    private JLabel lblImg;

    public IniciarSesionUsuario() {
        super();
        this.initComponents();
    }

    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.panelLados();
        this.panelTopBoton();
        this.lblCerrarDialogo();
        this.lblImgIlustracion();

        this.panelCentro();

        this.setUndecorated(true);
        this.setSize(700, 420);
        this.setLocationRelativeTo(null);

        REfectoIniciarFrame.iniciarTransparencia(this, 0.9F);

        this.setVisible(true);
    }

    private void panelLados() {
        this.pnlLados = new JPanel[2];

        for (var i = 0; i < this.pnlLados.length; i++) {
            this.pnlLados[i] = new JPanel();
            this.pnlLados[i].setLayout(new BorderLayout());
            this.pnlLados[i].setSize(307, 420);
            this.pnlLados[i].setPreferredSize(new Dimension(307, 420));
            this.pnlLados[i].setBackground(RColores.VERDE_CLARO_OPACO);

            this.add(this.pnlLados[i], BorderLayout.WEST);
            if (i > 1) {
                this.pnlLados[i].setSize(390, 420);
                this.pnlLados[i].setLayout(new BorderLayout());
                this.pnlLados[i].setPreferredSize(new Dimension(390, 420));
                this.pnlLados[i].setBackground(RColores.VERDE_CLARO_OPACO);

                this.add(this.pnlLados[i], BorderLayout.CENTER);
            }

        }
    }

    private void panelTopBoton() {
        this.pnlTop = new JPanel();
        this.pnlTop.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 8));
        this.pnlTop.setSize(307, 40);
        this.pnlTop.setPreferredSize(new Dimension(307, 40));
        this.pnlTop.setBackground(RColores.TRANSPARENCIA);

        this.pnlLados[0].add(this.pnlTop, BorderLayout.NORTH);
    }

    private void lblCerrarDialogo() {
        this.lblCerrar = new JLabel();
        this.lblCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.lblCerrar.setSize(24, 24);
        this.lblCerrar.setPreferredSize(new Dimension(24, 24));
        RAgrImg.agrImg("close-dark.png", this.lblCerrar);

        this.lblCerrar.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if (e.getSource() == IniciarSesionUsuario.this.lblCerrar) {
                            IniciarSesionUsuario.this.dispose();
                        }
                    }
                }
        );

        this.pnlTop.add(this.lblCerrar);
    }

    private void lblImgIlustracion() {
        this.lblImg = new JLabel();
        this.lblImg.setSize(273, 350);
        this.lblImg.setPreferredSize(new Dimension(273, 350));
        RAgrImg.agrImg("login/fondo3.png", this.lblImg);

        this.pnlLados[0].add(this.lblImg, BorderLayout.CENTER);
    }

    private void panelCentro() {
        this.pnlCentro = new JPanel();
        this.pnlCentro.setSize(307, 267);
        this.pnlCentro.setPreferredSize(new Dimension(307, 267));
        this.pnlCentro.setBackground(RColores.TRANSPARENCIA);

        this.pnlLados[0].add(this.pnlCentro, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new IniciarSesionUsuario();
    }
}
