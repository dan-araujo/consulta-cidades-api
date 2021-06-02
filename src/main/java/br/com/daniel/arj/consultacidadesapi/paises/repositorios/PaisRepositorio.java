package br.com.daniel.arj.consultacidadesapi.paises.repositorios;

import br.com.daniel.arj.consultacidadesapi.paises.entidades.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepositorio extends JpaRepository<Pais, Long> {
}
