package com.fatecrl.contacorrente.contacorrente.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController{

    @GetMapping("/get")
    public String getAll(){
	return "content";
    }

    /*
    @GetMapping("/get/{id}")
    public String get( @PathVariable("id") Long id ){
	return "content";
    }
    */
}
