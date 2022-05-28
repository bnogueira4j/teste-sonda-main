package br.com.elo7.sonda.candidato.application.probe.retrieve.get;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.application.probe.common.ProbeOutput;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import org.springframework.stereotype.Component;

@Component
public class DefaultGetProbeByIdUseCase extends GetProbeByIdUseCase {

    private final ProbeGateway gateway;

    public DefaultGetProbeByIdUseCase(final ProbeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ProbeOutput execute(Integer id) {
        return gateway.findById(id)
                .map(ProbeOutput::from)
                .orElseThrow(() ->
                        new NotFoundException("Probe with ID %s was not found".formatted(id)));
    }
}
