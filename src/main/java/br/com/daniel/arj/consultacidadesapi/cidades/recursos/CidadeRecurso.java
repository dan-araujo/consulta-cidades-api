package br.com.daniel.arj.consultacidadesapi.cidades.recursos;

import br.com.daniel.arj.consultacidadesapi.cidades.entidades.Cidade;
import br.com.daniel.arj.consultacidadesapi.cidades.repositorios.CidadeRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cidades")
public class CidadeRecurso {

    public final CidadeRepositorio repositorio;

    public CidadeRecurso(final CidadeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public Page<Cidade> cidades(final Pageable pagina) {
        return repositorio.findAll(pagina);
    }
}
