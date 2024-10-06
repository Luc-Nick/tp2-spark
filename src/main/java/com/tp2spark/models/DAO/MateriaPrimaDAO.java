package com.tp2spark.models.DAO;

import com.tp2spark.models.objects.MateriaPrima; //importo el objeto a usar
import com.tp2spark.utils.Sql2oDAO;

import org.sql2o.Connection;
import java.util.List;

public class MateriaPrimaDAO {

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
}