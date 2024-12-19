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
@Entity(name = "Tipo")
@Table(name = "tipo")
public class Tipo {

    @Id
    @Column(name = "idTipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipo;

    @Column(name = "nomTipo")
    private String nomTipo;

    @Column(name = "estado")
    private boolean estado;
}