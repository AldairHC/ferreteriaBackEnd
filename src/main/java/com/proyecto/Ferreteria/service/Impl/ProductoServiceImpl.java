package com.proyecto.Ferreteria.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.Ferreteria.entity.Producto;
import com.proyecto.Ferreteria.repository.ProductoRepository;
import com.proyecto.Ferreteria.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		   List<Producto> productos = new ArrayList<>();
	        productoRepository.findAll().forEach(productos::add);
	        return productos;
	}

	@Override
	public Producto listarById(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	@Override
	public Producto guardar(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public void actualizar(Long id, Producto producto) {
		 Producto productos = productoRepository.findById(id).get();
	        System.out.println(productos.toString());
	        productos.setNombre(producto.getNombre());
	        productos.setDescripcion(producto.getDescripcion());
	        productos.setPrecio(producto.getPrecio());
	        productos.setCantidad(producto.getCantidad());
	        productos.setMarca(producto.getMarca());
	        productos.setCategoria(producto.getCategoria());
	        productoRepository.save(productos);	
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
		
	}

}
