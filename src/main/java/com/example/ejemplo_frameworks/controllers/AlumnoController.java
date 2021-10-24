package com.example.ejemplo_frameworks.controllers;

import com.example.ejemplo_frameworks.repositories.AlumnoRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session") // Define que solo habra una instancia de esta clase por usuario
@Component(value = "alumnoController") //Define esta clase como un componente de Spring y lo llama "alumnoController"
@ELBeanName(value = "alumnoController") //Configura el nombre del Bean en el rewrite Scope
@Join(path = "/alumno" , to = "/index.jsf") //Confugura que la URL "/alumno" va a responder con la vista "/index.jsf"
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;


}
