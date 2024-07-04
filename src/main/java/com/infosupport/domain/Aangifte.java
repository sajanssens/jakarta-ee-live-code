package com.infosupport.domain;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data @NoArgsConstructor
@Builder @AllArgsConstructor
public class Aangifte {

    private int id;
    private String bsn;
    private double bedrag;

    private String _self;

    public Aangifte(int id, String bsn, double bedrag) {
        this.id = id;
        this.bsn = bsn;
        this.bedrag = bedrag;
    }
}
