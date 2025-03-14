package com.dyn.graph;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/country")
public class GraphQLController {

    private final GraphQLService graphQLService;

    public GraphQLController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @GetMapping("/{code}")
    public Mono<Map<String, Object>> getCountry(@PathVariable String code) {
        return graphQLService.getCountryByCode(code)
                .onErrorResume(e -> {
                    // Handle errors gracefully and return a default response
                    return Mono.just(Map.of("error", "Failed to fetch country data", "details", e.getMessage()));
                });
    }
}