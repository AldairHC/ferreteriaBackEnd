package com.proyecto.Ferreteria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	
	@Column(length = 30)
	private String nombres;
	
	@Column(length = 30)
	private String apellidos;
	
	@Column(length = 50)
	private String direccion;
	
	@Column(length = 15)
	private String telefono;
	
	@Column(length = 30)
	private String tipo_documento;
	
	@Column(length = 20)
	private String numero_documento;
	
	@Column(length = 30)
	private String cargo;
	
	@ManyToOne
    @JoinColumn(name = "idLocal")
	private Local local;
}
