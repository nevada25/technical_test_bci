package com.technical.bci.technical_test_bci.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email(message = "Formato de correo incorrecto")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2}).+$", message = "Formato de contraseña incorrecto: intente con este formato => Una Mayuscula, letras minúsculas, y dos numeros")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    @Column(nullable = false)
    private Date created;

    private Date modified;

    private Date lastLogin;

    @Column(length = 1000)
    private String token;

    private boolean isActive;

    // Getters y Setters

    @PrePersist
    protected void onCreate() {
        this.created = new Date();
        this.lastLogin = this.created;
    }




    @PreUpdate
    protected void onUpdate() {
        this.modified = new Date();
    }
}