package br.com.elo7.sonda.candidato.application.probe.control;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.application.probe.common.ProbeOutput;
import br.com.elo7.sonda.candidato.application.probe.move.MoveProbeCommand;
import br.com.elo7.sonda.candidato.application.probe.move.MoveProbeUseCase;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DefaultControlProbeUseCase extends ControlProbeUseCase {

    private final ProbeGateway gateway;
    private final MoveProbeUseCase moveProbeUseCase;

    public DefaultControlProbeUseCase(final ProbeGateway gateway, final MoveProbeUseCase moveProbeUseCase) {
        this.gateway = Objects.requireNonNull(gateway);
        this.moveProbeUseCase = moveProbeUseCase;
    }

    @Override
    public ProbeOutput execute(final ControlProbeCommand command) {
        final var probe = gateway.findById(command.id())
                .orElseThrow(() ->
                        new NotFoundException("Probe with ID %s was not found".formatted(command.id())));

        final var updatedProbe = moveProbeUseCase.execute(MoveProbeCommand.with(probe, command.moveCommands()));

        return ProbeOutput.from(this.gateway.update(updatedProbe));
    }
}
