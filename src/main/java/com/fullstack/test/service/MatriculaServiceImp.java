package com.fullstack.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.entity.Materia;
import com.fullstack.test.entity.Matricula;
import com.fullstack.test.repository.MatriculaRepository;

@Service
@Transactional
public class MatriculaServiceImp implements MatriculaService {

	@Autowired
	private MatriculaRepository repo;

	@Override
	public Matricula addMatricula(Matricula matricula) {
		return repo.save(matricula);
	}

	@Override
	public void deleteMatricula(Matricula matricula) {
		repo.delete(matricula);

	}

	@Override
	public void deleteMatriculaById(long matriculaid) {
		repo.deleteById(matriculaid);

	}

	@Override
	public List<Matricula> getAllMatricula() {
		List<Matricula> matriculas = new ArrayList<>();
		repo.findAll().forEach(e -> matriculas.add(e));
		return matriculas;
	}

	@Override
	public List<Estudiante> getEstudiantesMateria(Long materiaid) {

		return repo.getEstudiantesMateria(materiaid);
	}

	@Override
	public List<Materia> getMateriasEstudiante(Long estudianteid) {
		return repo.getMateriasEstudiante(estudianteid);
	}

	@Override
	public Matricula getMatriculaById(long matriculaId) {
		Optional<Matricula> matricula = repo.findById(matriculaId);
		return (matricula.isEmpty()) ? null : matricula.get();
	}

	@Override
	public void updateMatricula(Matricula matricula) {
		repo.save(matricula);

	}

}
