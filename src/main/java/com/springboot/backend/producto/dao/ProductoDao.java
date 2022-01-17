package com.springboot.backend.producto.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.producto.model.Producto;

public interface ProductoDao extends CrudRepository<Producto, Integer>{

}
