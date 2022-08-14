package com.jmunoz.springboot.app.productos.controllers;

import com.jmunoz.springboot.app.productos.models.entity.Producto;
import com.jmunoz.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Con esta anotación se convierte a JSON lo que retornan los métodos handler del controlador. Esto es porque
// dentro de @RestController se encuentra la anotación @ResponseBody
@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // Siempre se inicia con / para que sea una ruta absoluta.
    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable Long id) {
        return productoService.findById(id);
    }
}
