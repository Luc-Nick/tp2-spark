package com.tp2spark.models.objects;

public class MateriaPrima {
    private int id;
    private int stock;
    private String nombre;
    private String descripcion;
    private String unidadMedida;

    // Constructor
    public MateriaPrima(int id, int stock, String nombre, String descripcion, String unidadMedida) {
        this.id = id;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public String toString() {
        return "MateriaPrima{" +
                "id=" + id +
                ", stock=" + stock +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                '}';
    }
}