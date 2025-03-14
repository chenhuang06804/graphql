package com.dyn.graph;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class GraphQLService {

    private final GraphQlClient graphQlClient;

    public GraphQLService(GraphQlClient graphQlClient) {
        this.graphQlClient = graphQlClient;
    }

    public Mono<Map<String, Object>> getCountryByCode(String countryCode) {
        String query = """
            query getCountry($code: ID!) {
                country(code: $code) {
                    name
                    capital
                    currency
                    languages {
                        name
                    }
                }
            }
        """;

        return graphQlClient.document(query)
                .variable("code", countryCode)
                .retrieve("country")
                .toEntity(new ParameterizedTypeReference<Map<String, Object>>() {}); // Fix applied
    }
}