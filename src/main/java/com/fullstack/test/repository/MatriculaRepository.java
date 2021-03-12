package com.fullstack.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.entity.Materia;
import com.fullstack.test.entity.Matricula;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long> {
	@Query(value = "SELECT m.estudiante FROM Matricula m WHERE materia_id = ?1")
	List<Estudiante> getEstudiantesMateria(long materiaid);

	@Query(value = "SELECT m.materia FROM Matricula m WHERE estudiante_id = ?1")
	List<Materia> getMateriasEstudiante(long estudianteid);
}
