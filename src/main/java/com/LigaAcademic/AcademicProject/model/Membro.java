package com.LigaAcademic.AcademicProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "membros")
public class Membro {

    private String nome;
    private String cargo;
    @Column(unique = true,length = 11)
    private String matricula;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "membros.Membro{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }



}
