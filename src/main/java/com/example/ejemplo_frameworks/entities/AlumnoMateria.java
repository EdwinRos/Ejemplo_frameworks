package com.example.ejemplo_frameworks.entities;

import javax.persistence.*;

@Entity
@Table(name = "alumno_materia")
public class AlumnoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne()
    @JoinColumn(
            name = "alumno_id",
            nullable = false
    )
    private Alumno alumnoid;

    @OneToOne
    @JoinColumn(
            name = "materia_id",
            nullable = false
    )
    private Materia materiaid;

    public AlumnoMateria() {
    }

    public AlumnoMateria(Alumno alumnoid, Materia materiaid) {
        this.alumnoid = alumnoid;
        this.materiaid = materiaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumnoid() {
        return alumnoid;
    }

    public void setAlumnoid(Alumno alumnoid) {
        this.alumnoid = alumnoid;
    }

    public Materia getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(Materia materiaid) {
        this.materiaid = materiaid;
    }

    @Override
    public String toString() {
        return "AlumnoMateria{" +
                "id=" + id +
                ", alumnoid=" + alumnoid +
                ", materiaid=" + materiaid +
                '}';
    }
}
