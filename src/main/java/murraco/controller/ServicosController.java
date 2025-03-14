package murraco.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import murraco.model.Servicos;
import murraco.service.ServicosService;

@RestController
@RequestMapping("/servicos")
@Api(tags = "users")
@RequiredArgsConstructor

public class ServicosController {
    private final ServicosService service;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    @ApiResponse(code = 400, message = "Algo deu errado")
    public Servicos addServico( @RequestBody Servicos servico ){
        return service.addServico(servico);
    }

    

}
