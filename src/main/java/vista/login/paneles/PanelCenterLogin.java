package vista.login.paneles;

import controlador.login.CLogin;
import recursos.RColores;
import recursos.RFuentes;
import vista.login.VLogin;
import vista.login.dialogos.IniciarSesionUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PanelCenterLogin extends JPanel {

    private VLogin vLogin;

    private int totalUsrs;

    private JPanel[] pnlMargenes;
    private JPanel[] pnlUsuarios;
    private JPanel pnlCenter;
    private final PanelCentro panelCentro = new PanelCentro();
    private GridLayout gridLayout;
    private JLabel[] lblAvatares;
    private IniciarSesionUsuario iniciarSesionUsuario;

    //automatización
    private final CLogin cLogin = new CLogin();
    private final List<String> nombrePersonas = this.cLogin.getNombrePersonas();
    private final List<String> nombreUsuarios = this.cLogin.getNombreUsers();
    private JLabel[] lblNombres;
    private List<ImageIcon> imgs;

    public PanelCenterLogin() {
        super();
        this.initComponents(0);
    }

    public PanelCenterLogin(VLogin vLogin) {
        super();
        this.initComponents(0);
        this.vLogin = vLogin;
    }

    public PanelCenterLogin(VLogin vLogin, int totalUsrs) {
        super();
        this.initComponents(totalUsrs);
        this.vLogin = vLogin;
        this.totalUsrs = totalUsrs;
    }

    private void initComponents(int totalUsrs) {
        this.totalUsrs = totalUsrs;
        this.setLayout(new BorderLayout());

        this.margenes();
        this.add(this.panelCentro, BorderLayout.CENTER);
        this.margenes2();
        this.panelUsuarios();
        this.panelPerfilesUsuarios();
        this.agregarLlblImg();

        this.setSize(883, 660);
        this.setPreferredSize(new Dimension(883, 660));
        this.setBackground(RColores.BLANCO_MENOS_OPACO);
    }

    private void margenes() {
        this.pnlMargenes = new JPanel[4];

        for (var i = 0; i < this.pnlMargenes.length; i++) {
            this.pnlMargenes[i] = new JPanel();
            //top
            this.pnlMargenes[i].setPreferredSize(new Dimension(46, 90));
            this.pnlMargenes[i].setBackground(RColores.BLANCO_MENOS_OPACO);
            if (i >= 2) {
                //laterales
                this.pnlMargenes[i].setPreferredSize(new Dimension(34, 480));
                this.pnlMargenes[i].setBackground(RColores.BLANCO_MENOS_OPACO);
            }

        }

        //top
        this.add(this.pnlMargenes[0], BorderLayout.NORTH);
        this.add(this.pnlMargenes[1], BorderLayout.SOUTH);

        //laterales
        this.add(this.pnlMargenes[2], BorderLayout.WEST);
        this.add(this.pnlMargenes[3], BorderLayout.EAST);
    }

    private void margenes2() {
        this.pnlMargenes = new JPanel[4];

        for (var i = 0; i < this.pnlMargenes.length; i++) {
            this.pnlMargenes[i] = new JPanel();
            this.pnlMargenes[i].setPreferredSize(new Dimension(20, 20));
            this.pnlMargenes[i].setBackground(RColores.TRANSPARENCIA);
        }

        //top
        this.panelCentro.add(this.pnlMargenes[0], BorderLayout.NORTH);
        this.panelCentro.add(this.pnlMargenes[1], BorderLayout.SOUTH);

        //laterales
        this.panelCentro.add(this.pnlMargenes[2], BorderLayout.WEST);
        this.panelCentro.add(this.pnlMargenes[3], BorderLayout.EAST);
    }

    private void panelUsuarios() {
        this.pnlCenter = new JPanel();
        this.gridLayout = new GridLayout(2, 6, 10, 10);

        this.pnlCenter.setLayout(this.gridLayout);
        this.pnlCenter.setSize(720, 460);
        this.pnlCenter.setBackground(RColores.BLANCO_MENOS_OPACO);
        this.panelCentro.add(this.pnlCenter, BorderLayout.CENTER);
    }

    private void panelPerfilesUsuarios() {
        this.pnlUsuarios = new JPanel[this.totalUsrs];

        PanelCenterLogin.this.iniciarSesionUsuario = new IniciarSesionUsuario(
                PanelCenterLogin.this.vLogin, true
        );

        for (var i = 0; i < this.pnlUsuarios.length; i++) {
            this.pnlUsuarios[i] = new PanelUsuarios();
            this.pnlUsuarios[i].setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
            this.pnlUsuarios[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.pnlCenter.add(this.pnlUsuarios[i]);
        }

        for (var i = 0; i < this.pnlUsuarios.length; i++) {

            int finalI = i; //variabe para recorrer los nombres

            this.pnlUsuarios[i].addMouseListener( //mediante este evento abrimos cada jDialogo, ademas cada dialogo con su usuario en el
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);

                            PanelCenterLogin.this.iniciarSesionUsuario.getTxtUser().setText(
                                    PanelCenterLogin.this.nombreUsuarios.get(finalI)
                            );

                            PanelCenterLogin.this.iniciarSesionUsuario.getTxtUser().setEnabled(false);

                            PanelCenterLogin.this.iniciarSesionUsuario.setVisible(true);
                        }
                    }
            );
        }

    }

    private void agregarLlblImg() {
        this.lblAvatares = new JLabel[this.totalUsrs];
        this.lblNombres = new JLabel[this.totalUsrs];
        this.imgs = this.cLogin.imgAvatars();

        for (var i = 0; i < this.pnlUsuarios.length; i++) {
            this.lblAvatares[i] = new JLabel();
            this.lblAvatares[i].setSize(new Dimension(90, 150));
            this.lblAvatares[i].setPreferredSize(new Dimension(90, 150));
            this.lblAvatares[i].setIcon(this.imgs.get(i));
            this.pnlUsuarios[i].add(this.lblAvatares[i]);

            this.lblNombres[i] = new JLabel(this.nombrePersonas.get(i));
            this.lblNombres[i].setFont(RFuentes.getFuenteNegrita(16));
            this.lblNombres[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.lblNombres[i].setSize(250, 20);
            this.lblNombres[i].setPreferredSize(new Dimension(250, 20));
            this.pnlUsuarios[i].add(this.lblNombres[i]);
        }
    }

    public int getTotalUsrs() {
        return totalUsrs;
    }

    public void setTotalUsrs(int totalUsrs) {
        this.totalUsrs = totalUsrs;
    }

    public JLabel[] getLblAvatares() {
        return lblAvatares;
    }

    public JLabel[] getLblNombres() {
        return lblNombres;
    }

    public GridLayout getGridLayout() {
        return gridLayout;
    }

    public JPanel[] getPnlMargenes() {
        return pnlMargenes;
    }

    public JPanel[] getPnlUsuarios() {
        return pnlUsuarios;
    }
}
