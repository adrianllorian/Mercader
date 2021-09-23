package com.adrianllorian.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianllorian.negocio.Productos;

@Repository
public interface ProductosDAO extends CrudRepository <Productos,Integer> {

}
