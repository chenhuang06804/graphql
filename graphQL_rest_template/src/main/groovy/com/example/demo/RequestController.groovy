package com.example.demo


import groovy.util.logging.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
class RequestController {
    @RequestMapping(value = 'hello', method = RequestMethod.GET)
    ResponseEntity<?> hello() {
        return ResponseEntity.ok('got it' )
    }
}
