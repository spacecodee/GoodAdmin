package controlador.splash;

import componentes.CBarraProgreso;
import vista.login.VLogin;
import vista.splash.VSplash;

import javax.swing.*;

public class CIniciarSplash extends Thread {
    private CBarraProgreso cBarraProgreso;
    private VSplash window;
    private JLabel lblSms;
    private JLabel lblPorcentaje;

    public CIniciarSplash() {
    }

    public CIniciarSplash(CBarraProgreso cBarraProgreso, VSplash window, JLabel lblSms, JLabel lblPorcentaje) {
        this.cBarraProgreso = cBarraProgreso;
        this.window = window;
        this.lblSms = lblSms;
        this.lblPorcentaje = lblPorcentaje;
    }

    @Override
    public void run() {
        super.run();
        this.setProgreso(0);
        this.setProgreso(10);
        this.setProgreso(20);
        this.setProgreso(30);
        this.setProgreso(40);
        this.setProgreso(50);
        this.setProgreso(60);
        this.setProgreso(70);
        this.setProgreso(80);
        this.setProgreso(90);
        this.setProgreso(92);
        this.setProgreso(94);
        this.setProgreso(96);
        this.setProgreso(98);
        this.setProgreso(99);
        this.setProgreso(100);
    }

    public void pause(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void setProgreso(int value) {
        cBarraProgreso.setValue(value);
        pause(1000);

        switch (value) {
            case 0:
                lblSms.setText("Conectando a la base de datos".toUpperCase());
                pause(1000);
                this.lblPorcentaje.setText("10%");
                break;

            case 10:
                lblSms.setText("Cargando librerias".toUpperCase());
                pause(500);
                this.lblPorcentaje.setText("20%");
                break;

            case 20:
                lblSms.setText("Validando que todo vaya excelente".toUpperCase());
                pause(800);
                this.lblPorcentaje.setText("30%");
                break;

            case 30:
                lblSms.setText("Espere un poco".toUpperCase());
                pause(1000);
                this.lblPorcentaje.setText("40%");
                break;

            case 40:
                lblSms.setText("Cargando diseños".toUpperCase());
                pause(400);
                this.lblPorcentaje.setText("50%");
                break;

            case 50:
                lblSms.setText("Esperando a la base de datos".toUpperCase());
                pause(600);
                this.lblPorcentaje.setText("60%");
                break;

            case 60:
                lblSms.setText("Cargando Login".toUpperCase());
                pause(1000);
                this.lblPorcentaje.setText("70%");
                break;

            case 70:
                lblSms.setText("Casí listo".toUpperCase());
                pause(800);
                this.lblPorcentaje.setText("80%");
                break;

            case 80:
                lblSms.setText("Abriendo en: 0".toUpperCase());
                pause(1000);
                this.lblPorcentaje.setText("90%");
                break;

            case 90:
                lblSms.setText("Abriendo en: 2".toUpperCase());
                this.lblPorcentaje.setText("92%");
                pause(200);
                break;

            case 92:
                lblSms.setText("Abriendo en: 4".toUpperCase());
                pause(200);
                this.lblPorcentaje.setText("94%");
                break;

            case 94:
                lblSms.setText("Abriendo en: 6".toUpperCase());
                pause(400);
                this.lblPorcentaje.setText("96%");
                break;

            case 96:
                lblSms.setText("Abriendo en: 8".toUpperCase());
                pause(200);
                this.lblPorcentaje.setText("98%");
                break;

            case 98:
                lblSms.setText("Abriendo en: 9".toUpperCase());
                pause(300);
                this.lblPorcentaje.setText("99%");
                break;

            case 99:
                lblSms.setText("Bienvenido (a)".toUpperCase());
                this.lblPorcentaje.setText("100%");
                pause(200);
                break;

            case 100:
                pause(500);
                window.dispose();
                new VLogin();
                break;

            default:
                break;
        }
    }
}
