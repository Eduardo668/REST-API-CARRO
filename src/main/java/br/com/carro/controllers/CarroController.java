package br.com.carro.controllers;

import br.com.carro.extra_classes.CarroAndConcessionariaID;
import br.com.carro.extra_classes.UserAndConcessionariaID;
import br.com.carro.models.Carro;
import br.com.carro.models.Concessionaria;
import br.com.carro.models.Usuario;
import br.com.carro.services.carroservice.CarroServiceImpl;
import br.com.carro.services.concessionariaservice.ConcessionariaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    private final CarroServiceImpl carroService;

    public CarroController(CarroServiceImpl carroService) {
        this.carroService = carroService;
    }

    @PostMapping("/create")
    public ResponseEntity<Carro> createCarro(@RequestBody Carro newCarro){
        try {
            return ResponseEntity.ok(carroService.createCar(newCarro));
        }
        catch (Exception e){
            throw new IllegalArgumentException("Ocorreu algum erro!");
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Carro>> concessionariasList(){
        return ResponseEntity.ok(carroService.carrosList());
    }

    @PutMapping("/update={updateCarroId}")
    public ResponseEntity<String> updateCarro(@PathVariable Long updateCarroId,
                                                       @RequestBody Carro updateCarro){

        carroService.updateCarro(updateCarroId, updateCarro);
        return ResponseEntity.ok("Concessionaria "+ updateCarro.getCar_name()+ " atualizado com sucesso");
    }

    @DeleteMapping("/delete={deleteCarroId}")
    public ResponseEntity<String> deleteCarro(@PathVariable Long deleteCarroId){

        carroService.deleteCar(deleteCarroId);
        return ResponseEntity.ok("Concessionaria deletada com sucesso");
    }

    @PutMapping("/addCarInConcessionaria")
    public ResponseEntity<String>
    carroInConcessionaria(@RequestBody CarroAndConcessionariaID carroAndConcessionariaID){

        carroService.saveCarroInConcessionaria(
                carroAndConcessionariaID.getCarro_id(),
                carroAndConcessionariaID.getConcessionaria_id()
        );

        return ResponseEntity.ok("Funcionou");

    }




}
