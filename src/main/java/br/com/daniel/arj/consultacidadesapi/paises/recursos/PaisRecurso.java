package br.com.daniel.arj.consultacidadesapi.paises.recursos;

import br.com.daniel.arj.consultacidadesapi.paises.entidades.Pais;
import br.com.daniel.arj.consultacidadesapi.paises.repositorios.PaisRepositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class PaisRecurso {

    private final PaisRepositorio repositorio;

    public PaisRecurso(final PaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/paises")
    public Page<Pais> paises(Pageable pagina) {
       return repositorio.findAll(pagina);
    }

}













