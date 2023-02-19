package com.pragma.powerup.plazoleta.infraestructure.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "categoriasDePlatos")
public class CatergoriaEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String descripcion;

    public CatergoriaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
