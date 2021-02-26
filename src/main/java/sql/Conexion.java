package sql;

import java.sql.*;

public class Conexion {
    private static final String JDBC_BD = "good-admin";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "RONNYharol07";
    private static final String JDBC_REQUERIMIENTOS = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + Conexion.JDBC_BD + Conexion.JDBC_REQUERIMIENTOS;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Conexion.JDBC_URL, Conexion.JDBC_USER, Conexion.JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement st) throws SQLException {
        st.close();
    }

    public static void close(PreparedStatement pst) throws SQLException {
        pst.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
        System.out.println("Cerrada");
    }
}
