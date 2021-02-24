package vista.login.paneles;

import mdlaf.animation.MaterialUIMovement;
import recursos.RAgrImg;
import recursos.RColores;
import recursos.RFuentes;

import javax.swing.*;
import java.awt.*;

public class PanelLateralLogin extends JPanel {

    private JPanel[] panels;
    private JLabel lblImgCard;
    private JButton btnAgregar;
    private JLabel lblSms;
    private FlowLayout flowLayout;
    private JPanel pnlBotonesYSms;

    public PanelLateralLogin() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.panelesMargenes();
        this.agregarImg();
        this.panelContenedor();
        this.agregarBoton();
        this.agregarLblSms();

        this.setSize(450, 660);
        this.setPreferredSize(new Dimension(450, 660));
        this.setBackground(RColores.BLANCO_MENOS_OPACO);
    }

    private void panelesMargenes() {
        this.flowLayout = new FlowLayout(FlowLayout.CENTER, 4, 15);
        this.panels = new JPanel[2];

        for (var i = 0; i < this.panels.length; i++) {
            this.panels[i] = new JPanel();
        }

        this.panels[0].setPreferredSize(new Dimension(450, 110));
        this.panels[0].setBackground(RColores.BLANCO_MENOS_OPACO);
        this.add(this.panels[0], BorderLayout.NORTH);

        this.panels[1].setPreferredSize(new Dimension(450, 550));
        this.panels[1].setLayout(this.flowLayout);
        this.panels[1].setBackground(RColores.BLANCO_MENOS_OPACO);
        this.add(this.panels[1], BorderLayout.CENTER);

        /*this.panels[2].setPreferredSize(new Dimension(450, 82));
        this.panels[2].setBackground(RColores.BLANCO_OPACO);
        this.add(this.panels[2], BorderLayout.SOUTH);*/
    }

    private void agregarImg() {
        this.lblImgCard = new JLabel();
        this.lblImgCard.setSize(new Dimension(380, 380));
        RAgrImg.agrImg("login/card.png", this.lblImgCard);
        this.panels[1].add(this.lblImgCard);
    }

    private void panelContenedor() {
        this.pnlBotonesYSms = new JPanel();
        this.pnlBotonesYSms.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        this.pnlBotonesYSms.setSize(380, 160);
        this.pnlBotonesYSms.setPreferredSize(new Dimension(380, 160));
        this.pnlBotonesYSms.setBackground(RColores.BLANCO_MENOS_OPACO);
        this.panels[1].add(this.pnlBotonesYSms);
    }

    private void agregarBoton() {
        this.btnAgregar = new JButton();
        this.btnAgregar.setSize(300, 50);
        this.btnAgregar.setBorder(null);
        this.btnAgregar.setOpaque(false);
        this.btnAgregar.setFocusable(false);
        this.btnAgregar.setFocusPainted(false);
        this.btnAgregar.setContentAreaFilled(false);
        RAgrImg.agrImg("login/boton-agegar-usuario.png", this.btnAgregar);
        this.pnlBotonesYSms.add(this.btnAgregar);

        this.btnAgregar.addMouseListener(MaterialUIMovement.getMovement( //elimina el color al presionar el boton
                this.btnAgregar, RColores.TRANSPARENCIA)
        );
    }

    private void agregarLblSms() {
        this.lblSms = new JLabel("TE QUEDAN: 1, PERFILES DE USUARIOS");
        this.lblSms.setSize(300, 16);
        this.lblSms.setFont(RFuentes.getFuentePlana(14));
        this.pnlBotonesYSms.add(this.lblSms);
    }

    public JLabel getLblSms() {
        return lblSms;
    }

    public void setLblSms(JLabel lblSms) {
        this.lblSms = lblSms;
    }

    public FlowLayout getFlowLayout() {
        return flowLayout;
    }

    public void setFlowLayout(FlowLayout flowLayout) {
        this.flowLayout = flowLayout;
    }
}
