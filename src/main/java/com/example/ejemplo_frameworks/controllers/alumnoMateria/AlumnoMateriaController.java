package com.example.ejemplo_frameworks.controllers.alumnoMateria;

import com.example.ejemplo_frameworks.entities.Alumno;
import com.example.ejemplo_frameworks.entities.AlumnoMateria;
import com.example.ejemplo_frameworks.entities.Materia;
import com.example.ejemplo_frameworks.repositories.AlumnoMateriaRepository;
import com.example.ejemplo_frameworks.repositories.AlumnoRepository;
import com.example.ejemplo_frameworks.repositories.MateriaRepository;
import com.example.ejemplo_frameworks.utils.JsfUtils;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Scope(value = "session")
@Component(value = "alumnoMateriaController")
@ELBeanName(value = "alumnoMateriaController")
@Join(path = "/alumnoMateria/inicio", to = "/alumnoMateria/alumno_materia.jsf")
public class AlumnoMateriaController {

    @Autowired
    AlumnoMateriaRepository alumnoMateriaRepository;
    AlumnoMateria alumnoMateria = new AlumnoMateria();

    List<AlumnoMateria> alumnoMateriaList;

    @Autowired
    AlumnoRepository alumnoRepository;
    Alumno alumno = new Alumno();


    @Autowired
    MateriaRepository materiaRepository;
    Materia materia = new Materia();
    List<Materia> materiasNoCursadas;


    public String saveAlumnoMateria(){
        alumnoMateria.setAlumnoid(alumno);
        alumnoMateria.setMateriaid(materia);
        alumnoMateriaRepository.save(alumnoMateria);
        return "/alumnoMateria/alumno_materia.xhtml?faces-redirect=true&idalumnoMateria=" + alumno.getId() + "";
    }


    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        alumno = alumnoRepository.findAlumnoById(Integer.valueOf(JsfUtils.getRequest().getParameter("idalumnoMateria")));
        alumnoMateriaList = alumnoMateriaRepository.findAlumnoMateriaByAlumnoid(alumno);

        loadMateriasNoCursadas();

    }

    public void loadMateriasNoCursadas() {
        List<Integer> misMaterias = new ArrayList<>();

        if(!alumnoMateriaList.isEmpty()){
            for (AlumnoMateria materiasEnCiclo: alumnoMateriaList
            ) {
                Materia miMateria = materiasEnCiclo.getMateriaid();
                misMaterias.add(miMateria.getId());
            }
            materiasNoCursadas = materiaRepository.findByIdNotIn(misMaterias);
        }else{
            materiasNoCursadas = materiaRepository.findAll();
        }

    }


    public String deleteMateria() {
        alumnoMateriaRepository.deleteById(Integer.valueOf(JsfUtils.getRequest().getParameter("idMxA")));
        return "/alumnoMateria/alumno_materia.xhtml?faces-redirect=true&idalumnoMateria=" + alumno.getId() + "";
    }


    //getters

    public List<Materia> getMateriasNoCursadas() {
        return materiasNoCursadas;
    }

    public List<AlumnoMateria> getAlumnoMateriaList() {
        return alumnoMateriaList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public AlumnoMateria getAlumnoMateria() {
        return alumnoMateria;
    }

    public Materia getMateria() {
        return materia;
    }
}
