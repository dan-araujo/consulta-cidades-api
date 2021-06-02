package br.com.daniel.arj.consultacidadesapi.cidades.repositorios;

import br.com.daniel.arj.consultacidadesapi.cidades.entidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CidadeRepositorio extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanciaPorPontos(final Long idCidade1, final Long idCidade2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanciaPorCubo(final Double lat1, final Double lon1, final Double lat2, final Double lon2);
}
