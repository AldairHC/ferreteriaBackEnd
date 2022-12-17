package com.proyecto.Ferreteria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Local {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocal;
	
	@Column(length = 50)
	private String Nombre;
	
	@Column(length = 50)
	private String Descripcion;
	

}
