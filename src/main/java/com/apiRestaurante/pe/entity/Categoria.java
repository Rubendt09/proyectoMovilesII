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
@Entity(name = "Categoria")
@Table(name = "categoria")
public class Categoria {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idCategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @Column(name = "nomcat")
    private String nombreCat;

    @Column(name = "estado")
    private boolean estado;



}
