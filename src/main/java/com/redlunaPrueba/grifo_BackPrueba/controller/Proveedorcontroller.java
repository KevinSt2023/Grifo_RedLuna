package com.redlunaPrueba.grifo_BackPrueba.controller;

import com.redlunaPrueba.grifo_BackPrueba.model.Proveedor;
import com.redlunaPrueba.grifo_BackPrueba.repository.Proveedorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class Proveedorcontroller {

    @Autowired
    private Proveedorrepository proveedorRepository;

    // Obtener todos los proveedores
    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // Crear un nuevo proveedor
    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Actualizar un proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);
        if (proveedorExistente.isPresent()) {
            proveedor.setIdProveedor(id);  // Aquí usamos setId_proveedor ya que el campo es Integer
            Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
            return ResponseEntity.ok(proveedorActualizado);
        } else {
            return ResponseEntity.notFound().build();  // Si no existe, devolvemos 404
        }
    }

    // Eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id) {
        Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);
        if (proveedorExistente.isPresent()) {
            proveedorRepository.deleteById(id);  // Eliminar el proveedor
            return ResponseEntity.noContent().build();  // Devolvemos 204 si se eliminó correctamente
        } else {
            return ResponseEntity.notFound().build();  // Si no existe, devolvemos 404
        }
    }
}


