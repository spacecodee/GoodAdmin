package controlador.login;

import modelo.genericas.MPersona;
import modelo.login.MRolesUsers;
import sql.Conexion;
import sql.login.SLogin;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CLogin {

    private Connection con = null;
    private SLogin sLogin;
    //private ArrayList<MRolesUsers> mRolesUsers;

    public CLogin() {

    }

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

    public List<String> getNombrePersonas() {
        List<String> nombrePersonas = null;

        try {
            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            this.sLogin = new SLogin(this.con);

            nombrePersonas = this.sLogin.nombrePersonas();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }

        return nombrePersonas;
    }

    public List<String> getNombreUsers() {
        List<String> nombreUsuarios = null;

        try {
            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            this.sLogin = new SLogin();

            nombreUsuarios = this.sLogin.nombreUsuarios();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return nombreUsuarios;
    }

    public void llenarCbx(JComboBox<MRolesUsers> cbxRoles) {
        ArrayList<MRolesUsers> mRolesUsers;
        cbxRoles.removeAllItems();
        try {

            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            this.sLogin = new SLogin();

            mRolesUsers = this.sLogin.mRolesUsers();

            for (Object mRolesUser : mRolesUsers) {
                MRolesUsers mRolesU = (MRolesUsers) mRolesUser;
                cbxRoles.addItem(mRolesU);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public List<ImageIcon> imgAvatars() {
        List<ImageIcon> imageIcons = null;

        try {

            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            this.sLogin = new SLogin(this.con);
            imageIcons = this.sLogin.imgs();

        } catch (SQLException | IOException ex) {
            ex.printStackTrace(System.out);
        }

        return imageIcons;
    }

    public void actualizar(File ruta, int id) {
        MPersona mPersona = new MPersona();
        this.sLogin = new SLogin(this.con);

        mPersona.setIdPersona(id);
        try {
            this.con = Conexion.getConnection();

            if (this.con.getAutoCommit()) {
                this.con.setAutoCommit(false);
            }

            byte[] icono = new byte[(int) ruta.length()];
            InputStream inputStream = new FileInputStream(ruta);
            inputStream.read(icono);
            mPersona.setFoto(icono);

            sLogin.actualizarPersona(mPersona);
            System.out.println("Persona modificada");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace(System.out);
        }

    }
}
