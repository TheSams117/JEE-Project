package com.fullstack.test.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean(name = "estudiantes")
	public DefaultWsdl11Definition defaultWsdl11DefinitionEstudiantes(XsdSchema estudiantesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("Estudianteport");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.fullstack-test.com/estudiante");
		wsdl11Definition.setSchema(estudiantesSchema);
		return wsdl11Definition;
	}

	@Bean(name = "materias")
	public DefaultWsdl11Definition defaultWsdl11DefinitionMaterias(XsdSchema materiasSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("Materiaport");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.fullstack-test.com/materia");
		wsdl11Definition.setSchema(materiasSchema);
		return wsdl11Definition;
	}

	@Bean(name = "matriculas")
	public DefaultWsdl11Definition defaultWsdl11DefinitionMatriculas(XsdSchema matriculasSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("Matriculaport");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.fullstack-test.com/matricula");
		wsdl11Definition.setSchema(matriculasSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema estudiantesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("estudiantes.xsd"));
	}

	@Bean
	public XsdSchema materiasSchema() {
		return new SimpleXsdSchema(new ClassPathResource("materias.xsd"));
	}

	@Bean
	public XsdSchema matriculasSchema() {
		return new SimpleXsdSchema(new ClassPathResource("matriculas.xsd"));
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}
}
