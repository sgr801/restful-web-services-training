package com.shekh.learning.rest.webservices.restfulwebservices.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

    @GetMapping("/v1/persion")
    public PersonV1 getFirstVersionPersion() {
        return new PersonV1("John Doe");
    }

    @GetMapping("/v2/persion")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Michael", " Jacksion"));
    }
}
