package br.com.daniel.arj.consultacidadesapi.estados.repositorios;

import br.com.daniel.arj.consultacidadesapi.estados.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepositorio extends JpaRepository<Estado, Long> {
}
