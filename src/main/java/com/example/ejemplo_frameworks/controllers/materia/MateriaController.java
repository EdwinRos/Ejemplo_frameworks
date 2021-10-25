package com.example.ejemplo_frameworks.controllers.materia;

import com.example.ejemplo_frameworks.entities.Materia;
import com.example.ejemplo_frameworks.repositories.MateriaRepository;
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

@Scope(value = "session") //declara que solo existira una instancia de esta clase por usuario
@Component(value = "materiaController") //Define esta clase como un componente de Spring y lo llama "materiaController"
@ELBeanName(value = "materiaController") //Configura el nombre del Bean en el rewrite Scope
@Join(path = "/materia/inicio" , to = "/materia/inicio.jsf")
public class MateriaController {

    @Autowired
    MateriaRepository materiaRepository;
    Materia materia = new Materia();
    List<Materia> materiaList;

    public String saveMateria(){
        materiaRepository.save(materia);
        materia = new Materia();
        return "/materia/inicio.xhtml?faces-redirect=true";
    }

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadMaterias(){materiaList = materiaRepository.findAll();}

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public String editar(){
        materia = materiaRepository.findMateriaById(Integer.valueOf(JsfUtils.getRequest().getParameter("materiaID")));
        return "/materia/inicio.xhtml?faces-redirect=true";
    }


    public Materia getMateria() {
        return materia;
    }
}
