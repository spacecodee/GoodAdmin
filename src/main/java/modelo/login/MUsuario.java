package modelo.login;

import modelo.genericas.MPersona;

public class MUsuario extends MPersona {

    private int idUsuario;
    private String usuario;
    private String passwor;
    private int idRoll;

    public MUsuario() {
    }

    public MUsuario(int idPersona, String nombre, String apellidos, String correo, int telefono, int idUsuario,
                    String usuario, String passwor, int idRoll) {
        super(idPersona, nombre, apellidos, correo, telefono);
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.passwor = passwor;
        this.idRoll = idRoll;
    }

    public MUsuario(String nombre, String apellidos, String correo, int telefono, int idUsuario, String usuario, String passwor, int idRoll) {
        super(nombre, apellidos, correo, telefono);
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.passwor = passwor;
        this.idRoll = idRoll;
    }

    public MUsuario(String usuario, String passwor, int idRoll) {
        this.usuario = usuario;
        this.passwor = passwor;
        this.idRoll = idRoll;
    }

    public MUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswor() {
        return this.passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    public int getIdRoll() {
        return this.idRoll;
    }

    public void setIdRoll(int idRoll) {
        this.idRoll = idRoll;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                ", idUsuario=" + idUsuario +
                ", usuario='" + usuario + '\'' +
                ", passwor='" + passwor + '\'' +
                ", idRoll=" + idRoll +
                '}';
    }
}
