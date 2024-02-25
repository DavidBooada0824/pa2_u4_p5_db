package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Persona;

public interface IPersonaService {

	public void guardar (Persona persona);
	public void modificar (Persona persona);
	public Persona buscarPorCedula(String cedula);
	public void borrarPorCedula(String cedula);
	public List<Persona> buscarTodos();
	
	
}
