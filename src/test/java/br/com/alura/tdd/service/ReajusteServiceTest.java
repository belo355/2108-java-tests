package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    void setup() {
        service = new ReajusteService();
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoNoStatusADesejar() {
        service.calcReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoNoStatusBom() {
        service.calcReajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoNoStatusMuitoBom() {
        service.calcReajuste(funcionario, Desempenho.MUITO_BOM);
        Assertions.assertEquals(new BigDecimal("1300.00"), funcionario.getSalario());
    }
}
