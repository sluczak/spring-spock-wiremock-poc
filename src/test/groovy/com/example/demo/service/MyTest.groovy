package com.example.demo.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MyTest extends Specification {

    @Rule
    WireMockRule wireMockRule = new WireMockRule(9005)

    @Autowired
    protected MyService underTest

    @Autowired
    ObjectMapper objectMapper

    def 'should work'() {
        given:
        def a = 2
        def b = 4

        when:
        def c = a + b

        then:
        c == 6
    }

    def 'should return hello'() {
        when:
        def result = underTest.get()

        then:
        result.containsAll("Hello", "Def")
    }
}