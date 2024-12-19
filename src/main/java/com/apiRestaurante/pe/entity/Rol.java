package com.apiRestaurante.pe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Rol")
@Table(name = "rol")
public class Rol {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idRol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRol;

    @Column(name = "nombreRol")
    private String nombreRol;

    @Column(name = "estado")
    private boolean estado;
}