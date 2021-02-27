package modelo.login;

public class MRolesUsers {
    private int idRoles;
    private String nombre;

    public MRolesUsers() {
    }

    public int getIdRoles() {
        return this.idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
