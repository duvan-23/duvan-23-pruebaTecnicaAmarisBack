package com.example.demoSpringBoot.controllers;

import com.example.demoSpringBoot.models.domain.*;
import com.example.demoSpringBoot.models.service.EmpleadosApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class IndexController {
    @Autowired
    private EmpleadosApi servicio ;

    @GetMapping("/")
    public List<EmpleadoModificado> index(){
        TipoList response = servicio.empleados();
        List<EmpleadoModificado> modifiedEmployeeList = new ArrayList<>();
        if (response != null) {
            List<Empleado> employeeList = response.getData();

            for (Empleado employeeData : employeeList) {
                EmpleadoModificado modifiedEmployee = new EmpleadoModificado();
                modifiedEmployee.setId(employeeData.getId());
                modifiedEmployee.setEmployee_name(employeeData.getEmployee_name());
                modifiedEmployee.setEmployee_salary(employeeData.getEmployee_salary());
                modifiedEmployee.setEmployee_age(employeeData.getEmployee_age());
                modifiedEmployee.setProfile_image(employeeData.getProfile_image());
                modifiedEmployee.setEmployee_anual_salary(employeeData.getEmployee_salary());
                modifiedEmployeeList.add(modifiedEmployee);
            }
        }
        return modifiedEmployeeList;
    }
    @GetMapping("/{num}")
    public List<EmpleadoModificado> index2(@PathVariable Integer num){
        TipoObject response = servicio.empleado(num);
        List<EmpleadoModificado> modifiedEmployeeList = new ArrayList<>();
        if (response != null) {
            Empleado employee = response.getData();
            if(employee!= null) {
                EmpleadoModificado modifiedEmployee = new EmpleadoModificado();
                modifiedEmployee.setId(employee.getId());
                modifiedEmployee.setEmployee_name(employee.getEmployee_name());
                modifiedEmployee.setEmployee_salary(employee.getEmployee_salary());
                modifiedEmployee.setEmployee_age(employee.getEmployee_age());
                modifiedEmployee.setProfile_image(employee.getProfile_image());
                modifiedEmployee.setEmployee_anual_salary(employee.getEmployee_salary());
                modifiedEmployeeList.add(modifiedEmployee);
            }
        }
        return modifiedEmployeeList;
    }
}
