package com.tp2spark.controllers;

import com.tp2spark.models.DAO.MateriaPrimaDAO;

import spark.Request;
import spark.Response;
import spark.Route;

public class MateriaPrimaControlador {
    public static Route insertMateriaPrima = (Request req, Response res) -> {
        MateriaPrimaDAO mpDAO = new MateriaPrimaDAO();
        int id_mp = mpDAO.insertMP();
        if (id_mp != 0) {
            return "Materia Prima de prueba insertada en el id: " + id_mp;
        }
        else{
            return "Algo falló";
        }
    };
}
