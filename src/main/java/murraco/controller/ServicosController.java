package murraco.controller;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import murraco.dto.ServicosDTO;
import murraco.dto.UserResponseDTO;
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

    @GetMapping("/get/{nomeServico}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${ServicosController.search}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Não achado"),
        @ApiResponse(code = 400, message ="Algo deu errado")
    })
    
    public ServicosDTO procurar(@PathVariable String nomeServico){
        return modelMapper.map(service.search(nomeServico), ServicosDTO.class);
    }

    

}
