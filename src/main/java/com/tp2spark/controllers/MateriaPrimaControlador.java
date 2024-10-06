package com.tp2spark.controllers;

import static spark.Spark.get; // Asegúrate de importar el método get de Spark

import java.util.List;

import com.google.gson.Gson;
import com.tp2spark.models.DAO.MateriaPrimaDAO;
import com.tp2spark.models.objects.MateriaPrima;

import spark.Request;
import spark.Response;
import spark.Route;

public class MateriaPrimaControlador {

    private static MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO(); // Crear una instancia del DAO

    // Ruta para obtener todas las materias primas
    public static Route getTodasLasMateriasPrimas = (Request request, Response response) -> {
        response.type("application/json"); // Establecer el tipo de contenido de la respuesta

        try {
            List<MateriaPrima> res = materiaPrimaDAO.selectAll(); // Llamar al método que obtiene todas las materias
                                                                  // primas
            if (res != null && !res.isEmpty()) {
                return new Gson().toJson(res); // Convertir la lista a JSON y devolverla
            } else {
                response.status(404); // Si no hay materias primas, establecer el estado a 404
                return new Gson().toJson("No se encontraron materias primas");
            }
        } catch (Exception e) {
            response.status(500); // Establecer el estado a 500 en caso de error
            return new Gson().toJson("Error controlador: " + e.getMessage()); // Devolver mensaje de error
        }
    };
}
