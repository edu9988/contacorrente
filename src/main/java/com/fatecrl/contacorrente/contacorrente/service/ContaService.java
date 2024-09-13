package com.fatecrl.contacorrente.contacorrente.service;
import com.fatecrl.contacorrente.contacorrente.model.Conta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ContaService{
    private static List<Conta> contas = new ArrayList<Conta>();

    public ContaService(){
	contaFake();
    }

    private void contaFake(){
	Conta conta = new Conta();
	conta.setAgencia(1234);
	conta.setId(1L);
	conta.setNumero("12345");
	conta.setSaldo(1000.0);
	conta.setTitular("Diego Neri");
	contas.add(conta);
    }

    public List<Conta> findAll(){
	return contas;
    }

    public Conta find(Conta conta){
	return contas.stream()
	    .filter( c -> c.equals(conta) )
	    .findFirst().orElse(null);
    }

    public Conta find(Long id){
	return find( new Conta(id) );
    }

    public void create( Conta conta ){
	Long newId = (long) (contas.size()+1);
	conta.setId(newId);
	contas.add( conta );
    }

    public Boolean delete(Long id){
	Conta _conta = this.find(id);
	if(_conta != null){
	    contas.remove( _conta );
	    return true;
	}
	return false;
    }

    public Boolean update( Conta conta ){
	Conta _conta = find( conta );
	if(_conta != null){
	    if( _conta.getAgencia() != null && conta.getAgencia() > 0 )
		_conta.setAgencia( conta.getAgencia() );
	    if( !conta.getNumero().isBlank() )
		_conta.setNumero( conta.getNumero() );
	    if( conta.getSaldo() != null && conta.getSaldo() > 0 )
		_conta.setSaldo( conta.getSaldo() );
	    if( !conta.getTitular().isBlank() )
		_conta.setTitular( conta.getTitular() );
	    return true;
	}
	return false;
    }
}
