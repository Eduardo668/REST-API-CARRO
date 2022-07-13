package br.com.carro.services.carroservice;

import br.com.carro.models.Carro;

import java.util.List;

public interface CarroService {

    public List<Carro> carrosList();

    public Carro createCar(Carro newCarro);

    public void deleteCar(Long id);

    public Carro updateCarro(Long id, Carro updateCarro);

    public void saveCarroInConcessionaria(Long carro_id, Long concessionaria_id);


}
