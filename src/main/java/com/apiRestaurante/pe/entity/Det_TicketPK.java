package com.apiRestaurante.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class Det_TicketPK implements Serializable {

    @Column(name = "idTck", nullable = false)
    private Long idTck;

    @Column(name = "idProd", nullable = false)
    private Long idProd;

    public Det_TicketPK() {}

    public Det_TicketPK(Long idTck, Long idProd) {
        this.idTck = idTck;
        this.idProd = idProd;
    }

    public Long getIdTck() {
        return idTck;
    }

    public void setIdTck(Long idTck) {
        this.idTck = idTck;
    }

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Det_TicketPK that = (Det_TicketPK) o;
        return Objects.equals(idTck, that.idTck) && Objects.equals(idProd, that.idProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTck, idProd);
    }
}

