package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

    @Test
    void calcBonusZeroParaFuncComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000")));
        Assertions.assertEquals(BigDecimal.ZERO, bonus);
}

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("2500")));
        Assertions.assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalarioDe10000Reais() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("10000")));
        Assertions.assertEquals(new BigDecimal("1000.0"), bonus);
    }
}