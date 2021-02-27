import controlador.login.CLogin;

import java.io.File;

public class TestContadorUsuarios {

    public static void main(String[] args) {

        CLogin cLogin = new CLogin();

        File file = new File("src/main/java/img/login/avatares/usuario1.png");
        //cLogin.actualizar(file, 5);

        File file1 = new File("src/main/java/img/login/avatares/usuario2.png");
        //cLogin.actualizar(file1, 6);

        File file2 = new File("src/main/java/img/login/avatares/usuario4.png");
        //cLogin.actualizar(file2, 7);

        File file3 = new File("src/main/java/img/login/avatares/usuario6.png");
        cLogin.actualizar(file3, 8);
    }
}
