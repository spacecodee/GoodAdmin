package controlador.login;

import sql.Conexion;
import sql.login.SLogin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CLogin {

    private Connection con = null;
    private SLogin sLogin;

    public int getTotalUsers() {
        int totalUsuarios = 0;

        try {
            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            this.sLogin = new SLogin(this.con);

            totalUsuarios = this.sLogin.totalUsuarios();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }

        return totalUsuarios;
    }

    public List<String> getNombreUsers() {
        List<String> nombreUsuarios = new ArrayList<>();

        try {
            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            this.sLogin = new SLogin(this.con);

            nombreUsuarios = this.sLogin.nombreUsuarios();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }

        return nombreUsuarios;
    }
}
