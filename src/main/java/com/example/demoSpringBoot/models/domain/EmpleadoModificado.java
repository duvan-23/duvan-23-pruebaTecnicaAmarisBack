package com.example.demoSpringBoot.models.domain;

public class EmpleadoModificado extends Empleado{

    private int employee_anual_salary;

    public int getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(int employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary * 12;
    }
}
