package com.adrianllorian.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adrianllorian.negocio.Productos;
import com.adrianllorian.sercicios.MostrarPorPantalla;

@RestController
public class RutasREST {
	
	@Autowired
	 private MostrarPorPantalla mostrar;
	
	@PostMapping("/lacteos/add")
	public void lacteos(@RequestBody Productos producto) {
		mostrar.mostrar(producto);
		
	}

	@PostMapping("/frescos/add")
	public void frescos(@RequestBody Productos producto) {
		mostrar.mostrar(producto);
		
	}
}
