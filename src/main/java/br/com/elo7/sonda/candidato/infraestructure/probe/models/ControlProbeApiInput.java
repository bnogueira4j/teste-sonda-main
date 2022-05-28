package br.com.elo7.sonda.candidato.infraestructure.probe.models;

import br.com.elo7.sonda.candidato.domain.probe.Command;

import java.util.List;

public record ControlProbeApiInput(List<Command> commands) {
}
