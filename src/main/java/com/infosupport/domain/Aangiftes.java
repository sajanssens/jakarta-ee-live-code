package com.infosupport.domain;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement
@Data @AllArgsConstructor @NoArgsConstructor
public class Aangiftes {

    List<Aangifte> aangiftes;
}
