package com.fullstack.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.service.EstudianteServiceImp;

@SpringBootTest
public class EstudianteServiceTest {

	@Autowired
	private EstudianteServiceImp service;

	private Estudiante estudiante;

	@Test
	public void estudianteServiceTest() {
		setupOne();

		// Prueba para guardar estudiante
		assertEquals(estudiante.getNombre(), service.addEstudiante(estudiante).getNombre());

		// Prueba para obtener estudiante
		assertEquals(estudiante.getNombre(), service.getEstudianteById(estudiante.getId()).getNombre());

		// Prueba para actualizar estudiante
		estudiante.setNombre("EstudiantePrueba2");
		service.updateEstudiante(estudiante);
		assertEquals(service.getEstudianteById(estudiante.getId()).getNombre(), "EstudiantePrueba2");

		// Prueba para eliminar estuidante
		service.deleteEstudianteById(estudiante.getId());
		assertNull(service.getEstudianteById(estudiante.getId()));

		// Prueba para obtener lista de todos los estuidantes
		assertTrue(service.getAllEstudiantes().size() >= 5);

	}

	public void setupOne() {
		estudiante = new Estudiante();
		estudiante.setNombre("EstudiantePrueba");
		estudiante.setIdentificacion("11111");
	}

}
