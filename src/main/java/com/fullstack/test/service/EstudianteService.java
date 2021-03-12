package com.fullstack.test.service;

import java.util.List;

import com.fullstack.test.entity.Estudiante;

public interface EstudianteService {
	Estudiante addEstudiante(Estudiante estudiante);

	void deleteEstudiante(Estudiante estudiante);

	void deleteEstudianteById(long estudianteId);

	List<Estudiante> getAllEstudiantes();

	Estudiante getEstudianteById(long estudianteId);

	void updateEstudiante(Estudiante estudiante);
}
