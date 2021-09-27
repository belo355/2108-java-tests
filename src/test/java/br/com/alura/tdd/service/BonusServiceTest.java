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
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("0"));
        bonus = bonusService.calcularBonus(funcionario);
    }

    @Test
    void calcBonusZeroParaFuncComSalarioMuitoAlto() {
        funcionario.setSalario(new BigDecimal("30000"));
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario),
                "Bonus fora do escopo de reajuste salario, valor bonus base maior que 1000");
    }

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalario() {
        funcionario.setSalario(new BigDecimal("2500"));
        assertEquals(new BigDecimal("250.0"), bonusService.calcularBonus(funcionario));
    }

    @Test
    void calcBonusDeveriaSer10PorCentoDoSalarioDe10000Reais() {
        funcionario.setSalario(new BigDecimal("1000"));
        assertEquals(new BigDecimal("100.0"), bonusService.calcularBonus(funcionario));
    }
}