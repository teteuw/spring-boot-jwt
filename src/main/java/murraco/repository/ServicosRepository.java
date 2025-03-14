package murraco.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import murraco.model.Servicos;
@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long>{

    Servicos getById(Long id);

    boolean existsByNomeServico(String nomeServico);

    Servicos findByNomeServico(String nomeServico);

    Servicos findByDescricao(String descricao);

    @Transactional
    void deleteByNomeServico(String nomeServico);
}
