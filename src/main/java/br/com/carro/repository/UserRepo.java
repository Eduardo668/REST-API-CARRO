package br.com.carro.repository;

import br.com.carro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

}
