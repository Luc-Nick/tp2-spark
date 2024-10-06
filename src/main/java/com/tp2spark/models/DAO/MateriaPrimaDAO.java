package com.tp2spark.models.DAO;

import com.tp2spark.models.objects.MateriaPrima; //importo el objeto a usar
import com.tp2spark.utils.Sql2oDAO;

import org.sql2o.Connection;
import java.util.List;

public class MateriaPrimaDAO {
    // -------(c) Obtener todos las propiedades/materias
    // primas/inquilinos/categor´ıas------------------------------------------------
    public List<MateriaPrima> selectAll() {
        // La consulta SQL para obtener todas las materias primas
        String selectAllSQL = "SELECT * FROM MATERIA_PRIMA;";
        List<MateriaPrima> res;

        // Usamos la conexión proporcionada por Sql2oDAO
        try (Connection con = Sql2oDAO.getSql2o().open()) { // abro la conexion que ya tengo en sqloDao
            // Ejecutar la consulta y mapear los resultados a objetos MateriaPrima
            res = con.createQuery(selectAllSQL).executeAndFetch(MateriaPrima.class); // createQuery crea una consulta a
                                                                                     // partir de la cadena que le paso
            // execute: Ejecuta la consulta SQL que has creado previamente con
            // fetch: Es la parte que convierte (o "mapea") los resultados de la consulta
            // SQL en objetos Java.
            // MateriaPrima.class le esta indicando que los objetos se tienen que mapar a
            // obtenos de tipo materia prima
            // el resultado de la consulta la paso a que sean objetos porque es mas facil de
            // manejar
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null; // En caso de error, devuelve null
        }

        return res; // Devolver la lista de materias primas
    }

    // Método para insertar una nueva materia prima
    // -------------------(a) Agregar una propiedad/materia
    // prima/inquilino/categor´ıa-----------------------------------------------------------
    public boolean insert(MateriaPrima materiaPrima) { // dependencia
        // La consulta SQL para insertar una nueva materia prima
        String insertSQL = "INSERT INTO MATERIA_PRIMA (id, stock, nombre, descripcion, unidadMdedida) VALUES (:id, :stock, :nombre, :descripcion, :unidadMedida)";

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(insertSQL) // creo la consulta para insertar
                    .addParameter("id", materiaPrima.getId())
                    .addParameter("stock", materiaPrima.getStock()) // le tengo que pasar el valor de lo que puse ariva
                    .addParameter("nombre", materiaPrima.getNombre())
                    .addParameter("descripcion", materiaPrima.getDescripcion())
                    .addParameter("unidadMedida", materiaPrima.getUnidadMedida())
                    .executeUpdate(); // Ejecuta la consulta de inserción
            return true; // Retorna true si la inserción fue exitosa
        } catch (Exception e) {
            System.err.println("Error al insertar materia prima: " + e.getMessage());
            return false; // Retorna false si hubo un error
            // yo con createQuery creo la consulta
            // con add parameter remplazo los valores que use en la consulta
        }
    }

    // -------------------(b) Obtener una propiedad/materia
    // prima/inquilino/categor´ıa por su
    // ID-------------------------------------------------------------------------
    public MateriaPrima obtener_por_id(int id) {
        // Nota: El uso de comillas simples alrededor de la tabla y las columnas no es
        // correcto. Deben ser comillas dobles o nada.
        String obtenerSql = "SELECT * FROM MATERIA_PRIMA WHERE id = :id"; // lo mira en tiempo de ejecucion

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            // Ejecuta la consulta y obtiene el resultado
            MateriaPrima materiaPrima = con.createQuery(obtenerSql) // crea la consulta
                    .addParameter("id", id) // Aquí pasas el id como parámetro
                    .executeAndFetchFirst(MateriaPrima.class); // ejecuta y devuelve el primer resultado encontrado
            // lo convierte
            return materiaPrima; // Retorna el objeto MateriaPrima encontrado
        } catch (Exception e) {
            e.printStackTrace(); // Maneja cualquier excepción
        }
        // MateriaPrima.class // nose bien que hace
        return null; // Retorna null si no se encuentra ninguna materia prima
    }

    public void actualizar(MateriaPrima materiaprima) {
    }

}
