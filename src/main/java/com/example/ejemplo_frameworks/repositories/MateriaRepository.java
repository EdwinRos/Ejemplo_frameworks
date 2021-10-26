package com.example.ejemplo_frameworks.repositories;

import com.example.ejemplo_frameworks.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    Materia findMateriaById(Integer id);  //buscamos al objeto Materia por su ID dandole como parametro este mismo

    List<Materia> findByIdNotIn(List<Integer> a);

}
