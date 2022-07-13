package br.com.carro.repository;

import br.com.carro.models.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariaRepo extends JpaRepository<Concessionaria, Long> {
}
