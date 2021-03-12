package com.fullstack.test.endpoint;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.entity.Materia;
import com.fullstack.test.service.MatriculaServiceImp;
import com.fullstack_test.matricula.EstudianteData;
import com.fullstack_test.matricula.GetEstudiantesMateriaRequest;
import com.fullstack_test.matricula.GetEstudiantesMateriaResponse;
import com.fullstack_test.matricula.GetMateriasEstudianteRequest;
import com.fullstack_test.matricula.GetMateriasEstudianteResponse;
import com.fullstack_test.matricula.MateriaData;

@Endpoint
public class MatriculasEndPoint {
	private static final String NAMESPACE_URI = "http://www.fullstack-test.com/matricula";

	@Autowired
	private MatriculaServiceImp service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstudiantesMateriaRequest")
	@ResponsePayload
	public GetEstudiantesMateriaResponse getEstudiantesMateria(@RequestPayload GetEstudiantesMateriaRequest request) {
		GetEstudiantesMateriaResponse response = new GetEstudiantesMateriaResponse();
		List<EstudianteData> estudiantesData = response.getEstudiante();
		List<Estudiante> estudiantes = service.getEstudiantesMateria(request.getMateriaId());

		for (Estudiante estudiante : estudiantes) {
			EstudianteData currentEstudiante = new EstudianteData();
			BeanUtils.copyProperties(estudiante, currentEstudiante);
			estudiantesData.add(currentEstudiante);

		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMateriasEstudianteRequest")
	@ResponsePayload
	public GetMateriasEstudianteResponse getMateriasEstudiante(@RequestPayload GetMateriasEstudianteRequest request) {
		GetMateriasEstudianteResponse response = new GetMateriasEstudianteResponse();
		List<MateriaData> materiasData = response.getMateria();
		List<Materia> materias = service.getMateriasEstudiante(request.getEstudianteId());

		for (Materia materia : materias) {
			MateriaData currentMateria = new MateriaData();
			BeanUtils.copyProperties(materia, currentMateria);
			materiasData.add(currentMateria);

		}

		return response;
	}

}
