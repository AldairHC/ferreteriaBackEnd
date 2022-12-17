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
import com.proyecto.Ferreteria.entity.Pedido;
import com.proyecto.Ferreteria.excepciones.NotFoundException;
import com.proyecto.Ferreteria.repository.PedidoRepository;


@RestController
@RequestMapping("pedido")
@CrossOrigin("*")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	 @GetMapping
	  List<Pedido> listar() {
	    return pedidoRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  Pedido guardar(@RequestBody Pedido pedido) {
	    return pedidoRepository.save(pedido);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  Pedido listarById(@PathVariable Long id) {
	    
	    return pedidoRepository.findById(id)
	      .orElseThrow(() -> new NotFoundException(id));
	  }

	  @PutMapping("/{id}")
	  Pedido actualizar(@RequestBody Pedido newPedido, @PathVariable Long id) {
	    
	    return pedidoRepository.findById(id)
	      .map(pedido -> {
	    	  pedido.setDescripcion((newPedido.getDescripcion()));
	    	  pedido.setFecha((newPedido.getFecha()));
	    	  pedido.setCantidad((newPedido.getCantidad()));
	    	  pedido.setProducto((newPedido.getProducto()));
	        return pedidoRepository.save(pedido);
	      })
	      .orElseGet(() -> {
	    	  newPedido.setIdPedido(id);
	        return pedidoRepository.save(newPedido);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void eliminar(@PathVariable Long id) {
		  pedidoRepository.deleteById(id);
	  }
	
}
