package com.apiRestaurante.pe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Ticket")
@Table(name="ticket")
public class Ticket {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idTck")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTck;

    @Column(name = "fecTck")
    private Date fecTck;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;



}
