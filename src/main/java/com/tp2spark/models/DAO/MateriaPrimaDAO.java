package com.tp2spark.models.DAO;

import com.tp2spark.models.objects.MateriaPrima; //importo el objeto a usar
import com.tp2spark.utils.Sql2oDAO;

import java.util.*;

import org.sql2o.Connection;

public class MateriaPrimaDAO {

    public int insertMP() {

        String insertSQL = "INSERT INTO `materiaprima` (`nombre`, `descripcion`, `stock`, `unidadMedida`) VALUES ('Azúcar Moreno', 'ninguna', '1000', 'grs')";
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            int id = con.createQuery(insertSQL, true)
                    .executeUpdate()
                    .getKey(Integer.class);
            return id;
        } catch (Exception e) {
            System.err.println("Error al ejecutar la query: " +
                    e.getMessage());
            return 0;
        }
    }
}
