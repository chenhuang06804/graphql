package com.example.demo

import groovy.json.JsonOutput
import groovy.util.logging.Slf4j
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@Slf4j
@RestController
@RequestMapping("/graphql")
class GraphQLController {

    private final String GRAPHQL_URL = "https://countries.trevorblades.com/"

    @GetMapping("/country/{code}")
    String getCountryInfo(@PathVariable(value ="code") String code) {
        def query = [
                query: """
                query {
                  country(code: "${code}") {
                    name
                    native
                    capital
                    currency
                    languages {
                      name
                    }
                  }
                }
            """
        ]

        // Convert Map to JSON String
        def requestBody = JsonOutput.toJson(query)

        // Prepare headers
        def headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)

        // Make request
        def restTemplate = new RestTemplate()
        def requestEntity = new HttpEntity<>(requestBody, headers)
        def response = restTemplate.exchange(GRAPHQL_URL, HttpMethod.POST, requestEntity, Map)

        log.info("response: ${response}")

        return response.body
    }

}