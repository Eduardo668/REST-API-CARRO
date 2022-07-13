package br.com.carro.services.userservice;

import br.com.carro.models.Concessionaria;
import br.com.carro.models.Usuario;
import br.com.carro.repository.ConcessionariaRepo;
import br.com.carro.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final ConcessionariaRepo concessionariaRepo;

    public UserServiceImpl(UserRepo userRepo, ConcessionariaRepo concessionariaRepo){
        this.userRepo = userRepo;
        this.concessionariaRepo = concessionariaRepo;
    }

    @Override
    public List<Usuario> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Usuario createUser(Usuario user) {
        try{
            Usuario user_data = userRepo.findByUsername(user.getUsername());
            if (user_data != null){
                throw new IllegalArgumentException("Este username já esta sendo utilizado");
            }
            return userRepo.save(user);
        }catch (Exception e){
            throw new IllegalArgumentException
                    ("Ocorreu um erro durante o cadastro do usuario, tente novamente!!");
        }
    }

    @Override
    public String deleteUser(Long id) {
        Optional<Usuario> user_data = userRepo.findById(id);
        if (user_data.isEmpty()){
            throw new IllegalArgumentException("Este usuario não está cadastrado");
        }
        userRepo.delete(user_data.get());
        return user_data.get().getUsername();
    }

    @Override
    public Usuario updateUser(Long id, Usuario updateUser) {
        Optional<Usuario> user_data = userRepo.findById(id);
        if (user_data.isEmpty()){
            throw new IllegalArgumentException("Este usuario não está cadastrado");
        }

        user_data.get().setUsername(updateUser.getUsername());
        user_data.get().setFullname(updateUser.getFullname());
        user_data.get().setEmail(updateUser.getEmail());
        user_data.get().setPassword(updateUser.getPassword());
        user_data.get().setConcessionaria(updateUser.getConcessionaria());


        return userRepo.save(user_data.get());
    }

    @Override
    public void saveUserInConcessionaria(Long user_id, Long concessionaria_id) {
        Optional<Usuario> user_data = userRepo.findById(user_id);
        Optional<Concessionaria> concessionaria_data = concessionariaRepo.findById(concessionaria_id);

        if (user_data.isEmpty() || concessionaria_data.isEmpty()){
            throw new IllegalArgumentException("Usuario ou concessionaria não encotrados");
        }

        user_data.get().setConcessionaria(concessionaria_data.get());
        userRepo.save(user_data.get());
    }
}
