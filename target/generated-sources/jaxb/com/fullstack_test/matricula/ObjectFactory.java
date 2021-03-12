//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.12 a las 03:01:07 AM COT 
//


package com.fullstack_test.matricula;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fullstack_test.matricula package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fullstack_test.matricula
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMateriasEstudianteRequest }
     * 
     */
    public GetMateriasEstudianteRequest createGetMateriasEstudianteRequest() {
        return new GetMateriasEstudianteRequest();
    }

    /**
     * Create an instance of {@link GetMateriasEstudianteResponse }
     * 
     */
    public GetMateriasEstudianteResponse createGetMateriasEstudianteResponse() {
        return new GetMateriasEstudianteResponse();
    }

    /**
     * Create an instance of {@link MateriaData }
     * 
     */
    public MateriaData createMateriaData() {
        return new MateriaData();
    }

    /**
     * Create an instance of {@link GetEstudiantesMateriaRequest }
     * 
     */
    public GetEstudiantesMateriaRequest createGetEstudiantesMateriaRequest() {
        return new GetEstudiantesMateriaRequest();
    }

    /**
     * Create an instance of {@link GetEstudiantesMateriaResponse }
     * 
     */
    public GetEstudiantesMateriaResponse createGetEstudiantesMateriaResponse() {
        return new GetEstudiantesMateriaResponse();
    }

    /**
     * Create an instance of {@link EstudianteData }
     * 
     */
    public EstudianteData createEstudianteData() {
        return new EstudianteData();
    }

}
