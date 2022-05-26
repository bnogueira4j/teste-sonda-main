package br.com.elo7.sonda.candidato.infraestructure.probe.models;

import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Direction;

import java.util.List;

public record CreateProbeApiInput(int positionX,
                                  int positionY,
                                  Direction direction,
                                  List<Command> commands,
                                  int planetId
) {
}
