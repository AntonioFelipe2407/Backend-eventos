package com.eventosdiversos.apiEventos.domain.coupon;

import com.eventosdiversos.apiEventos.domain.event.Event;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue
    private UUID id;

    private Integer discount;
    private String code;
    private LocalDate valid;

    @ManyToOne
    @JoinColumn(name = "event_id")  //Transformando essa coluna em uma associação a tabela events
    private Event event;

    public Coupon() {
    }

    public Coupon(UUID id, Integer discount, String code, LocalDate valid, Event event) {
        this.id = id;
        this.discount = discount;
        this.code = code;
        this.valid = valid;
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getValid() {
        return valid;
    }

    public void setValid(LocalDate valid) {
        this.valid = valid;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
