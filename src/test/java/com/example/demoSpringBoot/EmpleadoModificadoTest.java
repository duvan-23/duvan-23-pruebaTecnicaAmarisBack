package com.example.demoSpringBoot;

import com.example.demoSpringBoot.models.EmpleadoModificado;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class EmpleadoModificadoTest {
    @Test
    public void testCalculoSalario() {
        EmpleadoModificado calculo = new EmpleadoModificado();
        calculo.setEmployee_anual_salary(2000);
        Assert.assertEquals(24000, calculo.getEmployee_anual_salary());
    }
    @Test
    public void testCalculoSalarioNegativo() {
        EmpleadoModificado  calculo = new EmpleadoModificado();
        calculo.setEmployee_anual_salary(-2000);
        Assert.assertEquals(24000, calculo.getEmployee_anual_salary());
    }
}
