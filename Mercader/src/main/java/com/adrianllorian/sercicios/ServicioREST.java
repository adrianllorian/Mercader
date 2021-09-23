package com.adrianllorian.sercicios;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.adrianllorian.negocio.Productos;


@Repository
public class ServicioREST {
	public void microFrescos(Productos producto) throws URISyntaxException {
		URI myURL = new URI("http://localhost:9090/frescos/add");
		RequestEntity<Productos> request = new RequestEntity<Productos>(producto,HttpMethod.POST, myURL);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Productos> response;
		restTemplate.exchange(request,Productos.class); 
		System.out.println("Ha llegado al servicio de Frescos");
	}
	public void microLacteos(Productos producto) throws URISyntaxException {
		URI myURL = new URI("http://localhost:9090/lacteos/add"); //Direccion Rest donde voy a enviar el objeto
		RequestEntity<Productos> request = new RequestEntity<Productos>(producto,HttpMethod.POST, myURL); //Preparo un Objeto Coleccion RequestEntity donde va el objeto a enviar el tipo de metodo de envio y la direccion de envio
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Productos> response;
		restTemplate.exchange(request,Productos.class); 
		System.out.println("Ha llegado al servicio de Frescos");
	}
}
