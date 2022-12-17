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
import com.proyecto.Ferreteria.entity.Local;
import com.proyecto.Ferreteria.excepciones.NotFoundException;
import com.proyecto.Ferreteria.repository.LocalRepository;


@RestController
@RequestMapping("local")
@CrossOrigin("*")
public class LocalController {
	
	@Autowired
	LocalRepository localRepository;
	
	 @GetMapping
	  List<Local> listar() {
	    return localRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Local guardar(@RequestBody Local local) {
	    return localRepository.save(local);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Local listarById(@PathVariable Long id) {
	    
	    return localRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Local actualizar(@RequestBody Local newLocal, @PathVariable Long id) {
	    
	    return localRepository.findById(id)
	      .map(local -> {
	    	  local.setNombre((newLocal.getNombre()));
	    	  local.setDescripcion((newLocal.getDescripcion()));
	        return localRepository.save(local);
	      })
	      .orElseGet(() -> {
	    	  newLocal.setIdLocal(id);
	        return localRepository.save(newLocal);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  localRepository.deleteById(id);
	  }
	
}
