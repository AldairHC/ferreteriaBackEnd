package com.proyecto.Ferreteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.Ferreteria.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
