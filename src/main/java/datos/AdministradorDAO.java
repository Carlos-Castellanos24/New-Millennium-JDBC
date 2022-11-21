package datos;

import dominios.Administrador;
import java.sql.*;
import java.util.*;

public class AdministradorDAO {
    /* Metodo para listar */
    public List<Administrador> Listar() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Administrador administrador = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Administrador> administradores = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            /* Consulta para la tabla administrador y login */
            stmt = conn.prepareCall("{call SP_listar_administrador()}");
            
            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                int idAdministrador = rs.getInt("id_administrador");
                String nombreAdministrador = rs.getString("nombre");
                String apellidoAdministrador = rs.getString("apellido");
                String estadoAdministrador = rs.getString("estado_administrador");
                String correoLogin = rs.getString("correo");
                String estadoLogin = rs.getString("estado_login");
                
                /* Creamos un nuevo objeto y asignamos a la variable de administrador */
                administrador = new Administrador(idAdministrador, nombreAdministrador, apellidoAdministrador, estadoAdministrador, correoLogin, estadoLogin);
                
                /* Agregamos el objeto a la lista de administradores */
                administradores.add(administrador);
            }
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return administradores;
    }
    
    public int insertarAdministrador(Administrador administrador){
       /* Importamos todo lo que vamos a utilizar */
       Connection conn = null;
       PreparedStatement stmt = null;
       int rows = 0;
       /* Cuando recuperamos informacion usamos el ResultSet */
       /* Pero cuando se quieren afectar filas no se usa  */

       try
       {
           /* Obetenmos la conexion */
           conn = Conexion.getConnection();

           /* Inicializamos la consulta */
           stmt = conn.prepareStatement("{call SP_agregar_administrador(?,?,?)}");
           /* Añadimos los parametros que requiere la consulta */
           /* El parametros empieza por el 1 */
           stmt.setString(1, administrador.getNombreAdministrador());
           stmt.setString(2, administrador.getApellidoAdministrador());
           stmt.setString(3, administrador.getEstadoAdministrador());

           /* Almacenamos la cantidad de registros que se han modificado */
           rows = stmt.executeUpdate();

       } catch (SQLException e)
       {
           e.printStackTrace(System.out);
       } finally {
           /* Se cierran en el orden inverso que se abrieron */
           Conexion.close(stmt);
           Conexion.close(conn);
       }

       return rows;
   }
    
    public int insertarLogin(Administrador administrador){
       /* Importamos todo lo que vamos a utilizar */
       Connection conn = null;
       PreparedStatement stmt = null;
       int rows = 0;
       /* Cuando recuperamos informacion usamos el ResultSet */
       /* Pero cuando se quieren afectar filas no se usa  */

       try
       {
           /* Obetenmos la conexion */
           conn = Conexion.getConnection();

           /* Inicializamos la consulta */
           stmt = conn.prepareStatement("{call SP_agregar_login(?,?,?,?)}");
           /* Añadimos los parametros que requiere la consulta */
           /* El parametros empieza por el 1 */
           stmt.setInt(1, administrador.getIdAdministrador());
           stmt.setString(2, administrador.getCorreoLogin());
           stmt.setString(3, administrador.getClaveLogin());
           stmt.setString(4, administrador.getEstadoLogin());

           /* Almacenamos la cantidad de registros que se han modificado */
           rows = stmt.executeUpdate();

       } catch (SQLException e)
       {
           e.printStackTrace(System.out);
       } finally {
           /* Se cierran en el orden inverso que se abrieron */
           Conexion.close(stmt);
           Conexion.close(conn);
       }

       return rows;
   }
    
    /* Actualizar, ya la sabemos */
    public int actualizarAdministrador(Administrador usuarios){
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement("{call SP_actualizar_administrador(?,?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, usuarios.getIdAdministrador());
            stmt.setString(2, usuarios.getNombreAdministrador());
            stmt.setString(3, usuarios.getApellidoAdministrador());
            stmt.setString(4, usuarios.getEstadoAdministrador());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }

    public int actualizarLogin(Administrador usuarios){
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement("{CALL SP_actualizar_login(?,?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, usuarios.getIdLogin());
            stmt.setInt(2, usuarios.getIdAdministrador());
            stmt.setString(3, usuarios.getCorreoLogin());
            stmt.setString(4, usuarios.getEstadoLogin());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int obtenerUltimoAdmin() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idAdministrador = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call SP_obtener_administrador()}");
            
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos por medio del id */
                idAdministrador = rs.getInt("id_administrador");
            }


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return idAdministrador;
    }
    
    
    /* Eliminamos el dato, en realidad inhabilitamos */
    public int eliminarAdministrador(Administrador usuarios) {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement("{CALL SP_eliminar_administrador(?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, usuarios.getIdAdministrador());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        } catch (SQLException e)
        {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public Administrador encontrar(Administrador usuarios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call SP_buscar_administrador(?)}");
            stmt.setInt(1, usuarios.getIdAdministrador());
            
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos por medio del id */
                int idAdministrador = rs.getInt("id_Administrador");
                int idLogin = rs.getInt("id_Login");                
                String nombreAdministrador = rs.getString("nombre");
                String apellidoAdministrador = rs.getString("apellido");
                String correoLogin = rs.getString("correo");                
                String estadoAdministrador = rs.getString("estado_administrador");
                
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                usuarios = new Administrador(idAdministrador, idLogin, nombreAdministrador, apellidoAdministrador, correoLogin, estadoAdministrador);
            }


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return usuarios;
    }
    
    /* Los demas metodos, agregenlos aqui */
    /* De ultimo dejen el del login */
    
    /* Metodo para inicar sesion - login */
    public Administrador login(String correoLogin, String claveLogin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Administrador administrador = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call validar_login_administrador(?,?)}");
            stmt.setString(1, correoLogin);
            stmt.setString(2, claveLogin);
            
            rs = stmt.executeQuery();
            
            /* Inicializamos las variables */
            int idAdministrador = 0;
            String nombreLogin = null;
            String apellidoLogin = null;
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos */
                idAdministrador = rs.getInt("id_administrador");      
                nombreLogin = rs.getString("nombre");
                apellidoLogin = rs.getString("apellido");
            }
            
            if (idAdministrador > 0){
                /* Creamos un nuevo objeto y asignamos a los datos del usuario */
                administrador = new Administrador(idAdministrador, nombreLogin, apellidoLogin, correoLogin, 1);
            } else {
                /* Si el usuario no existe, devolvemos vacio el objeto */
                administrador = new Administrador(0);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return administrador;
    }
}
