package sql.login;

import modelo.genericas.MPersona;
import sql.Conexion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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
    private static final String SQL_SELECT_NOMBRE_PERSONA = "SELECT nombre FROM personas";
    private static final String SQL_SELECT_USUARIO_USER = "SELECT usuario FROM usuarios";
    private static final String SQL_SELECT_FOTO_USERS = "SELECT foto FROM personas";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    private static final String SQL_UPDATE_FOTO = "UPDATE personas SET foto = ? WHERE id_persona = ?";
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

    public List<String> nombrePersonas() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<String> nombreUsers = new ArrayList<>();
        int i = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = con.prepareStatement(SLogin.SQL_SELECT_NOMBRE_PERSONA);
            res = pst.executeQuery();

            while (res.next())
                nombreUsers.add(res.getString("nombre"));

        } finally {
            cerrarConexiones(con, pst, res);
        }

        return nombreUsers;
    }

    public List<String> nombreUsuarios() throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<String> nombreUsers = new ArrayList<>();

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = con.prepareStatement(SLogin.SQL_SELECT_USUARIO_USER);
            res = pst.executeQuery();

            while (res.next())
                nombreUsers.add(res.getString("usuario"));

        } finally {
            cerrarConexiones(con, pst, res);
        }

        return nombreUsers;
    }

    public List<ImageIcon> imgs() throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;

        List<ImageIcon> imagens = new ArrayList<>();

        InputStream inputStream;
        ImageIcon icon;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = con.prepareStatement(SLogin.SQL_SELECT_FOTO_USERS);
            res = pst.executeQuery();

            while (res.next()) {
                inputStream = res.getBinaryStream("foto");

                BufferedImage bufferedImage = ImageIO.read(inputStream);
                icon = new ImageIcon(bufferedImage);

                Image img = icon.getImage();
                Image newImg = img.getScaledInstance(90, 150, Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(newImg);

                imagens.add(imageIcon);
            }

        } finally {
            cerrarConexiones(con, pst, res);
        }

        return imagens;
    }

    public void actualizarPersona(MPersona mPersona) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        //SQL_UPDATE_FOTO

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pst = con.prepareStatement(SLogin.SQL_UPDATE_FOTO);
            pst.setBytes(1, mPersona.getFoto());
            pst.setInt(2, mPersona.getIdPersona());
            pst.executeUpdate();
        } finally {
            cerrarConexiones(con, pst);
        }

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

    private void cerrarConexiones(Connection con, PreparedStatement pst) {
        try {
            Conexion.close(pst);
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
