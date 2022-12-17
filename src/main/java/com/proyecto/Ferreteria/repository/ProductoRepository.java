package com.proyecto.Ferreteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.Ferreteria.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
