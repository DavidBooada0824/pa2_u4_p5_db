package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IPersonaRepo;
import com.example.demo.repo.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo iPersonaRepo;
	
	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepo.insertar(persona);
		
	}

	@Override
	public void modificar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepo.actualizar(persona);
		
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaRepo.consultarPorCedula(cedula);
	}

	@Override
	public void borrarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		this.iPersonaRepo.eliminarPorCedula(cedula);		
	}

	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaRepo.consultarTodos();
	}

}
