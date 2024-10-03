package com.fatecrl.contacorrente.contacorrente.model;

import java.io.Serializable;

public class Conta implements Serializable{
    private Long id;
    private Integer agencia;
    private String numero;
    private String titular;
    private Double saldo;

    public Conta(){
    }

    public Conta( Long id ){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public Integer getAgencia(){
        return agencia;
    }

    public String getNumero(){
        return numero;
    }

    public String getTitular(){
        return titular;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void setId( Long id ){
        this.id = id;
    }

    public void setAgencia( Integer agencia ){
        this.agencia = agencia;
    }

    public void setNumero( String numero ){
        this.numero = numero;
    }

    public void setTitular( String titular ){
        this.titular = titular;
    }

    public void setSaldo( Double saldo ){
        this.saldo = saldo;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result+( (id == null)? 0 : id.hashCode() );
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if( this == obj )
            return true;
        if(obj == null )
            return false;
        if(getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if(id == null){
            if(other.id != null)
            return false;
        }
        else if( !id.equals(other.id) )
            return false;
        return true;
    }
}
