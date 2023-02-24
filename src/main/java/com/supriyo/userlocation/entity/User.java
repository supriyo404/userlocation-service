package com.supriyo.userlocation.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER,optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private Location location;

}
