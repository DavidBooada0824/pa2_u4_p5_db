package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Persona;

public interface IPersonaRepo {
	
	public void insertar (Persona persona);
	public void actualizar (Persona persona);
	public Persona consultarPorCedula(String cedula);
	public void eliminarPorCedula(String cedula);	
	public List<Persona> consultarTodos();
}

