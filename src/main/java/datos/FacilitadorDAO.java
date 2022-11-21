package datos;

import dominios.Facilitador;
import java.sql.*;
import java.util.*;

public class FacilitadorDAO {
    /* Metodo para listar */
    public List<Facilitador> Listar() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Facilitador facilitador = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Facilitador> Facilitadores = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_facilitador()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {   
                int idFacilitador = rs.getInt("id_facilitador");
                String nombreFaciitador = rs.getString("nombre_facilitador");
                String estudio = rs.getString("estudio");
                String estadoFacilitador = rs.getString("estado_facilitador");
                
                /* Creamos un nuevo objeto y asignamos el objeto de facilitadores */
                facilitador = new Facilitador(idFacilitador, nombreFaciitador, estudio, estadoFacilitador);
            
                /* Agregamos el objeto a la lista de facilitadores */
                Facilitadores.add(facilitador);
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
        
        return Facilitadores;
       
    }
    
    public List<Facilitador> listarCompleto() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Facilitador facilitador = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Facilitador> Facilitadores = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_facilitador_completo()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {   
                int idFacilitador = rs.getInt("id_facilitador");
                String nombreFaciitador = rs.getString("nombre_facilitador");
                String estudio = rs.getString("estudio");
                String estadoFacilitador = rs.getString("estado_facilitador");
                
                /* Creamos un nuevo objeto y asignamos el objeto de facilitadores */
                facilitador = new Facilitador(idFacilitador, nombreFaciitador, estudio, estadoFacilitador);
            
                /* Agregamos el objeto a la lista de facilitadores */
                Facilitadores.add(facilitador);
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
        
        return Facilitadores;
       
    }
    
     /* Insertar datos a la base de datos */
    public int insertar(Facilitador facilitador) {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        /* Cuando recuperamos informacion usamos el ResultSet */
        /* Pero cuando se quieren afectar filas no se usa  */
        
        try{
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareStatement("{call SP_agregar_facilitador(?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setString(1, facilitador.getNombreFacilitador());
            stmt.setString(2, facilitador.getEstudio());
            stmt.setString(3, facilitador.getEstadoFacilitador());
            
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }finally{
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    /* Actualizar, ya la sabemos */
    public int actualizar(Facilitador facilitador){
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
            stmt = conn.prepareStatement("{call SP_actualizar_facilitador(?,?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, facilitador.getIdFacilitador());
            stmt.setString(2, facilitador.getNombreFacilitador());
            stmt.setString(3, facilitador.getEstudio());
            stmt.setString(4, facilitador.getEstadoFacilitador());
             
            /* Almacenamos la cantidad de registros que se han modificado */
            rows = stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /* Traer informacion para llenar los campos de editar */
    public Facilitador encontrar(Facilitador facilitador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call SP_buscar_facilitador(?)}");
            stmt.setInt(1, facilitador.getIdFacilitador());
            
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos por medio del id */
                int idFacilitador =  rs.getInt("id_facilitador"); 
                String nombreFacilitador = rs.getString("nombre_facilitador");
                String estudio = rs.getString("estudio");
                String estadoFacilitador = rs.getString("estado_facilitador");
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                facilitador = new Facilitador(idFacilitador, nombreFacilitador, estudio, estadoFacilitador);
            }


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return facilitador;
    }
    
        /* Eliminamos el dato, en realidad inhabilitamos */
    public int eliminar(Facilitador facilitador) {
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
            stmt = conn.prepareStatement("{call SP_eliminar_facilitador(?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, facilitador.getIdFacilitador());
            
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
}
