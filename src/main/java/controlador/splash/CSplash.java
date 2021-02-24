package controlador.splash;

import componentes.CBarraProgreso;
import vista.splash.VSplash;

import javax.swing.*;

public class CSplash {
    private CIniciarSplash hilo;
    private CBarraProgreso cBarraProgreso;

    public CBarraProgreso getcBarraProgreso() {
        return cBarraProgreso;
    }

    public void setcBarraProgreso(CBarraProgreso cBarraProgreso) {
        this.cBarraProgreso = cBarraProgreso;
    }

    public void starThread(CBarraProgreso cBarraProgreso, VSplash window, JLabel lblSms, JLabel lblPorcentaje) {
        this.hilo = new CIniciarSplash(cBarraProgreso, window, lblSms, lblPorcentaje);
        this.hilo.start();
        this.hilo = null;
    }
}
