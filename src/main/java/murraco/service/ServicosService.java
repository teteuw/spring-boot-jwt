package murraco.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import murraco.exception.CustomException;
import murraco.model.Servicos;
import murraco.repository.ServicosRepository;

@Service
@RequiredArgsConstructor
public class ServicosService {
    
    private final ServicosRepository repository;

    public Servicos addServico(Servicos servico) {
        if(!repository.existsByNomeServico(servico.getNomeServico())){
            repository.save(servico);
            return servico;
        }
        else{
            throw new CustomException("Servico já está cadastrado", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void deleteServico(String nomeServico){
        repository.deleteByNomeServico(nomeServico);
    }

    public Servicos search(String nomeServico){
        if(repository.existsByNomeServico(nomeServico)){
            Servicos servico = repository.findByNomeServico(nomeServico);
            return servico;
        }
        else{
            throw new CustomException("O Serviço não foi cadastrado", HttpStatus.NOT_FOUND);
        }
    }


}
