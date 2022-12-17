package com.proyecto.Ferreteria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.Ferreteria.entity.Proveedor;
import com.proyecto.Ferreteria.excepciones.NotFoundException;
import com.proyecto.Ferreteria.repository.ProveedorRepository;


@RestController
@RequestMapping("proveedor")
@CrossOrigin("*")
public class ProveedorController {
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	 @GetMapping
	  List<Proveedor> listar() {
	    return proveedorRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Proveedor guardar(@RequestBody Proveedor proveedor) {
	    return proveedorRepository.save(proveedor);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Proveedor listarById(@PathVariable Long id) {
	    
	    return proveedorRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Proveedor actualizar(@RequestBody Proveedor newProveedor, @PathVariable Long id) {
	    
	    return proveedorRepository.findById(id)
	      .map(proveedor -> {
	    	  proveedor.setNombre((newProveedor.getNombre()));
	    	  proveedor.setEstado((newProveedor.getEstado()));
	    	  proveedor.setTelefono((newProveedor.getTelefono()));
	        return proveedorRepository.save(proveedor);
	      })
	      .orElseGet(() -> {
	    	  newProveedor.setIdProveedor(id);
	        return proveedorRepository.save(newProveedor);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  proveedorRepository.deleteById(id);
	  }
	
}
