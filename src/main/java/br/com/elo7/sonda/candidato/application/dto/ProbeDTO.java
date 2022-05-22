package br.com.elo7.sonda.candidato.application.dto;

import br.com.elo7.sonda.candidato.core.domain.Command;
import br.com.elo7.sonda.candidato.core.domain.Direction;

import java.util.List;

public class ProbeDTO {
    private int positionX;
    private int positionY;
    private Direction direction;
    private List<Command> commands;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
