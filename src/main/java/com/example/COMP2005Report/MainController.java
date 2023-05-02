package com.example.COMP2005Report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class MainController {
    @GetMapping("/")
    String index() {
        return "hi";
    }
}

/*    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<String>> search(@RequestParam parameter1, @RequestParam parameter2) {
        "paths": {
            "/search": {
                "get": {
                    "consumes": [],
                    "produces": [
                    "application/json"
            ],
                    "parameters": [
                    // What goes here?
            ],
                    "responses": {
                        "200": {
                            "description": "Success",
                                    "schema": {
                                "$ref": "#/definitions/SearchResponse"
                            }
                        },
                    }
                }
            }
        }
...
    }*/

