package br.com.carro.services.userservice;

import br.com.carro.models.Usuario;

import java.util.List;

public interface UserService {

    public List<Usuario> findAllUsers();

    public Usuario createUser(Usuario user);

    public String deleteUser(Long id);

    public Usuario updateUser(Long id, Usuario updateUser);

    public void saveUserInConcessionaria(Long user_id, Long concessionaria_id);

}
