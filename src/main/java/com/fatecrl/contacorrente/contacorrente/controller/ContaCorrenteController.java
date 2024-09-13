package com.fatecrl.contacorrente.contacorrente.controller;

import java.util.List;

import com.fatecrl.contacorrente.contacorrente.model.Conta;
import com.fatecrl.contacorrente.contacorrente.service.ContaService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController{

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getAll(){
	return ResponseEntity.ok(contaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> get( @PathVariable("id") Long id){
	Conta conta = contaService.find(id);

	if( conta != null ){
	    return ResponseEntity.ok(conta);
	}

	return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Conta> create( @RequestBody Conta conta ){
	contaService.create( conta );
	URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(conta.getId())
			.toUri();
	return ResponseEntity.created(location).body(conta);
    }

    @PutMapping
    public ResponseEntity<Conta> update( @RequestBody Conta conta ){
	if( contaService.update(conta) )
	    return ResponseEntity.ok(conta);

	return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete( @PathVariable("id") Long id ){
	if( contaService.delete(id) )
	    return ResponseEntity.noContent().build();

	return ResponseEntity.notFound().build();
    }
}
