package org.Binar.Challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {

    private String id;
    private String customerName;
    private double amount;
}
