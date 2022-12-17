package com.proyecto.Ferreteria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.Ferreteria.entity.Producto;
import com.proyecto.Ferreteria.service.ProductoService;


@RestController
@RequestMapping("producto")
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	//The function receives a GET request, processes it and gives back a list of Producto as a response.
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.listar();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of Producto as a response.
    @GetMapping({"/{id}"})
    public ResponseEntity<Producto> listarById(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.listarById(id), HttpStatus.OK);
    }
    @PostMapping
    //The function receives a POST request, processes it, creates a new Producto and saves it to the database, and returns a resource link to the created producto.           @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        Producto producto1 = productoService.guardar(producto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("producto", "/producto/" + producto1.getIdProducto().toString());
        return new ResponseEntity<>(producto1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Producto with the specified Id and returns the updated Producto
    @PutMapping({"/{id}"})
    public ResponseEntity<Producto> actualizar(@PathVariable("id") Long productoId, @RequestBody Producto producto) {
        productoService.actualizar(productoId, producto);
        return new ResponseEntity<>(productoService.listarById(productoId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Producto with the specified Id.
    @DeleteMapping({"/{productoId}"})
    public ResponseEntity<Producto> deleteProducto(@PathVariable("productoId") Long productoId) {
        productoService.eliminar(productoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
