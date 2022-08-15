package com.jmunoz.springboot.app.productos.controllers;

import com.jmunoz.springboot.app.productos.models.entity.Producto;
import com.jmunoz.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

// Con esta anotación se convierte a JSON lo que retornan los métodos handler del controlador. Esto es porque
// dentro de @RestController se encuentra la anotación @ResponseBody
@RestController
public class ProductoController {

    // Usando @Value para obtener el puerto de forma más sencilla
    // Inyecta valores que tenemos configurados en los properties
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService productoService;

    // Siempre se inicia con / para que sea una ruta absoluta.
    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(p -> {
            p.setPort(port);
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        producto.setPort(port);
        return producto;
    }
}
