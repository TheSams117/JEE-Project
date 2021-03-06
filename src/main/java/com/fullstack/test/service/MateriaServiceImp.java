package com.fullstack.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.test.entity.Materia;
import com.fullstack.test.repository.MateriaRepository;

@Service
@Transactional
public class MateriaServiceImp implements MateriaService {
	@Autowired
	private MateriaRepository repo;

	@Override
	public Materia addMateria(Materia materia) {
		return repo.save(materia);
	}

	@Override
	public void deleteMateria(Materia materia) {
		repo.delete(materia);

	}

	@Override
	public void deleteMateriaById(long materiaid) {
		repo.deleteById(materiaid);

	}

	@Override
	public List<Materia> getAllMaterias() {
		List<Materia> materias = new ArrayList<>();
		repo.findAll().forEach(e -> materias.add(e));
		return materias;
	}

	@Override
	public Materia getMateriaById(long materiaId) {
		Optional<Materia> materia = repo.findById(materiaId);
		return (materia.isEmpty()) ? null : materia.get();
	}

	@Override
	public void updateMateria(Materia materia) {
		repo.save(materia);

	}

}
