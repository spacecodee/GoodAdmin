import controlador.login.CLogin;
import sql.login.SLogin;

public class TestContadorUsuarios {

    public static void main(String[] args) {
        SLogin sLogin = new SLogin();
        CLogin cLogin = new CLogin();

        System.out.println(cLogin.getTotalUsers());
    }
}
