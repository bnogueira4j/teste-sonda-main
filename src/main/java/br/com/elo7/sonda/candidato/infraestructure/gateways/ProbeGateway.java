package br.com.elo7.sonda.candidato.infraestructure.gateways;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.sonda.candidato.core.gateways.AbstractProbeGateway;
import br.com.elo7.sonda.candidato.core.repository.IPlanetRepository;
import br.com.elo7.sonda.candidato.core.repository.IProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import br.com.elo7.sonda.candidato.application.dto.InputDTO;
import br.com.elo7.sonda.candidato.application.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.core.domain.Command;
import br.com.elo7.sonda.candidato.core.domain.Direction;
import br.com.elo7.sonda.candidato.core.domain.Planet;
import br.com.elo7.sonda.candidato.core.domain.Probe;

@Service
public class ProbeGateway implements AbstractProbeGateway {
	@Autowired
	private IPlanetRepository planetRepository;
	@Autowired
	private IProbeRepository probeRepository;
	
	public List<Probe> landProbes(InputDTO input) {
		Planet planet = concertPlanet(input);
		final var savedPlanet = planetRepository.save(planet);
		
		List<Probe> convertedProbes = convertAndMoveProbes(input, savedPlanet);
		convertedProbes.forEach(probe -> probeRepository.save(probe));
		
		return convertedProbes;
	}
	
	@VisibleForTesting
	void applyCommandToProbe(Probe probe, Command command) {
		switch (command) {
			case RIGHT -> turnProbeRight(probe);
			case LEFT -> turnProbeLeft(probe);
			case MOVE -> moveProbeForward(probe);
		}
	}

	private void moveProbeForward(Probe probe) {
		int newPositionX = probe.getPositionX();
		int newPositionY = probe.getPositionY();
		switch (probe.getDirection()) {
			case NORTH -> newPositionY++;
			case WEST -> newPositionX--;
			case SOUTH -> newPositionY--;
			case EAST -> newPositionX++;
		}
		probe.setPositionX(newPositionX);
		probe.setPositionY(newPositionY);
	}

	private void turnProbeLeft(Probe probe) {
		Direction newDirection = switch (probe.getDirection()) {
			case NORTH -> Direction.WEST;
			case WEST -> Direction.SOUTH;
			case SOUTH -> Direction.EAST;
			case EAST -> Direction.NORTH;
		};
		probe.setDirection(newDirection);
	}
	
	private void turnProbeRight(Probe probe) {
		Direction newDirection = switch (probe.getDirection()) {
			case NORTH -> Direction.EAST;
			case EAST -> Direction.SOUTH;
			case SOUTH -> Direction.WEST;
			case WEST -> Direction.NORTH;
		};
		System.out.println(newDirection);
		probe.setDirection(newDirection);
	}
	
	private List<Probe> convertAndMoveProbes(InputDTO input, Planet planet) {
		return input.getProbes()
						.stream().map(probeDto -> {
							Probe probe = convertProbe(probeDto, planet);
							moveProbeWithAllCommands(probe, probeDto);
							return probe;
						}).collect(Collectors.toList());
	}

	private void moveProbeWithAllCommands(Probe probe, ProbeDTO probeDTO) {
		for (Command command : probeDTO.getCommands()) {
			applyCommandToProbe(probe, command);
		}
	}
	
	private Probe convertProbe(ProbeDTO probeDto, Planet planet) {
		Probe probe = new Probe();
		probe.setPlanet(planet);
		probe.setPositionX(probeDto.getPositionX());
		probe.setPositionY(probeDto.getPositionY());
		probe.setDirection(probeDto.getDirection());
		return probe;
	}
	
	private Planet concertPlanet(InputDTO input) {
		Planet planet = new Planet();
		planet.setHeight(input.getHeight());
		planet.setWidth(input.getWidth());
		return planet;
	}
}
