package br.com.carro.services.concessionariaservice;

import br.com.carro.models.Concessionaria;

import java.util.List;

public interface ConcessionariaService {

    public List<Concessionaria> listaDeConcessionarias();

    public Concessionaria createConcessionaria(Concessionaria newConcessionaria);

    public void deleteConcessionaria(Long id);

    public Concessionaria updateConcessionaria(Long id);

}
