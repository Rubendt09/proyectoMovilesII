package com.apiRestaurante.pe.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Empleado")
@Table(name = "empleado")
public class Empleado {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpleado;

    @Column(name = "nomEmpl")
    private String nombreEmpl;

    @ManyToOne
    @JoinColumn(name = "idRol",nullable = false)
    private Rol rol;

    @Column(name = "estado")
    private boolean estado;


}
