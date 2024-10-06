package com.tp2spark.utils;

import org.sql2o.Sql2o;

public class Sql2oDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/materiaprima";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Singleton Pattern
    protected static Sql2o sql2o;

    public static Sql2o getSql2o() {
        if (sql2o == null) {
            sql2o = new Sql2o(URL, USER, PASSWORD);
        }
        return sql2o;
    }
}

// en lugar de tener todo el codigo de acceso a la bd por todo el codigo yso el
// dao