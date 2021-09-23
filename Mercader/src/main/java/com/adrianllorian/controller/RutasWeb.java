package com.adrianllorian.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adrianllorian.DAO.ProductosDAO;
import com.adrianllorian.DAO.TiposDAO;
import com.adrianllorian.negocio.Productos;
import com.adrianllorian.negocio.Tipos;
import com.adrianllorian.sercicios.MostrarPorPantalla;
import com.adrianllorian.sercicios.ServicioREST;


@Controller
public class RutasWeb {
	
	@Autowired
	private ProductosDAO productosDAO;
	
	@Autowired
	private TiposDAO tiposDAO;
	
	@Autowired
	private MostrarPorPantalla mostrar;
	
	@Autowired
	private ServicioREST servicioREST;
	
	
	@GetMapping("/")
	public ModelAndView formulario() {
		ModelAndView model = new ModelAndView();
		List<Tipos> tipos= (List<Tipos>) tiposDAO.findAll();
		model.addObject("listaTipos", tipos);
		model.addObject("productos", new Productos());
		model.setViewName("index");
		return model;
	}
	
	@PostMapping("/post")
	public String post(@Valid @ModelAttribute("productos") Productos productos, BindingResult bindingResult) {

		System.out.println("entra al post");
		String salida = "redirect:/";
		
		if(bindingResult.hasErrors()) {
			//Si no es valido vuelve a mostra el formulario
		salida = "/";
		
		
		}
		else {
			Tipos tipo = productos.getTipo();
		if(tipo.getTipo().equals("Especies")) {
			System.out.println("Entra aqui");
			productosDAO.save(productos);
			salida= "redirect:/";
		}
		else if(tipo.getTipo().equals("Frescos")) {
			
			try {
				servicioREST.microFrescos(productos);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		else if(tipo.getTipo().equals("Lacteos")) {
			
			try {
				servicioREST.microLacteos(productos);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
		return salida;
	}

	
}
