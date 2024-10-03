package com.tp2spark;

import org.sql2o.Sql2o;

import com.tp2spark.controllers.MateriaPrimaControlador;
import com.tp2spark.utils.Sql2oDAO;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Grupo 3!");
        // DESCOMENTAR ESTO ANTES QUE HACER OTRA COSA Y PROBAR LA CONEXION A LA DB
        /* try {
            Sql2o sql2o = Sql2oDAO.getSql2o();
            System.out.println("Conexin exitosa a la base de datos");
        } catch (Exception e) {
            System.err.println("No se pudo conectar a la base de datos: " +
                    e.getMessage());
        } */
        post("/insertarMP",MateriaPrimaControlador.insertMateriaPrima);
    }
}