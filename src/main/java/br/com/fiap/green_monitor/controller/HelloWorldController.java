package br.com.fiap.green_monitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 */
@RestController
@RequestMapping("/api")
public class HelloWorldController {

  @GetMapping("/hello")
  public String getHelloWorld() {
    return "Hello World!";
  }
}