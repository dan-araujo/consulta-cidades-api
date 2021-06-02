package br.com.daniel.arj.consultacidadesapi.estados.recursos;

import br.com.daniel.arj.consultacidadesapi.estados.entidades.Estado;
import br.com.daniel.arj.consultacidadesapi.estados.repositorios.EstadoRepositorio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoRecurso {

    private final EstadoRepositorio repositorio;

    public EstadoRecurso(final EstadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Estado> estados() {
        return repositorio.findAll();
    }
}





















