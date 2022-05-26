package br.com.elo7.sonda.candidato.domain.probe;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Command {
    @JsonProperty("L") LEFT,
    @JsonProperty("M") MOVE,
    @JsonProperty("R") RIGHT
}
