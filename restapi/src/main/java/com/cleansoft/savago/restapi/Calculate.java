package com.cleansoft.savago.restapi;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculate {

    @RequestMapping(value = "/sum", method = RequestMethod.GET, headers = "Accept=application/xml")
    public String sum() {
        return "<?xml version=\"1.0\"?><result>" + 1 + 2 + "</result>";
    }
}
