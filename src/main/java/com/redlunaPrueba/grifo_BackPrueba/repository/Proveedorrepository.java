package com.redlunaPrueba.grifo_BackPrueba.repository;

import com.redlunaPrueba.grifo_BackPrueba.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Proveedorrepository extends JpaRepository<Proveedor, Integer> {
}