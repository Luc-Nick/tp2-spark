package com.tp2spark.models.objects;

import lombok.Data;

@Data
public class MateriaPrima {
    int id; 
    int stock; 
    String nombre;
    String descripcion; 
    String unidadMedida;
}
