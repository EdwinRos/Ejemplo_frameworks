package com.example.ejemplo_frameworks.controllers.alumno;

import com.example.ejemplo_frameworks.entities.Alumno;
import com.example.ejemplo_frameworks.repositories.AlumnoRepository;
import com.example.ejemplo_frameworks.utils.JsfUtils;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;

@Scope(value = "session") // Define que solo habra una instancia de esta clase por usuario
@Component(value = "alumnoController") //Define esta clase como un componente de Spring y lo llama "alumnoController"
@ELBeanName(value = "alumnoController") //Configura el nombre del Bean en el rewrite Scope
@Join(path = "/alumno/inicio" , to = "/alumno/inicio.jsf") //Confugura que la URL "/alumno" va a responder con la vista "/index.jsf"
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;
    Alumno alumno = new Alumno();

    List<Alumno> alumnoList ;
    
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadAlumnos(){
        alumnoList = alumnoRepository.findAll();
    }
    
    public String saveAlumno(){
        alumnoRepository.save(alumno);
        alumno = new Alumno();
        
        return "/alumno/inicio.xhtml?faces-redirect=true";
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public String editar(){
        alumno = alumnoRepository.findAlumnoById(Integer.valueOf(JsfUtils.getRequest().getParameter("idAlumno")));
        
        return "/alumno/inicio.xhtml?faces-redirect=true";
    }

    public Alumno getAlumno() {
        return alumno;
    }
}
