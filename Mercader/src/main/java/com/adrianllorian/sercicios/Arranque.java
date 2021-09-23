package com.adrianllorian.sercicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.adrianllorian.DAO.TiposDAO;
import com.adrianllorian.negocio.Tipos;
@Component
public class Arranque {

	@Autowired
	private TiposDAO tiposDAO;
	
	 @EventListener(ContextRefreshedEvent.class)
	    void contextRefreshedEvent() {
		Tipos tipo1 = new Tipos(1,"Especies");
		Tipos tipo2 = new Tipos(2,"Lacteos");
		Tipos tipo3 = new Tipos(3,"Frescos");
		tiposDAO.save(tipo1);
		tiposDAO.save(tipo2);
		tiposDAO.save(tipo3);
}
}
