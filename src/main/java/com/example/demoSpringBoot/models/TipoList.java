package com.example.demoSpringBoot.models.domain;

import java.util.List;

public class TipoList extends Estructura{

    private List<Empleado> data;

    public List<Empleado> getData() {
        return data;
    }

    public void setData(List<Empleado> data) {
        this.data = data;
    }
}
