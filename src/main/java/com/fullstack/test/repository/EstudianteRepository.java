package com.fullstack.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.test.entity.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {

}
