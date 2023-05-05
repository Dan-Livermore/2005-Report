package com.example.COMP2005Report;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class MainController {
    public MainController() {
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

