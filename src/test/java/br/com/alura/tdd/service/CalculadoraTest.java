package br.com.alura.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    public void somaDeDoisNumerosPositivos() {
        Calculadora calc = new Calculadora();
        int sum = calc.soma(10, 20);
        Assertions.assertEquals(30, sum);
    }

    @Test
    public void deveRetornarUmValorNegativo(){
        Calculadora calc = new Calculadora();
        int subt = calc.subt(20, 10);
        Assertions.assertEquals(10, subt);
    }

}