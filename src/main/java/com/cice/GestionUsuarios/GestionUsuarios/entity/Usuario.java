package com.cice.GestionUsuarios.GestionUsuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name = "pass")
    private String pass;

}
