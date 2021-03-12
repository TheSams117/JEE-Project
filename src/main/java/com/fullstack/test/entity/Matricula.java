package com.fullstack.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "materia_id")
	private Materia materia;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public long getId() {
		return id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}
