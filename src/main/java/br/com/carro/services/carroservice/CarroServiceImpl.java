package br.com.carro.services.carroservice;

import br.com.carro.models.Carro;
import br.com.carro.models.Concessionaria;
import br.com.carro.repository.CarroRepo;
import br.com.carro.repository.ConcessionariaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    private final CarroRepo carroRepo;
    private final ConcessionariaRepo concessionariaRepo;

    public CarroServiceImpl(CarroRepo carroRepo, ConcessionariaRepo concessionariaRepo){
        this.carroRepo = carroRepo;
        this.concessionariaRepo = concessionariaRepo;
    }


    @Override
    public List<Carro> carrosList() {
        return carroRepo.findAll();
    }

    @Override
    public Carro createCar(Carro newCarro) {
        try {
            return carroRepo.save(newCarro);
        }
        catch (Exception e){
            throw  new IllegalArgumentException("Ocorreu um erro ao salvar o carro!!!");
        }
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Carro> carro_data = carroRepo.findById(id);
        if (carro_data.isEmpty()){
            throw new IllegalArgumentException("Este carro não está presente em nosso banco de dados!");
        }
        carroRepo.delete(carro_data.get());
    }

    @Override
    public Carro updateCarro(Long id, Carro updateCarro) {
             Optional<Carro> carro_data = carroRepo.findById(id);
             if(carro_data.isEmpty()){
                throw new IllegalArgumentException("Este carro não está presente em nosso banco de dados!");
             }
             carro_data.get().setCar_name(updateCarro.getCar_name());
             carro_data.get().setModelo(updateCarro.getModelo());
             carro_data.get().setMarca(updateCarro.getMarca());
             carro_data.get().setPreco(updateCarro.getPreco());
             return carroRepo.save(carro_data.get());
    }

    @Override
    public void saveCarroInConcessionaria(Long carro_id, Long concessionaria_id) {
        Optional<Carro> carro_data = carroRepo.findById(carro_id);
        Optional<Concessionaria> concessionaria_data = concessionariaRepo.findById(concessionaria_id);

        if (carro_data.isEmpty() || concessionaria_data.isEmpty()){
            throw new IllegalArgumentException("Carro ou concessionaria não encotrados");
        }

        carro_data.get().setConcessionaria(concessionaria_data.get());
        carroRepo.save(carro_data.get());
    }



}
