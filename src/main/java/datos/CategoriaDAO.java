package datos;

import dominios.Categoria;
import java.sql.*;
import java.util.*;

public class CategoriaDAO {

    /* Metodo para listar */
    public List<Categoria> Listar() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;

        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Categoria> categorias = new ArrayList<>();

        try {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_categorias()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();

            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");
                String descripcion = rs.getString("descripcion");
                String estadoCategoria = rs.getString("estado_categoria");

                /* Creamos un nuevo objeto y asignamos a la variable de categorias */
                categoria = new Categoria(idCategoria, nombreCategoria, descripcion, estadoCategoria);

                /* Agregamos el objeto a la lista de categorias */
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return categorias;
    }

    public List<Categoria> listarCompleto() {
        /* Importamos todo lo que vamos a utilizar */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;

        /* Definimos una lista que almacenara todos los datos */
        /* Y lo inicializamos */
        List<Categoria> categorias = new ArrayList<>();

        try {
            /* Obetenmos la conexion */
            conn = Conexion.getConnection();

            /* Inicializamos la consulta */
            stmt = conn.prepareCall("{call SP_listar_categorias_completo()}");

            /* Ejecutamos el Query y lo asignamos a una variable */
            rs = stmt.executeQuery();

            /* Iteramos los registros que recuperemos */
            /* Usamos el .next para pocisionarnos en el primer registro que itera */
            /* automaticamente mientras encuentra aregistros */
            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");
                String descripcion = rs.getString("descripcion");
                String estadoCategoria = rs.getString("estado_categoria");

                /* Creamos un nuevo objeto y asignamos a la variable de categorias */
                categoria = new Categoria(idCategoria, nombreCategoria, descripcion, estadoCategoria);

                /* Agregamos el objeto a la lista de categorias */
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return categorias;
    }

    // agregar cateogoria
    public int insertar(Categoria categoria) {
        Connection cx = null;
        PreparedStatement stmt = null;
        int verificar = 0;
        try {
            cx = Conexion.getConnection();
            stmt = cx.prepareStatement("{call SP_agregar_categoria(?, ?, ?)}");
            stmt.setString(1, categoria.getNombreCategoria());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setString(3, categoria.getEstadoCategoria());

            verificar = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            /* Se cierran en el orden inverso que se abrieron */
            Conexion.close(stmt);
            Conexion.close(cx);
        }

        return verificar;
    }

    //buscar user
    public Categoria encontrar(Categoria categoria) {
        Connection cx = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            cx = Conexion.getConnection();
            stmt = cx.prepareStatement("{call SP_buscar_categoria(?)}");
            stmt.setInt(1, categoria.getIdCategoria());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");
                String descripcion = rs.getString("descripcion");
                String estadoActividad = rs.getString("estado_categoria");

                categoria = new Categoria(idCategoria, nombreCategoria, descripcion, estadoActividad);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(cx);
        }

        return categoria;
    }

    //actualizar user
    public int actualizar(Categoria categoria) {
        Connection cx = null;
        PreparedStatement stmt = null;
        int verificar = 0;

        try {
            cx = Conexion.getConnection();
            stmt = cx.prepareStatement("{call SP_actualizar_categoria(?, ?, ?, ?)}");
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getNombreCategoria());
            stmt.setString(3, categoria.getDescripcion());
            stmt.setString(4, categoria.getEstadoCategoria());
            
            verificar = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(cx);
        }

        return verificar;
    }
    
    public int eliminar(Categoria categoria){
         Connection cx = null;
        PreparedStatement stmt = null;
        int verificar = 0;
        try {
            cx = Conexion.getConnection();
            stmt = cx.prepareStatement("{call SP_eliminar_categoria(?)}");
            stmt.setInt(1, categoria.getIdCategoria());            
            
            verificar = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(cx);
        }
        return verificar;
    }

}
