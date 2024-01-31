package com.example.demoSpringBoot.util;

import com.example.demoSpringBoot.models.Empleado;
import com.example.demoSpringBoot.models.EmpleadoModificado;

import java.util.ArrayList;
import java.util.List;

public class ModificarEmpleado {
    public List<EmpleadoModificado> modificar(List<Empleado> datos){

        List<EmpleadoModificado> modifiedEmployeeList = new ArrayList<>();
        for (Empleado employeeData : datos) {
            EmpleadoModificado modifiedEmployee = new EmpleadoModificado();
            modifiedEmployee.setId(employeeData.getId());
            modifiedEmployee.setEmployee_name(employeeData.getEmployee_name());
            modifiedEmployee.setEmployee_salary(employeeData.getEmployee_salary());
            modifiedEmployee.setEmployee_age(employeeData.getEmployee_age());
            modifiedEmployee.setProfile_image(employeeData.getProfile_image());
            modifiedEmployee.setEmployee_anual_salary(employeeData.getEmployee_salary());
            modifiedEmployeeList.add(modifiedEmployee);
        }
        return modifiedEmployeeList;
    }
}
