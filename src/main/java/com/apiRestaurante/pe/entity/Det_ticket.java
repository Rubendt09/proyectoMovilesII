package com.apiRestaurante.pe.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Det_Ticket")
public class Det_ticket implements Serializable {

    @EmbeddedId
    private Det_TicketPK id;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Precio")
    private Double precio;

//    @ManyToOne
//    @MapsId("idTck")
//    @JoinColumn(name = "idTck")
//    private Ticket ticket;

    @Column(name = "estado")
    private boolean estado;

//    @ManyToOne
//    @MapsId("idProd")
//    @JoinColumn(name = "idProd")
//    private Producto producto;

}