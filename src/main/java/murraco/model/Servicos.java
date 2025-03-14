package murraco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "servicos")
@Data
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_servico", nullable = false)
    private String nomeServico;

    @Column(name = "preco_servico", nullable = false)
    private Double precoServico;

    @Column(name = "descricao", nullable = false)
    private String descricao;


}
