package br.com.elo7.sonda.candidato.infraestructure.api;

import br.com.elo7.sonda.candidato.application.probe.common.ProbeOutput;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.ControlProbeApiInput;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.CreateProbeApiInput;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.ProbeApiOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "probe")
@Tag(name = "Probe")
public interface ProbeAPI {

    @GetMapping(value = "/{id}",
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a probe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get probe by id successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<ProbeApiOutput> getById(@PathVariable int id);

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all probes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed all probes successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<List<ProbeOutput>> findAll();

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new probe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created probe successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> register(@RequestBody CreateProbeApiInput input);

    @PostMapping(value = "/{id}/control",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Control a probe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Controlled a probe successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<ProbeApiOutput> control(@PathVariable int id, @RequestBody ControlProbeApiInput input);
}
