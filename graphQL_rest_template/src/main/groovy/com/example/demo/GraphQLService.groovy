package com.example.demo

import org.springframework.graphql.client.GraphQlClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class GraphQLService {

//    private final GraphQlClient graphQlClient

//    GraphQLService(GraphQlClient.Builder graphQlClientBuilder) {
//        this.graphQlClient = graphQlClientBuilder
//                .url("https://countries.trevorblades.com/")
//                .build()
//    }
//
//    Mono<Map> getCountryByCode(String code) {
//        String query = """
//            query getCountry(\$countryCode: ID!) {
//                country(code: \$countryCode) {
//                    name
//                    capital
//                    currency
//                    languages {
//                        name
//                    }
//                }
//            }
//        """.stripIndent()
//
//        return graphQlClient.document(query)
//                .variable("countryCode", code)
//                .retrieve("data.country")
//                .toEntity(Map)
//    }
}
