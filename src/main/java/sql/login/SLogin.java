package sql.login;

import sql.Conexion;

import java.sql.*;

public class SLogin {

    private Connection conexionTransaccional;
    private Connection con = null;
    private PreparedStatement pst;
    private CallableStatement callSt = null;
    private ResultSet res = null;

    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_SELECT_TOTAL_USERS = "SELECT COUNT(*) FROM usuarios";
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

        this.con = null;
        this.pst = null;
        this.res = null;

        try {
            this.con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            this.pst = this.con.prepareStatement(SQL_SELECT_TOTAL_USERS);
            this.res = this.pst.executeQuery();

            totalUsers = res.getInt(1);

        } finally {
            try {
                assert this.res != null;
                Conexion.close(this.res);
                Conexion.close(this.pst);
                if (this.conexionTransaccional == null) {
                    Conexion.close(this.con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return totalUsers;
    }

}
