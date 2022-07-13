package br.com.carro.repository;

import br.com.carro.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepo extends JpaRepository<Carro, Long> {
}
