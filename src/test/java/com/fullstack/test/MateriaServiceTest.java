package com.fullstack.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack.test.entity.Materia;
import com.fullstack.test.service.MateriaServiceImp;

@SpringBootTest
public class MateriaServiceTest {
	@Autowired
	private MateriaServiceImp service;

	private Materia materia;

	@Test
	public void materiaServiceTest() {
		setupOne();

		// Prueba para guardar materia
		assertEquals(materia.getNombre(), service.addMateria(materia).getNombre());

		// Prueba para obtener materia
		assertEquals(materia.getNombre(), service.getMateriaById(materia.getId()).getNombre());

		// Prueba para actualizar materia
		materia.setNombre("MateriaPrueba2");
		service.updateMateria(materia);
		assertEquals(service.getMateriaById(materia.getId()).getNombre(), "MateriaPrueba2");

		// Prueba para eliminar materia
		service.deleteMateriaById(materia.getId());
		assertNull(service.getMateriaById(materia.getId()));

		// Prueba para obtener lista de todas las materias
		assertTrue(service.getAllMaterias().size() >= 4);

	}

	public void setupOne() {
		materia = new Materia();
		materia.setNombre("MateriaPrueba");
		materia.setSerial("12345");
	}

}
