package br.com.carro.controllers;

import br.com.carro.models.Concessionaria;
import br.com.carro.models.Usuario;
import br.com.carro.services.concessionariaservice.ConcessionariaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concessionaria")
public class ConcessionariaController {

    private final ConcessionariaServiceImpl concessionariaService;

    public ConcessionariaController(ConcessionariaServiceImpl concessionariaService) {
        this.concessionariaService = concessionariaService;
    }

    @PostMapping("/create")
    public ResponseEntity<Concessionaria> createConcessionaria(@RequestBody Concessionaria newConcessionaria){
        try {
            return ResponseEntity.ok(concessionariaService.createConcessionaria(newConcessionaria));
        }
        catch (Exception e){
            throw new IllegalArgumentException("Ocorreu algum erro!");
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Concessionaria>> concessionariasList(){
        return ResponseEntity.ok(concessionariaService.listaDeConcessionarias());
    }

    @PutMapping("/update={updateConcessionariaId}")
    public ResponseEntity<String> updateConcessionaria(@PathVariable Long updateConcessionariaId,
                                                       @RequestBody Concessionaria updateConcessionaria){

        return ResponseEntity.ok("Concessionaria "+ updateConcessionaria.getNome()+ " atualizado com sucesso");
    }

    @DeleteMapping("/delete={deleteConcessionariaId}")
    public ResponseEntity<String> deleteConcessionaria(@PathVariable Long deleteConcessionariaId){

        concessionariaService.deleteConcessionaria(deleteConcessionariaId);
        return ResponseEntity.ok("Concessionaria deletada com sucesso");
    }






}
