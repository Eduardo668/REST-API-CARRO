package br.com.carro.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Concessionaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "concessionaria")
    @JsonManagedReference
    private Set<Usuario> users_list;

    @OneToMany(mappedBy = "concessionaria")
    @JsonManagedReference
    private Set<Carro> carros_list;

    public Set<Usuario> getUsers_list() {
        return users_list;
    }

    public void setUsers_list(Set<Usuario> users_list) {
        this.users_list = users_list;
    }

    public Set<Carro> getCarros_list() {
        return carros_list;
    }

    public void setCarros_list(Set<Carro> carros_list) {
        this.carros_list = carros_list;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
