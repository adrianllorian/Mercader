package com.adrianllorian.sercicios;

import org.springframework.stereotype.Service;

import com.adrianllorian.negocio.Productos;

@Service
public class MostrarPorPantalla {

	public void mostrar(Productos producto) {
		System.out.println(producto);
	}
}
