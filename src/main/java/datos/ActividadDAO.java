package datos;

import dominios.Actividad;
import java.sql.*;
import java.util.*;

public class ActividadDAO {
    
    /* Metodo para listar */
    public List<Actividad> Listar() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Actividad actividad = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Actividad> Actividades = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_actividad()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                String nombreCategoria = rs.getString("nombre_categoria");
                String nombreFacilitador = rs.getString("nombre_facilitador");
                String nombreActividad = rs.getString("nombre_actividad");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFinal = rs.getString("fecha_final");
                String diasSemana = rs.getString("dias_semana");
                String horasDias = rs.getString("horas_dias");
                String descripcion = rs.getString("descripcion");
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                actividad = new Actividad(nombreActividad, fechaInicio, fechaFinal, diasSemana, horasDias, descripcion, nombreCategoria, nombreFacilitador);
            
                /* Agregamos el objeto a la lista de actividad */
                Actividades.add(actividad);
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
        
        return Actividades;
    }

    /* Metodo para listar todos los detalles */
    public List<Actividad> ListarDetalles() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Actividad actividad = null;
        
        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Actividad> Actividades = new ArrayList<>();
        
        try
        {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_actividad_detalles()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                String nombreCategoria = rs.getString("nombre_categoria");
                String nombreFacilitador = rs.getString("nombre_facilitador");
                int idActividad = rs.getInt("id_actividad");
                int idCategoria = rs.getInt("id_categoria");
                int idFacilitador =  rs.getInt("id_facilitador");       
                String nombreActividad = rs.getString("nombre_actividad");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFinal = rs.getString("fecha_final");
                String diasSemana = rs.getString("dias_semana");
                String horasDias = rs.getString("horas_dias");
                String descripcion = rs.getString("descripcion");
                String estadoActividad = rs.getString("estado_actividad");
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                actividad = new Actividad(idActividad, idCategoria, idFacilitador,  nombreActividad, fechaInicio, fechaFinal, diasSemana, horasDias, descripcion, estadoActividad, nombreCategoria, nombreFacilitador);

                /* Agregamos el objeto a la lista de actividad */
                Actividades.add(actividad);
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
        
        return Actividades;
    }
    
    /* Insertar datos a la base de datos */
    public int insertar(Actividad actividad){
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
            stmt = conn.prepareStatement("{call SP_agregar_actividad(?,?,?,?,?,?,?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, actividad.getIdCategoria());
            stmt.setInt(2, actividad.getIdFacilitador());
            stmt.setString(3, actividad.getNombreActividad());
            stmt.setString(4, actividad.getFechaInicio());
            stmt.setString(5, actividad.getFechaFinal());
            stmt.setString(6, actividad.getDiasSemana());
            stmt.setString(7, actividad.getHorasDias());
            stmt.setString(8, actividad.getDescripcion());
            stmt.setString(9, actividad.getEstadoActividad());
            
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
    
    /* Traer informacion para llenar los campos de editar */
    public Actividad encontrar(Actividad actividad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call SP_buscar_actividad(?)}");
            stmt.setInt(1, actividad.getIdActividad());
            
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos por medio del id */
                int idActividad = rs.getInt("id_actividad");
                int idCategoria = rs.getInt("id_categoria");
                int idFacilitador =  rs.getInt("id_facilitador");       
                String nombreActividad = rs.getString("nombre_actividad");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFinal = rs.getString("fecha_final");
                String diasSemana = rs.getString("dias_semana");
                String horasDias = rs.getString("horas_dias");
                String descripcion = rs.getString("descripcion");
                String estadoActividad = rs.getString("estado_actividad");
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                actividad = new Actividad(idActividad, idCategoria, idFacilitador,  nombreActividad, fechaInicio, fechaFinal, diasSemana, horasDias, descripcion, estadoActividad);
            }


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return actividad;
    }
        
    /* ** OPCIONAL **, la informacion de los detalles */
    public Actividad detalles(Actividad actividad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call SP_buscar_actividad_detalles(?)}");
            stmt.setInt(1, actividad.getIdActividad());
            
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos por medio del id */
                String nombreCategoria = rs.getString("nombre_categoria");
                String nombreFacilitador = rs.getString("nombre_facilitador");
                int idActividad = rs.getInt("id_actividad");
                int idCategoria = rs.getInt("id_categoria");
                int idFacilitador =  rs.getInt("id_facilitador");       
                String nombreActividad = rs.getString("nombre_actividad");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFinal = rs.getString("fecha_final");
                String diasSemana = rs.getString("dias_semana");
                String horasDias = rs.getString("horas_dias");
                String descripcion = rs.getString("descripcion");
                String estadoActividad = rs.getString("estado_actividad");
                
                /* Creamos un nuevo objeto y asignamos a la variable de actividad */
                actividad = new Actividad(idActividad, idCategoria, idFacilitador,  nombreActividad, fechaInicio, fechaFinal, diasSemana, horasDias, descripcion, estadoActividad, nombreCategoria, nombreFacilitador);
             }


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return actividad;
    }
    
    /* Actualizar, ya la sabemos */
    public int actualizar(Actividad actividad){
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
            stmt = conn.prepareStatement("{call SP_actualizar_actividad(?,?,?,?,?,?,?,?,?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, actividad.getIdActividad());
            stmt.setInt(2, actividad.getIdCategoria());
            stmt.setInt(3, actividad.getIdFacilitador());
            stmt.setString(4, actividad.getNombreActividad());
            stmt.setString(5, actividad.getFechaInicio());
            stmt.setString(6, actividad.getFechaFinal());
            stmt.setString(7, actividad.getDiasSemana());
            stmt.setString(8, actividad.getHorasDias());
            stmt.setString(9, actividad.getDescripcion());
            stmt.setString(10, actividad.getEstadoActividad());
            
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
    
    /* Eliminamos el dato, en realidad inhabilitamos */
    public int eliminar(Actividad actividad) {
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
            stmt = conn.prepareStatement("{call SP_eliminar_actividad(?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, actividad.getIdActividad());
            
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
    
    public int obtenerUltimaActividad() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int idActividad = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("{call SP_obtener_actividad()}");
            
            rs = stmt.executeQuery();
            
            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next())
            {
                /* Recuperamos los datos por medio del id */
                idActividad = rs.getInt("id_actividad");
            }


        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return idActividad;
    }
    
    public int insertarAdministradorActividad(int idAdministrador, int ultimaActividad){
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
            stmt = conn.prepareStatement("{call SP_agregar_administrador_actividad(?,?)}");
            /* Añadimos los parametros que requiere la consulta */
            /* El parametros empieza por el 1 */
            stmt.setInt(1, idAdministrador);
            stmt.setInt(2, ultimaActividad);
            
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
