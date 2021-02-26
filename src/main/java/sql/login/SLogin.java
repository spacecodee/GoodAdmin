package sql.login;

import sql.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SLogin {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM usuarios";
    private static final String SQL_SELECT_TOTAL_USERS = "SELECT COUNT(*) AS Cantidad FROM usuarios";
    private static final String SQL_SELECT_NOMBRE_USERS = "SELECT nombre FROM personas";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";

    public SLogin() {

    }

    public SLogin(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public int totalUsuarios() throws SQLException {
        int totalUsers = 0;

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = con.prepareStatement(SLogin.SQL_SELECT_TOTAL_USERS);
            res = pst.executeQuery();

            if (res.next())
                totalUsers = Integer.parseInt(res.getString("Cantidad"));

        } finally {
            cerrarConexiones(con, pst, res);
        }

        return totalUsers;
    }

    public List<String> nombreUsuarios() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<String> nombreUsers = new ArrayList<>();
        int i = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = con.prepareStatement(SLogin.SQL_SELECT_NOMBRE_USERS);
            res = pst.executeQuery();

            while (res.next())
                nombreUsers.add(res.getString("nombre"));

        } finally {
            cerrarConexiones(con, pst, res);
        }

        return nombreUsers;
    }

    private void cerrarConexiones(Connection con, PreparedStatement pst, ResultSet res) {
        try {
            assert res != null;
            Conexion.close(res);
            Conexion.close(pst);
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
