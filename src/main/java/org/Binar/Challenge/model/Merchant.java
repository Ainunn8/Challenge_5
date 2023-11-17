package org.Binar.Challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Merchant")
public class Merchant implements Serializable {
    @Id
    private int merchantCode;
    private String nameMerchant;
    private String location;
    private String isOpen;

}


