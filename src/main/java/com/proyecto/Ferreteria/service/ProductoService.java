package com.proyecto.Ferreteria.service;

import java.util.List;

import com.proyecto.Ferreteria.entity.Producto;

public interface ProductoService {
	
	List<Producto> listar();

    Producto listarById(Long id);

    Producto guardar(Producto producto);

    void actualizar(Long id, Producto producto);

    void eliminar(Long id);
}
