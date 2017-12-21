package com.sandeep.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.ScenarioMappingBuilder;
import com.github.tomakehurst.wiremock.global.GlobalSettings;
import com.github.tomakehurst.wiremock.matching.ContentPattern;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by mahantys on 20/12/17.
 */
@Controller
public class DefaultController {
    public static final String BASE_PATH = "html/";
    @Autowired
    WireMockServer wireMockServer;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        wireMockServer.start();
        return "index.html";
    }

    @RequestMapping(value = "/stop")
    @ResponseBody
    public String stopServer() {
        wireMockServer.stop();
        return "Server stopped";
    }
}
