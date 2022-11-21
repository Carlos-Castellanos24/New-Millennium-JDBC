package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/millennium_calendar_db?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private static BasicDataSource dataSource;

    /* Metodo que recuperara una conexion a la base de datos */
    public static DataSource getDataSource() {
        if (dataSource == null)
        {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            /* Tamaño inicial del pull de conexiones */
            dataSource.setInitialSize(30);
        }

        return dataSource;
    }

    /* Metodo para obtener un conexion */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    /* Metodos para cerrar los objetos utilizados */
    public static void close(ResultSet rs) {
        try
        {
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try
        {
            stmt.close();
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try
        {
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }
    }
}
