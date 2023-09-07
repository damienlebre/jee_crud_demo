package com.example.crudplagedemo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name = "plage")
public class Plage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "Veuillez indiquer le nom de la plage")
    private String nom;
    @Column(nullable = false)
    @NotBlank(message = "Veuillez indiquer la rue de la plage")
    private String street;
    @Column(nullable = false)
    @NotBlank(message = "Veuillez indiquer le numero de rue de la plage")
    private String number;
    @Column(nullable = false)
    @NotBlank(message = "Veuillez indiquer le code postal de la plage")
    private String codePostal;
    @Column(nullable = false)
    @NotBlank(message = "Veuillez indiquer la ville de la plage")
    private String city;
    @Column(nullable = false)
    @NotBlank(message = "Veuillez saisir un email")
    @Email(message = "Veuiller saisir un email valide" )
    private String email;
    @Column
    private String image;

    public Plage(String nom, String street, String number, String codePostal, String city, String email, String image) {
        this.nom = nom;
        this.street = street;
        this.number = number;
        this.codePostal = codePostal;
        this.city = city;
        this.email = email;
        this.image = image;
    }


    public Plage() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
