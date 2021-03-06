package com.fullstack.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fullstack.test.service.EstudianteServiceImp;
import com.fullstack.test.service.MateriaServiceImp;
import com.fullstack.test.service.MatriculaServiceImp;

@SpringBootApplication
public class WsSoapApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(WsSoapApplication.class, args);
		EstudianteServiceImp estudianteService = app.getBean(EstudianteServiceImp.class);
		MateriaServiceImp materiaService = app.getBean(MateriaServiceImp.class);
		MatriculaServiceImp matriculaService = app.getBean(MatriculaServiceImp.class);

//		Estudiante estudiante = new Estudiante();
//		estudiante.setNombre("Sergio");
//		estudiante.setIdentificacion("1107524154");
//		estudianteService.addEstudiante(estudiante);

//		Materia materia = new Materia();
//		materia.setNombre("Matemáticas");
//		materia.setSerial("2213");
//		materiaService.addMateria(materia);
//
//		Matricula matricula = new Matricula();
//		matricula.setEstudiante(estudianteService.getEstudianteById(1));
//		matricula.setMateria(materiaService.getMateriaById(6));
//		matriculaService.addMatricula(matricula);
//
//		Matricula matricula2 = new Matricula();
//		matricula2.setEstudiante(estudianteService.getEstudianteById(1));
//		matricula2.setMateria(materiaService.getMateriaById(8));
//		matriculaService.addMatricula(matricula2);

	}

}
