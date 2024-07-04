package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data @NoArgsConstructor
@Builder @AllArgsConstructor
@Entity
public class Aangifte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bsn;
    private double bedrag;

    private transient String _self;

    public Aangifte(int id, String bsn, double bedrag) {
        this.id = id;
        this.bsn = bsn;
        this.bedrag = bedrag;
    }
}
