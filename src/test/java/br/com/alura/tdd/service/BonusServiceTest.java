package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void calcBonusZeroParaFuncComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    void calcBonusZeroParaFuncComSalarioMuitoAlto2() {
        BonusService bonusService = new BonusService();
        try {
            bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000")));
            fail("Not be exception");
        }catch (IllegalArgumentException e){
            assertEquals("Bonus fora do escopo de reajuste salario.", e.getMessage());
        }
    }

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalarioDe10000Reais() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}