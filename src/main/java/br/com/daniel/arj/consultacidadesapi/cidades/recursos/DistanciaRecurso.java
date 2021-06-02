package br.com.daniel.arj.consultacidadesapi.cidades.recursos;

import br.com.daniel.arj.consultacidadesapi.cidades.servico.ServicoDistancia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/distancias")
public class DistanciaRecurso {

    Logger log = LoggerFactory.getLogger(DistanciaRecurso.class);

    private final ServicoDistancia servico;

    public DistanciaRecurso(ServicoDistancia servico) {
        this.servico = servico;
    }

    @GetMapping("/by-points")
    public Double porPontos(@RequestParam(name = "from") final Long cidade1,
                            @RequestParam(name = "to") final Long cidade2) {
        log.info("porPontos");
        return servico.distanciaPorPontosEmMilhas(cidade1, cidade2);
    }

    @GetMapping("/by-cube")
    public Double porCubo(@RequestParam(name = "from") final Long cidade1,
                          @RequestParam(name = "to") final Long cidade2) {
        log.info("porCubo");
        return servico.distanciaPorCuboEmMetros(cidade1, cidade2);
    }

}
















