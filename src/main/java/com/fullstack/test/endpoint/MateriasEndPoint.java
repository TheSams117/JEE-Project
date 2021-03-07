package com.fullstack.test.endpoint;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fullstack.test.entity.Materia;
import com.fullstack.test.service.MateriaServiceImp;
import com.fullstack_test.materia.AddMateriaRequest;
import com.fullstack_test.materia.AddMateriaResponse;
import com.fullstack_test.materia.DeleteMateriaRequest;
import com.fullstack_test.materia.DeleteMateriaResponse;
import com.fullstack_test.materia.GetAllMateriasRequest;
import com.fullstack_test.materia.GetAllMateriasResponse;
import com.fullstack_test.materia.GetMateriaByIdRequest;
import com.fullstack_test.materia.GetMateriaByIdResponse;
import com.fullstack_test.materia.MateriaData;
import com.fullstack_test.materia.ServiceStatus;
import com.fullstack_test.materia.UpdateMateriaRequest;
import com.fullstack_test.materia.UpdateMateriaResponse;

@Endpoint
public class MateriasEndPoint {
	private static final String NAMESPACE_URI = "http://www.fullstack-test.com/materia";

	@Autowired
	private MateriaServiceImp service;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMateriaRequest")
	@ResponsePayload
	public AddMateriaResponse addMateria(@RequestPayload AddMateriaRequest request) {
		AddMateriaResponse response = new AddMateriaResponse();

		ServiceStatus serviceStatus = new ServiceStatus();

		Materia newMateria = new Materia();
		newMateria.setNombre(request.getNombre());
		newMateria.setSerial(request.getSerial());
		service.addMateria(newMateria);

		MateriaData materiaData = new MateriaData();
		BeanUtils.copyProperties(newMateria, materiaData);

		response.setMateria(materiaData);

		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Materia " + request.getNombre() + " added");
		response.setServiceStatus(serviceStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteMateriaRequest")
	@ResponsePayload
	public DeleteMateriaResponse deleteMateria(@RequestPayload DeleteMateriaRequest request) {
		DeleteMateriaResponse response = new DeleteMateriaResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		service.deleteMateriaById(request.getId());
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Materia " + request.getId() + " deleted");
		response.setServiceStatus(serviceStatus);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMateriasRequest")
	@ResponsePayload
	public GetAllMateriasResponse getAllEstudiante(@RequestPayload GetAllMateriasRequest request) {
		GetAllMateriasResponse response = new GetAllMateriasResponse();
		List<MateriaData> materiaData = response.getMateria();
		List<Materia> materias = service.getAllMaterias();

		for (Materia materia : materias) {
			MateriaData currentMateria = new MateriaData();
			BeanUtils.copyProperties(materia, currentMateria);
			materiaData.add(currentMateria);

		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMateriaByIdRequest")
	@ResponsePayload
	public GetMateriaByIdResponse getEstudiante(@RequestPayload GetMateriaByIdRequest request) {
		GetMateriaByIdResponse response = new GetMateriaByIdResponse();
		MateriaData materia = new MateriaData();
		BeanUtils.copyProperties(service.getMateriaById(request.getMateriaId()), materia);
		response.setMateria(materia);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMateriaRequest")
	@ResponsePayload
	public UpdateMateriaResponse updateEstudiante(@RequestPayload UpdateMateriaRequest request) {
		UpdateMateriaResponse response = new UpdateMateriaResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Materia materia = service.getMateriaById(request.getId());
		materia.setNombre(request.getNombre());
		materia.setSerial(request.getSerial());

		service.updateMateria(materia);

		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Materia " + request.getNombre() + " updated");
		response.setServiceStatus(serviceStatus);

		return response;
	}

}
