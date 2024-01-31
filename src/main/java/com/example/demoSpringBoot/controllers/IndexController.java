package com.example.demoSpringBoot.controllers;

import com.example.demoSpringBoot.models.Empleado;
import com.example.demoSpringBoot.models.EmpleadoModificado;
import com.example.demoSpringBoot.models.TipoList;
import com.example.demoSpringBoot.models.TipoObject;
import com.example.demoSpringBoot.service.EmpleadosApi;
import com.example.demoSpringBoot.util.ModificarEmpleado;
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
    public List<EmpleadoModificado> empleados(){
        TipoList response = servicio.empleados();
        List<EmpleadoModificado> modifiedEmployeeList = new ArrayList<>();
        if (response != null) {
            ModificarEmpleado helper = new ModificarEmpleado();
            modifiedEmployeeList = helper.modificar(response.getData());
        }
        return modifiedEmployeeList;
    }
    @GetMapping("/{num}")
    public List<EmpleadoModificado> empleado(@PathVariable Integer num){
        TipoObject response = servicio.empleado(num);
        List<EmpleadoModificado> modifiedEmployeeList = new ArrayList<>();
        if (response != null) {
            Empleado employee = response.getData();
            if(employee!= null) {
                List<Empleado> ma = new ArrayList<>();
                ma.add(employee);
                ModificarEmpleado helper = new ModificarEmpleado();
                modifiedEmployeeList = helper.modificar(ma);
            }
        }
        return modifiedEmployeeList;
    }
}
