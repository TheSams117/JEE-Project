package com.fullstack.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.test.entity.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {

}
