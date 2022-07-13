package br.com.carro.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Concessionaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "usuarios")
    private List<Usuario> users_list;

    @OneToMany(mappedBy = "carros")
    private List<Carro> carros_list;

    public List<Usuario> getUsers_list() {
        return users_list;
    }

    public void setUsers_list(List<Usuario> users_list) {
        this.users_list = users_list;
    }

    public List<Carro> getCarros_list() {
        return carros_list;
    }

    public void setCarros_list(List<Carro> carros_list) {
        this.carros_list = carros_list;
    }

    public List<Usuario> getUser_list() {
        return users_list;
    }

    public void setUser_list(List<Usuario> user_list) {
        this.users_list = user_list;
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
