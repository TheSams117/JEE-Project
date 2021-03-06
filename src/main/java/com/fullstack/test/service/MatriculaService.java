package com.fullstack.test.service;

import java.util.List;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.entity.Materia;
import com.fullstack.test.entity.Matricula;

public interface MatriculaService {
	Matricula addMatricula(Matricula matricula);

	void deleteMatricula(Matricula matricula);

	void deleteMatriculaById(long matriculaid);

	List<Matricula> getAllMatricula();

	List<Estudiante> getEstudiantesMateria(Long materiaid);

	List<Materia> getMateriasEstudiante(Long estudianteid);

	Matricula getMatriculaById(long matriculaId);

	void updateMatricula(Matricula matricula);
}
