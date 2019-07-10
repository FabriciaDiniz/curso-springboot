package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	public String hello() {
		return "Hello World";
	}
	
}
