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

    public static Route insertar_materiaP = (Request request, Response response) -> {
        response.type("application/json"); // Establecer el tipo de contenido de la respuesta

        try {
            // Convertir el cuerpo de la solicitud JSON a un objeto MateriaPrima
            MateriaPrima materiaPrima = new Gson().fromJson(request.body(), MateriaPrima.class); // utilizo el metodo
                                                                                                 // fromJson para
                                                                                                 // converitr el json
                                                                                                 // que viene a un
                                                                                                 // objeto
            // ago una instancia de json para usar sus metodos
            // Llamar al método insert del DAO
            boolean resultado = materiaPrimaDAO.insert(materiaPrima); // uso la consulta de insertar del dao para poner
                                                                      // la materia prima

            if (resultado) {
                response.status(201); // Establecer el estado a 201 si la inserción fue exitosa
                return new Gson().toJson("Materia prima insertada con éxito");
            } else {
                response.status(500); // Establecer el estado a 500 si hubo un error
                return new Gson().toJson("Error al insertar materia prima");
            }
        } catch (Exception e) {
            response.status(500); // Establecer el estado a 500 en caso de error
            return new Gson().toJson("Error controlador: " + e.getMessage()); // Devolver mensaje de error
        }
    };

}
