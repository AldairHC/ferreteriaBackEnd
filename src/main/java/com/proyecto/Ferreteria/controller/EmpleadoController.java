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
import com.proyecto.Ferreteria.entity.Empleado;
import com.proyecto.Ferreteria.excepciones.NotFoundException;
import com.proyecto.Ferreteria.repository.EmpleadoRepository;


@RestController
@RequestMapping("empleado")
@CrossOrigin("*")
public class EmpleadoController {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	 @GetMapping
	  List<Empleado> listar() {
	    return empleadoRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Empleado guardar(@RequestBody Empleado empleado) {
	    return empleadoRepository.save(empleado);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Empleado listarById(@PathVariable Long id) {
	    
	    return empleadoRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Empleado actualizar(@RequestBody Empleado newEmpleado, @PathVariable Long id) {
	    
	    return empleadoRepository.findById(id)
	      .map(empleado -> {
	    	  empleado.setNombres((newEmpleado.getNombres()));
	    	  empleado.setApellidos((newEmpleado.getApellidos()));
	    	  empleado.setDireccion((newEmpleado.getDireccion()));
	    	  empleado.setTelefono((newEmpleado.getTelefono()));
	    	  empleado.setTipo_documento((newEmpleado.getTipo_documento()));
	    	  empleado.setNumero_documento((newEmpleado.getNumero_documento()));
	    	  empleado.setCargo((newEmpleado.getCargo()));
	    	  empleado.setLocal((newEmpleado.getLocal()));
	        return empleadoRepository.save(empleado);
	      })
	      .orElseGet(() -> {
	    	  newEmpleado.setIdEmpleado(id);
	        return empleadoRepository.save(newEmpleado);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  empleadoRepository.deleteById(id);
	  }
	
	
}
