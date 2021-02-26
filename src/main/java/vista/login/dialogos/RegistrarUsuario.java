package vista.login.dialogos;

import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import recursos.RAgrImg;
import recursos.RColores;
import recursos.REfectoIniciarFrame;
import recursos.RFuentes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarUsuario extends JDialog {

    private JPanel[] pnlLados;
    private JPanel[] pnlLadoLogin;
    private JPanel pnlTop;
    private JPanel pnlCentro;
    private JPanel pnlCentroLogin;

    private JLabel lblCerrar;
    private JLabel lblImg;
    private JLabel lblSms;
    private JLabel lblOlvidePassword;

    private JTextField txtUser;

    private JPasswordField txtPassword;

    private JButton btnIniciarSesion;

    private JComboBox<String> cbxRoles;

    public RegistrarUsuario() {
        super();
        this.initComponents();
    }

    public RegistrarUsuario(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
    }

    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.panelLados();
        this.panelTopBoton();
        this.lblCerrarDialogo();

        this.panelCentro();
        this.lblImgIlustracion();

        this.panelLadoLogin();
        this.panelesLadoLogin();

        this.lblMensaje();

        this.formulario();

        this.setUndecorated(true);
        this.setSize(700, 420);
        this.setLocationRelativeTo(null);

        REfectoIniciarFrame.iniciarTransparenciaDialogo(this, 0.9F);

        //this.setVisible(true);
    }

    private void panelLados() {
        this.pnlLados = new JPanel[2];

        for (var i = 0; i < this.pnlLados.length; i++) {
            this.pnlLados[i] = new JPanel();
            this.pnlLados[i].setLayout(new BorderLayout());
            this.pnlLados[i].setSize(307, 420);
            this.pnlLados[i].setPreferredSize(new Dimension(307, 420));
            this.pnlLados[i].setBackground(RColores.VERDE_CLARO_OPACO);

            if (i > 0) {
                this.pnlLados[i].setLayout(new BorderLayout());
                this.pnlLados[i].setSize(390, 420);
                this.pnlLados[i].setPreferredSize(new Dimension(390, 420));
                this.pnlLados[i].setBackground(RColores.BLANCO_MENOS_GRIS);

            }
        }

        //recomendacion: nunca agregar objetos dentro de un cliclo
        this.add(this.pnlLados[0], BorderLayout.WEST);
        this.add(this.pnlLados[1], BorderLayout.CENTER);
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
                        if (e.getSource() == RegistrarUsuario.this.lblCerrar) {
                            RegistrarUsuario.this.dispose();
                        }
                    }
                }
        );

        this.pnlTop.add(this.lblCerrar);
    }

    private void panelCentro() {
        this.pnlCentro = new JPanel();
        this.pnlCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));
        this.pnlCentro.setSize(307, 267);
        this.pnlCentro.setPreferredSize(new Dimension(307, 267));
        this.pnlCentro.setBackground(RColores.TRANSPARENCIA);

        this.pnlLados[0].add(this.pnlCentro, BorderLayout.CENTER);
    }

    private void lblImgIlustracion() {
        this.lblImg = new JLabel();
        this.lblImg.setSize(273, 273);
        this.lblImg.setPreferredSize(new Dimension(273, 273));
        RAgrImg.agrImg("login/fondo3.png", this.lblImg);

        this.pnlCentro.add(this.lblImg);
    }

    private void panelLadoLogin() {
        this.pnlCentroLogin = new JPanel();
        this.pnlCentroLogin.setLayout(new BorderLayout());
        this.pnlCentroLogin.setSize(new Dimension(390, 420));
        this.pnlCentroLogin.setPreferredSize(new Dimension(390, 420));
        this.pnlCentroLogin.setBackground(RColores.BLANCO_MENOS_GRIS);

        this.pnlLados[1].add(this.pnlCentroLogin, BorderLayout.CENTER);
    }

    private void panelesLadoLogin() {
        this.pnlLadoLogin = new JPanel[2];

        for (var i = 0; i < this.pnlLadoLogin.length; i++) {
            this.pnlLadoLogin[i] = new JPanel();

            this.pnlLadoLogin[i].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
            this.pnlLadoLogin[i].setSize(390, 120);
            this.pnlLadoLogin[i].setPreferredSize(new Dimension(390, 120));
            this.pnlLadoLogin[i].setBackground(RColores.BLANCO_MENOS_GRIS);

            if (i > 0) {
                this.pnlLadoLogin[i].setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
                this.pnlLadoLogin[i].setSize(390, 120);
                this.pnlLadoLogin[i].setPreferredSize(new Dimension(390, 300));
                this.pnlLadoLogin[i].setBackground(RColores.BLANCO_MENOS_GRIS);
            }

        }

        this.pnlCentroLogin.add(this.pnlLadoLogin[0], BorderLayout.NORTH);
        this.pnlCentroLogin.add(this.pnlLadoLogin[1], BorderLayout.CENTER);
    }

    private void lblMensaje() {
        this.lblSms = new JLabel("Registrar un nuevo usuario".toUpperCase());
        this.lblSms.setSize(new Dimension(314, 20));
        this.lblSms.setPreferredSize(new Dimension(314, 20));
        this.lblSms.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lblSms.setFont(RFuentes.getFuentePlana(19));
        this.lblSms.setForeground(RColores.NEGRO_OPCACO);
        this.pnlLadoLogin[0].add(this.lblSms);
    }

    private void formulario() {
        this.cbxRoles = new JComboBox<>(new DefaultComboBoxModel<>(
                new String[]{
                        "Administrador", "Usuario"
                }
        ));
        this.cbxRoles.setSize(new Dimension(250, 35));
        this.cbxRoles.setPreferredSize(new Dimension(250, 35));
        this.cbxRoles.setBackground(RColores.BLANCO_MENOS_GRIS);
        this.cbxRoles.setForeground(RColores.NEGRO_OPCACO);
        this.cbxRoles.setToolTipText("Roles de usuario");
        this.cbxRoles.setBorder(new LineBorder(RColores.VERDE_CLARO, 2, true));

        this.txtUser = new JTextField();
        this.txtUser.setSize(new Dimension(250, 35));
        this.txtUser.setPreferredSize(new Dimension(250, 35));
        this.txtUser.setFont(RFuentes.getFuentePlana(14));
        this.txtUser.setBackground(RColores.BLANCO_MENOS_GRIS);
        this.txtUser.setForeground(RColores.NEGRO_OPCACO);
        this.txtUser.setToolTipText("Usuario");

        this.txtPassword = new JPasswordField();
        this.txtPassword.setSize(new Dimension(250, 35));
        this.txtPassword.setPreferredSize(new Dimension(250, 35));
        this.txtPassword.setFont(RFuentes.getFuentePlana(14));
        this.txtPassword.setBackground(RColores.BLANCO_MENOS_GRIS);
        this.txtPassword.setForeground(RColores.NEGRO_OPCACO);
        this.txtPassword.setToolTipText("Password");

        this.lblOlvidePassword = new JLabel("¿Olvidó su contraseña?");
        this.lblOlvidePassword.setSize(new Dimension(250, 10));
        this.lblOlvidePassword.setPreferredSize(new Dimension(250, 12));
        this.lblOlvidePassword.setFont(RFuentes.getFuentePlana(12));
        this.lblOlvidePassword.setBackground(RColores.BLANCO_MENOS_GRIS);
        this.lblOlvidePassword.setForeground(RColores.NEGRO_OPCACO);
        this.lblOlvidePassword.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblOlvidePassword.setHorizontalAlignment(SwingConstants.RIGHT);

        this.btnIniciarSesion = new JButton();
        this.btnIniciarSesion.setSize(250, 40);
        this.btnIniciarSesion.setBorder(null);
        this.btnIniciarSesion.setOpaque(false);
        this.btnIniciarSesion.setFocusable(false);
        this.btnIniciarSesion.setFocusPainted(false);
        this.btnIniciarSesion.setContentAreaFilled(false);
        RAgrImg.agrImg("login/boton-registrar.png", this.btnIniciarSesion);

        this.btnIniciarSesion.addMouseListener(MaterialUIMovement.getMovement( //elimina el color al presionar el boton
                this.btnIniciarSesion, RColores.TRANSPARENCIA)
        );

        this.pnlLadoLogin[1].add(this.cbxRoles);
        this.pnlLadoLogin[1].add(this.txtUser);
        this.pnlLadoLogin[1].add(this.txtPassword);
        this.pnlLadoLogin[1].add(this.lblOlvidePassword);
        this.pnlLadoLogin[1].add(this.btnIniciarSesion);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new RegistrarUsuario().setVisible(true);
    }

    public JTextField getTxtUser() {
        return this.txtUser;
    }

    public void setTxtUser(JTextField txtUser) {
        this.txtUser = txtUser;
    }
}
