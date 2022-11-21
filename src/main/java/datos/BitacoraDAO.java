package datos;

import dominios.Bitacora;
import java.sql.*;
import java.util.*;

public class BitacoraDAO {
    /* Listamos la informacion de la bitacora */
    public List<Bitacora> Listar() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bitacora bitacora = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Bitacora> bitacoras = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_bitacora()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                int idRegistro = rs.getInt("id_registro");
                int idAdministrador = rs.getInt("id_administrador");
                String tipoRegistro = rs.getString("tipo_registro");
                String fechaRegistro = rs.getString("fecha_registro");
                String descripcionRegistro = rs.getString("descripcion_registro");
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                bitacora = new Bitacora(idRegistro, idAdministrador, tipoRegistro, fechaRegistro, descripcionRegistro);
            
                /* Agregamos el objeto a la lista de actividad */
                bitacoras.add(bitacora);
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
        
        return bitacoras;
    }

    /* Insertamos una bitacora */
    public int insertar(Bitacora bitacora){
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
            stmt = conn.prepareStatement("{call SP_agregar_bitacora(?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, bitacora.getIdAdministrador());
            stmt.setString(2, bitacora.getTipoRegistro());
            stmt.setString(3, bitacora.getDescripcionRegistro());

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
    
    /* Concatenamos la descripcion de la bitacora */
    /* Ejemplo de salida: Melissa inserto una categoría con el nombre: Desarrollo web */
    public String descripcionBitacora(String nombreAdministrador, String accion, String tabla, String dato) {
        return nombreAdministrador + " " + accion +" un/a " + tabla + " con el nombre: " + dato;
    }
}
