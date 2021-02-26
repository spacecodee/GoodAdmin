package ejecutador;

import mdlaf.MaterialLookAndFeel;
import vista.splash.VSplash;

import javax.swing.*;

public class Exe {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        new VSplash();
    }
}
