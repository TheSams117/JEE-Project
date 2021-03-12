package com.fullstack.test.service;

import java.util.List;

import com.fullstack.test.entity.Materia;

public interface MateriaService {
	Materia addMateria(Materia materia);

	void deleteMateria(Materia materia);

	void deleteMateriaById(long materiaid);

	List<Materia> getAllMaterias();

	Materia getMateriaById(long materiaId);

	void updateMateria(Materia materia);
}
