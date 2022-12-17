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
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	
	@Column(length = 50)
	private String Descripcion;
	
	@Column(length = 50)
	private String Fecha;
	
	@Column(length = 50)
	private String Cantidad;
	
	@ManyToOne
    @JoinColumn(name = "idProducto")
	private Producto producto;
	

}
