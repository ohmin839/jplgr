package com.ohmin839.jplgr.web.api.presentation.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohmin839.jplgr.api.JplgrApi;

@RestController
@RequestMapping(value = "/text")
public class TextController {
    @RequestMapping(value = "/constant",
        method = RequestMethod.GET,
        produces = "text/plain;charset=UTF-8")
    public String constant() {
        return JplgrApi.toPolytonicText(">'anthr^opos");
    }

    @RequestMapping(value = "/convert/string", method = RequestMethod.POST,
        consumes = "text/plain;charset=UTF-8",
        produces = "text/plain;charset=UTF-8")
    public String convertString(@RequestBody String text) {
        return JplgrApi.toPolytonicText(text);
    }
}
