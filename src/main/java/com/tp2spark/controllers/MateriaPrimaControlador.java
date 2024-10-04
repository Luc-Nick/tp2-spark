package com.tp2spark.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tp2spark.models.DAO.MateriaPrimaDAO;
import com.tp2spark.models.objects.MateriaPrima;

import spark.Request;
import spark.Response;
import spark.Route;

public class MateriaPrimaControlador {

    //(a) Agregar una materia prima (ingrediente)
    public static Route insertMateriaPrima = (Request req, Response res) -> {

        Gson gson = new Gson();

        //trato de parsear el json del body del request directamente a la mp
        //usando el body para hacer el post, permite tener mas seguridad y privacidad al momento de enviar la solicitud
        //al contrario que si usamos queryParams (mejor usarlo para el get o consultas simples)
        try {

            // intancia de MP
            MateriaPrima materiaPrima = gson.fromJson(req.body(), MateriaPrima.class); //si logramos parsear, simplificamos ademas mucho codigo

            MateriaPrimaDAO mpDAO = new MateriaPrimaDAO();
            int id_mp = mpDAO.insertMP(materiaPrima);
            if (id_mp != 0) {
                System.out.println("Materia Prima de prueba insertada en el id: " + id_mp);
                return "Materia Prima de prueba insertada en el id: " + id_mp;
            } else {
                System.out.println("Error");
                return "Algo falló";
            }
        } catch (JsonSyntaxException e) {
            // Manejar errores si el JSON no es válido, usando lib Gson 
            res.status(400);
            return "Error en el formato del JSON: " + e.getMessage();
        }
    };

    //(b) Obtener una materia prima por su ID (ingrediente)
    public static Route  getMateriaPrimaPorId = (Request req, Response res) -> {
        int idMateriaPrima = Integer.parseInt(req.queryParams("id"));
        MateriaPrimaDAO mpDAO = new MateriaPrimaDAO();
        MateriaPrima materiaPrima = mpDAO.getMPById(idMateriaPrima);

        if (materiaPrima != null) {
            //Convertir el objeto a JSON
            Gson gson = new Gson();
            res.type("application/json");
            return gson.toJson(materiaPrima);
        } else {
            res.status(404); // Establecer el código de estado HTTP 404 si no se encuentra el objeto
            return "Materia prima no encontrada";
        }
    };

}
