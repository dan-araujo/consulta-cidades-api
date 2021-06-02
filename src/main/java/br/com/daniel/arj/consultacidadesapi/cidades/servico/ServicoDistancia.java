package br.com.daniel.arj.consultacidadesapi.cidades.servico;

import br.com.daniel.arj.consultacidadesapi.cidades.entidades.Cidade;
import br.com.daniel.arj.consultacidadesapi.cidades.repositorios.CidadeRepositorio;
import br.com.daniel.arj.consultacidadesapi.utils.LocalizacaoStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ServicoDistancia {

    private final CidadeRepositorio cidadeRepositorio;
    Logger log = LoggerFactory.getLogger(ServicoDistancia.class);

    public ServicoDistancia(final CidadeRepositorio cidadeRepositorio) {
        this.cidadeRepositorio = cidadeRepositorio;
    }

    public Double distanciaUsandoMat(final Long cidade1, final Long cidade2, final RaioDaTerra unidade) {
        log.info("distanciaUsandoMat({}, {})", cidade1, cidade2, unidade);
        final List<Cidade> cidades = cidadeRepositorio.findAllById((Arrays.asList(cidade1, cidade2)));

        final Double[] localizacao1 = LocalizacaoStringUtils.transform(cidades.get(0).getGeolocation());
        final Double[] localizacao2 = LocalizacaoStringUtils.transform(cidades.get(1).getGeolocation());

        return fazerCalculo(localizacao1[0], localizacao1[1], localizacao2[0], localizacao2[1], unidade);
    }

    public Double distanciaPorPontosEmMilhas(final Long cidade1, final Long cidade2) {
        log.info("nativePostgresInMiles({}, {})", cidade1, cidade2);
        return cidadeRepositorio.distanciaPorPontos(cidade1, cidade2);
    }

    public Double distanciaUsandoPontos(final Long cidade1, final Long cidade2, final RaioDaTerra unidade) {
        log.info("distanciaUsandoPontos({}, {})", cidade1, cidade2, unidade);
        final List<Cidade> cidades = cidadeRepositorio.findAllById((Arrays.asList(cidade1, cidade2)));

        Point p1 = cidades.get(0).getLocation();
        Point p2 = cidades.get(1).getLocation();

        return fazerCalculo(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unidade);
    }

    public Double distanciaPorCuboEmMetros(Long cidade1, Long cidade2) {
        log.info("distanciaPorCuboEmMetros({}, {})", cidade1, cidade2);
        final List<Cidade> cidades = cidadeRepositorio.findAllById((Arrays.asList(cidade1, cidade2)));

        Point p1 = cidades.get(0).getLocation();
        Point p2 = cidades.get(1).getLocation();

        return cidadeRepositorio.distanciaPorCubo(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    private Double fazerCalculo(final Double lat1, final Double lon1, final Double lat2, final Double lon2, final RaioDaTerra raioDaTerra) {
        double lat = Math.toRadians(lat2 - lat1);
        double lon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lon / 2) * Math.sin(lon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return raioDaTerra.getValor() * c;
    }
}
















