package br.com.elo7.sonda.candidato.application.probe.retrieve.list;

import br.com.elo7.sonda.candidato.application.probe.common.ProbeOutput;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultListProbesUseCase extends ListProbesUseCase {

    private final ProbeGateway gateway;

    public DefaultListProbesUseCase(final ProbeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ProbeOutput> execute() {
        return gateway.findAll().stream().map(ProbeOutput::from).toList();
    }
}
