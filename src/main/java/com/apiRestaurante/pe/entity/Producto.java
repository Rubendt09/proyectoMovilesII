package com.apiRestaurante.pe.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Producto")
@Table(name="producto")

public class Producto {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idProd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProd;


    @Column(name = "nomProd")
    private String nomProd;

    @Column(name = "descProd")
    private String descProd;

    @Column(name = "precioProd")
    private Double precioProd;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idTipo")
    private Tipo tipo;

    @Column(name = "imgProd")
    private String imgProd;

    @Column(name = "validez")
    private String validez;



}
