package br.com.alura.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setup(){
        calculadora = new Calculadora();
    }

    @Test
    public void somaDeDoisNumerosPositivos() {
        int sum = calculadora.soma(10, 20);
        Assertions.assertEquals(30, sum);
    }

    @Test
    public void deveRetornarUmValorNegativo(){
        int subt = calculadora.subt(20, 10);
        Assertions.assertEquals(10, subt);
    }

}