package com.example.ejemplo_frameworks.repositories;

import com.example.ejemplo_frameworks.entities.Alumno;
import com.example.ejemplo_frameworks.entities.AlumnoMateria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, Integer> {
	
}
