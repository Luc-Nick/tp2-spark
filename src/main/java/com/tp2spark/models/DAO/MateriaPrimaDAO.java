package com.tp2spark.models.DAO;

import com.tp2spark.models.objects.MateriaPrima; //importo el objeto a usar
import com.tp2spark.utils.Sql2oDAO;

import java.util.*;

import org.sql2o.Connection;

public class MateriaPrimaDAO implements IMateriaPrimaDAO {

    /*A tener en cuenta al crear la DB: Los nombres de las columnas de la tabla
     en la base de datos deben coincidir con los nombres de los atributos de la clase 
     exactamente (respetando mayúsculas y minúsculas) o estar en una convención que pueda mapearse fácilmente. 
     De lo contrario se debe solucionar por ejemplo, usando Alias en las consultas SQL para ajustar los nombres. 
     */

    public int insertMP(MateriaPrima materiaPrima) {

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            String insertSQL = "INSERT INTO `materiaprima` (`nombre`, `descripcion`, `stock`, `unidadMedida`) " +  "VALUES (:nombre,:descripcion,:stock,:unidadMedida)";
            int id = con.createQuery(insertSQL, true)
                    .addParameter("nombre", materiaPrima.getNombre())
                    .addParameter("descripcion", materiaPrima.getDescripcion())
                    .addParameter("stock", materiaPrima.getStock())
                    .addParameter("unidadMedida", materiaPrima.getUnidadMedida())
                    .executeUpdate()
                    .getKey(Integer.class);
            return id;
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " +
                    e.getMessage());
            return 0;
        }
    }

    public MateriaPrima getMPById(int id) {

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            String querySQL = "SELECT * FROM `materiaprima` WHERE `id` = :id";
            MateriaPrima resMP = con.createQuery(querySQL)
                    .addParameter("id", id)
                    .executeAndFetchFirst(MateriaPrima.class); // Usar executeAndFetchFirst para obtener el primer registro que encuentre
            return resMP;
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    } //Obtener una materia prima por su ID
    


    public List<MateriaPrima> getAllMP(){
        
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            String querySQL = "SELECT * FROM `materiaprima`";
            // Usar executeAndFetch para obtener la respuesta como una lista y parsearla con la clase
            List<MateriaPrima> materiasPrimas = con.createQuery(querySQL).executeAndFetch(MateriaPrima.class); 
            return materiasPrimas;
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
            return null;
        }
    } //Obtener todos las materias prima


    public int updateMP(){
        int id = 0;

        return id;
    } //Actualizar una materia prima


    public int deleteMP(){
        int id = 0; 

        return id; 
    } //Eliminar una materia prima
}
