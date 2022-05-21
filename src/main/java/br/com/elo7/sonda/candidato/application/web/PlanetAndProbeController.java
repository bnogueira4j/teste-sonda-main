package br.com.elo7.sonda.candidato.application.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.application.dto.InputDTO;
import br.com.elo7.sonda.candidato.core.domain.Probe;
import br.com.elo7.sonda.candidato.infraestructure.gateways.ProbeGateway;

@Controller
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {
	@Autowired
	private ProbeGateway probeGateway;

	@PostMapping
    public ResponseEntity<List<Probe>> register(@RequestBody InputDTO inputDto) {
		return ResponseEntity.ok(probeGateway.landProbes(inputDto));
    }
}
