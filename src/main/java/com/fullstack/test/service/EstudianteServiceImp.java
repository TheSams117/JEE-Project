package com.fullstack.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.repository.EstudianteRepository;

@Service
@Transactional
public class EstudianteServiceImp implements EstudianteService {
	@Autowired
	private EstudianteRepository repo;

	@Override
	public Estudiante addEstudiante(Estudiante estudiante) {
		return repo.save(estudiante);
	}

	@Override
	public void deleteEstudiante(Estudiante estudiante) {
		repo.delete(estudiante);
	}

	@Override
	public void deleteEstudianteById(long estudianteId) {
		repo.deleteById(estudianteId);

	}

	@Override
	public List<Estudiante> getAllEstudiantes() {
		List<Estudiante> estudiantes = new ArrayList<>();
		repo.findAll().forEach(e -> estudiantes.add(e));
		return estudiantes;
	}

	@Override
	public Estudiante getEstudianteById(long estudianteId) {
		Optional<Estudiante> estudiante = repo.findById(estudianteId);
		return (estudiante.isEmpty()) ? null : estudiante.get();
	}

	@Override
	public void updateEstudiante(Estudiante estudiante) {
		repo.save(estudiante);

	}

}
