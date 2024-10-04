package com.tp2spark.models.DAO;

import com.tp2spark.models.objects.MateriaPrima; //importo el objeto a usar
import com.tp2spark.utils.Sql2oDAO;

import java.util.*;

import org.sql2o.Connection;

public class MateriaPrimaDAO implements IMateriaPrimaDAO {

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

    public MateriaPrima getMPById(){
        MateriaPrima materiaPrima = new MateriaPrima();
        return materiaPrima;
    } //Obtener una materia prima por su ID


    public List<MateriaPrima> getAllMP(){
        List<MateriaPrima> materiasPrimas = null;

        return materiasPrimas;
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
