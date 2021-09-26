package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService bonusService;
    private Funcionario funcionario;
    private BigDecimal bonus;

    @BeforeEach
    void setup(){
        bonusService = new BonusService();
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000"));
        bonus = bonusService.calcularBonus(funcionario);
    }

    @Test
    void calcBonusZeroParaFuncComSalarioMuitoAlto() {
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    void calcBonusZeroParaFuncComSalarioMuitoAlto2() {
        try {
            bonusService.calcularBonus(funcionario);
            fail("Not be exception");
        }catch (IllegalArgumentException e){
            assertEquals("Bonus fora do escopo de reajuste salario.", e.getMessage());
        }
    }

    //todo continuar daq 
    @Test
    void calcBonusDeveriaSer10PorCentoDoSalario() {
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalarioDe10000Reais() {
        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}