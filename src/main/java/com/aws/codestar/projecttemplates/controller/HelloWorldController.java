package com.aws.codestar.projecttemplates.controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {

    private static final String PLAIN_MESSAGE_FORMAT = "%s";

    private static final String HELLO_MESSAGE_FORMAT = "Hello from robert, %s!";

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity helloWorldGet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok(createResponse(HELLO_MESSAGE_FORMAT, name));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity helloWorldPost(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok(createResponse(HELLO_MESSAGE_FORMAT, name));
    }

    @GetMapping(value = "ping", produces = "application/json")
    public ResponseEntity ping() {
        return ResponseEntity.ok(createResponse(PLAIN_MESSAGE_FORMAT, "pong"));
    }

    @GetMapping(value = "how-are-you", produces = "application/json")
    public ResponseEntity howAreYou() {
        return ResponseEntity.ok(createResponse(PLAIN_MESSAGE_FORMAT, "Good thanks. How are you?"));
    }

    // for test aws code build

    private String createResponse(String format, String name) {
        return new JSONObject().put("Output", String.format(format, name)).toString();
    }
}