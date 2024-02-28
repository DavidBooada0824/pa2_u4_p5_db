package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Persona;
import com.example.demo.service.IPersonaService;

//http://localhost:8080/personas

@Controller
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	private IPersonaService iPersonaService;

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Persona> lista = this.iPersonaService.buscarTodos();
		modelo.addAttribute("personas", lista);
		return "vistaListaPersonas";
	}

	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model modelo) {
		Persona persona = this.iPersonaService.buscarPorCedula(cedula);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
	}

	@PutMapping("/actualizar/{cedulaPersona}")
	public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona persona) {

		Persona perAux = this.iPersonaService.buscarPorCedula(cedula);
		perAux.setApellido(persona.getApellido());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());
		perAux.setNombre(persona.getNombre());

		this.iPersonaService.modificar(perAux);
		return "redirect:/personas/buscarTodos";
	}

	@DeleteMapping("/borrar/{cedulaPersona}")
	public String borrar(@PathVariable("cedulaPersona") String cedula) {
		this.iPersonaService.borrarPorCedula(cedula);
		return "redirect:/personas/buscarTodos";
	}

	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}

	@GetMapping("/nuevaPersona")
	public String mostrarNuevaPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "vistaNuevaPersona";
	}

}
