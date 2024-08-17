package pl.learning.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {
    @GetMapping(value = "/test1")
    public ResponseEntity<String> test1() {
        return ResponseEntity.ok("Success");

    }
}
