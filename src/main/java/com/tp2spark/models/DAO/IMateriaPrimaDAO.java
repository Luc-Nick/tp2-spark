package com.tp2spark.models.DAO;

import java.util.List;

import com.tp2spark.models.objects.MateriaPrima;

public interface IMateriaPrimaDAO {
    List<MateriaPrima> obtenerTodasLasMateriasPrimas();

    public boolean insert(MateriaPrima materiaPrima);

    public MateriaPrima obtener_por_id(int id);
}
