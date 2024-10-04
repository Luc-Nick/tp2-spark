package com.tp2spark.models.DAO;

import java.util.List;

import com.tp2spark.models.objects.MateriaPrima;

public interface IMateriaPrimaDAO {
    public int insertMP(MateriaPrima materiaPrima); //agregar una Materia Prima
    public MateriaPrima getMPById(); //Obtener una materia prima por su ID
    public List<MateriaPrima> getAllMP(); //Obtener todos las materias prima
    public int updateMP(); //Actualizar una materia prima
    public int deleteMP(); //Eliminar una materia prima
}
