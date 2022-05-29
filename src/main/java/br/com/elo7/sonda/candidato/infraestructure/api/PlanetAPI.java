package br.com.elo7.sonda.candidato.infraestructure.api;

import br.com.elo7.sonda.candidato.application.planet.common.PlanetOutput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.CreatePlanetApiInput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.PlanetApiInput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.PlanetApiOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "planet")
@Tag(name = "Planet")
public interface PlanetAPI {

    @GetMapping(value = "/{id}",
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a planet by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get planet by id successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    PlanetApiOutput getById(@PathVariable int id);

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all planets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed all planets successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<List<PlanetOutput>> findAll();

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new planet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created planet successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> register(@RequestBody CreatePlanetApiInput input);

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a planet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated a planet successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> update(@RequestBody PlanetApiInput input);
}
