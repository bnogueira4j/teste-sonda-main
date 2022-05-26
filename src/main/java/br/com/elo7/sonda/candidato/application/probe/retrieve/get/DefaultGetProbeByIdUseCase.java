package br.com.elo7.sonda.candidato.application.probe.retrieve.get;

import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import br.com.elo7.sonda.candidato.domain.exceptions.DomainException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

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
                .orElseThrow(notFound(id));
    }

    private Supplier<DomainException> notFound(final int id) {
        return () -> DomainException.with(new Error("Probe with ID %s was not found".formatted(id)));
    }
}
