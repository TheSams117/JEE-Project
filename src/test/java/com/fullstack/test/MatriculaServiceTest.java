package com.fullstack.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.entity.Materia;
import com.fullstack.test.entity.Matricula;
import com.fullstack.test.service.EstudianteServiceImp;
import com.fullstack.test.service.MateriaServiceImp;
import com.fullstack.test.service.MatriculaServiceImp;

@SpringBootTest
public class MatriculaServiceTest {

	@Autowired
	private MatriculaServiceImp service;
	@Autowired
	private EstudianteServiceImp serviceEstud;
	@Autowired
	private MateriaServiceImp serviceMater;

	private Matricula matricula;

	private Estudiante estudiante;
	private Estudiante estudiante2;

	private Materia materia;

	@Test
	public void matriculaServiceTest() {

		setupOne();

		// Prueba para guardar matricula
		assertEquals(matricula.getEstudiante().getNombre(),
				service.addMatricula(matricula).getEstudiante().getNombre());

		// Prueba para obtener matricula
		assertEquals(matricula.getId(), service.getMatriculaById(matricula.getId()).getId());

		// Prueba para actualizar matricula
		matricula.setEstudiante(estudiante2);
		service.updateMatricula(matricula);
		assertEquals(service.getMatriculaById(matricula.getId()).getEstudiante().getNombre(), "EstudiantePrueba2");

		// Prueba para eliminar matricula
		service.deleteMatriculaById(matricula.getId());
		assertNull(service.getMatriculaById(matricula.getId()));
		serviceEstud.deleteEstudiante(estudiante);
		serviceEstud.deleteEstudiante(estudiante2);
		serviceMater.deleteMateria(materia);

		// Prueba para obtener lista de todas las matriculas
		assertTrue(service.getAllMatricula().size() >= 6);

		// Prueba para conuslta de materias por estudiante
		assertTrue(service.getMateriasEstudiante((long) 1).size() >= 3);

		// Prueba para conuslta de estudiantes por materia
		assertTrue(service.getEstudiantesMateria((long) 7).size() >= 2);

	}

	public void setupOne() {

		estudiante = new Estudiante();
		estudiante.setNombre("EstudiantePrueba");
		estudiante.setIdentificacion("11123111");
		serviceEstud.addEstudiante(estudiante);

		estudiante2 = new Estudiante();
		estudiante2.setNombre("EstudiantePrueba2");
		estudiante2.setIdentificacion("11123111");
		serviceEstud.addEstudiante(estudiante2);

		materia = new Materia();
		materia.setNombre("MateriaPrueba");
		materia.setSerial("12345");
		serviceMater.addMateria(materia);

		matricula = new Matricula();
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
	}

}
