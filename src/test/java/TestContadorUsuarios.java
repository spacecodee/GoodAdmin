import controlador.login.CLogin;

import java.io.File;

public class TestContadorUsuarios {

    public static void main(String[] args) {

        CLogin cLogin = new CLogin();

        File file = new File("src/main/java/img/login/avatares/usuario1.png");
        cLogin.actualizar(file, 3);
    }
}
