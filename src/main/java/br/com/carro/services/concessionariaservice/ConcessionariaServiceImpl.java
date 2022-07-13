package br.com.carro.services.concessionariaservice;

import br.com.carro.models.Concessionaria;
import br.com.carro.repository.ConcessionariaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcessionariaServiceImpl implements ConcessionariaService {

    private final ConcessionariaRepo concessionariaRepo;

    public ConcessionariaServiceImpl(ConcessionariaRepo concessionariaRepo){
        this.concessionariaRepo = concessionariaRepo;
    }


    @Override
    public List<Concessionaria> listaDeConcessionarias() {
        return concessionariaRepo.findAll();
    }

    @Override
    public Concessionaria createConcessionaria(Concessionaria newConcessionaria) {
        try {
            return concessionariaRepo.save(newConcessionaria);
        }catch (Exception e){
            throw new IllegalArgumentException("Ocorreu um erro, tente novamente!");
        }
    }

    @Override
    public void deleteConcessionaria(Long id) {
        Optional<Concessionaria> concessionaria_data = concessionariaRepo.findById(id);
        if (concessionaria_data.isEmpty()){
            throw new IllegalArgumentException
                    ("Está concessionaria não esta presente em nosso banco de dados");
        }
        concessionariaRepo.delete(concessionaria_data.get());
    }

    @Override
    public Concessionaria updateConcessionaria(Long id) {
        Optional<Concessionaria> concessionaria_data = concessionariaRepo.findById(id);
        if (concessionaria_data.isEmpty()){
            throw new IllegalArgumentException
                    ("Está concessionaria não esta presente em nosso banco de dados");
        }
       return concessionariaRepo.save(concessionaria_data.get());
    }
}
