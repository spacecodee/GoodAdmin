package recursos;

import java.awt.*;

public class RFuentes {
    private static Font fuentePlana;
    private static Font fuenteNegrita;

    public static Font getFuentePlana(int tamanio) {
        return RFuentes.fuentePlana = new Font("Gilroy", Font.PLAIN, tamanio);
    }

    public static Font getFuenteNegrita(int tamanio) {
        return RFuentes.fuentePlana = new Font("Gilroy", Font.BOLD, tamanio);
    }
}
