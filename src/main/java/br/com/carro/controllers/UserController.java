package br.com.carro.controllers;

import br.com.carro.extra_classes.UserAndConcessionariaID;
import br.com.carro.models.Usuario;
import br.com.carro.services.userservice.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario newUser){
        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Usuario>> userList(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PutMapping("/update={updateUserId}")
    public ResponseEntity<String> updateUser(@PathVariable Long updateUserId,
                                             @RequestBody Usuario updateUser){
        Usuario updatedUser = userService.updateUser(updateUserId, updateUser);
        return ResponseEntity.ok("Usuario "+ updatedUser.getUsername() + " atualizado com sucesso");
    }

    @DeleteMapping("/delete={deleteUserId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long deleteUserId){
        String deletedUser = userService.deleteUser(deleteUserId);
        return ResponseEntity.ok("Usuario "+ deletedUser + " deletado com sucesso");
    }

    @PutMapping("/addUserInConcessionaria")
    public ResponseEntity<String>
    addUserInConcessionaria(@RequestBody UserAndConcessionariaID userAndConcessionariaID){

        userService.saveUserInConcessionaria(
                userAndConcessionariaID.getUser_id(),
                userAndConcessionariaID.getConcessionaria_id()
        );

        return ResponseEntity.ok("Funcionou");

    }






}
