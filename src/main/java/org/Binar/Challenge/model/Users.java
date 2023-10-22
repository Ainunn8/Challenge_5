package org.Binar.Challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "username", length = 100, unique = true)
    private String username;

    @Column(name = "email_address", length = 100)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Merchant> merchants;
    @OneToMany
    private List<Product> product;



}
