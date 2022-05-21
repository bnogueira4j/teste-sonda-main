package br.com.elo7.sonda.candidato.application.dto;

import br.com.elo7.sonda.candidato.core.domain.Command;
import br.com.elo7.sonda.candidato.core.domain.Direction;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class ProbeDTO {
    private int positionX;
    private int positionY;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
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
