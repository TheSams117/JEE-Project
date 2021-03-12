package com.fullstack.test.endpoint;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fullstack.test.entity.Estudiante;
import com.fullstack.test.service.EstudianteServiceImp;
import com.fullstack_test.estudiante.AddEstudianteRequest;
import com.fullstack_test.estudiante.AddEstudianteResponse;
import com.fullstack_test.estudiante.DeleteEstudianteRequest;
import com.fullstack_test.estudiante.DeleteEstudianteResponse;
import com.fullstack_test.estudiante.EstudianteData;
import com.fullstack_test.estudiante.GetAllEstudiantesRequest;
import com.fullstack_test.estudiante.GetAllEstudiantesResponse;
import com.fullstack_test.estudiante.GetEstudianteByIdRequest;
import com.fullstack_test.estudiante.GetEstudianteByIdResponse;
import com.fullstack_test.estudiante.ServiceStatus;
import com.fullstack_test.estudiante.UpdateEstudianteRequest;
import com.fullstack_test.estudiante.UpdateEstudianteResponse;

@Endpoint
public class EstudiantesEndPoint {
	private static final String NAMESPACE_URI = "http://www.fullstack-test.com/estudiante";

	@Autowired
	private EstudianteServiceImp service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEstudianteRequest")
	@ResponsePayload
	public AddEstudianteResponse addEstudiante(@RequestPayload AddEstudianteRequest request) {
		AddEstudianteResponse response = new AddEstudianteResponse();

		ServiceStatus serviceStatus = new ServiceStatus();

		Estudiante newEstudiante = new Estudiante();
		newEstudiante.setNombre(request.getNombre());
		newEstudiante.setIdentificacion(request.getIdentificacion());
		service.addEstudiante(newEstudiante);

		EstudianteData estudianteData = new EstudianteData();
		BeanUtils.copyProperties(newEstudiante, estudianteData);

		response.setEstudiante(estudianteData);

		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Estudiante " + request.getNombre() + " added");
		response.setServiceStatus(serviceStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEstudianteRequest")
	@ResponsePayload
	public DeleteEstudianteResponse deleteEstudiante(@RequestPayload DeleteEstudianteRequest request) {
		DeleteEstudianteResponse response = new DeleteEstudianteResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		service.deleteEstudianteById(request.getId());
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Estudiante " + request.getId() + " deleted");
		response.setServiceStatus(serviceStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEstudiantesRequest")
	@ResponsePayload
	public GetAllEstudiantesResponse getAllEstudiante(@RequestPayload GetAllEstudiantesRequest request) {
		GetAllEstudiantesResponse response = new GetAllEstudiantesResponse();
		List<EstudianteData> estudiantesData = response.getEstudiante();
		List<Estudiante> estudiantes = service.getAllEstudiantes();

		for (Estudiante estudiante : estudiantes) {
			EstudianteData currentEstudiante = new EstudianteData();
			BeanUtils.copyProperties(estudiante, currentEstudiante);
			estudiantesData.add(currentEstudiante);

		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstudianteByIdRequest")
	@ResponsePayload
	public GetEstudianteByIdResponse getEstudiante(@RequestPayload GetEstudianteByIdRequest request) {
		GetEstudianteByIdResponse response = new GetEstudianteByIdResponse();
		EstudianteData estudiante = new EstudianteData();
		BeanUtils.copyProperties(service.getEstudianteById(request.getEstudianteId()), estudiante);
		response.setEstudiante(estudiante);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEstudianteRequest")
	@ResponsePayload
	public UpdateEstudianteResponse updateEstudiante(@RequestPayload UpdateEstudianteRequest request) {
		UpdateEstudianteResponse response = new UpdateEstudianteResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Estudiante estudiante = service.getEstudianteById(request.getId());
		estudiante.setNombre(request.getNombre());
		estudiante.setIdentificacion(request.getIdentificacion());

		service.updateEstudiante(estudiante);

		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Estudiante " + request.getNombre() + " updated");
		response.setServiceStatus(serviceStatus);

		return response;
	}

}
