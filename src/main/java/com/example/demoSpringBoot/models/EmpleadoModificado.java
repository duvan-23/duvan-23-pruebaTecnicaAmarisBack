package com.example.demoSpringBoot.models;

public class EmpleadoModificado extends Empleado{

    private int employee_anual_salary;

    public int getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(int employee_anual_salary) {
        this.employee_anual_salary = Math.abs(employee_anual_salary) * 12;
    }
}
