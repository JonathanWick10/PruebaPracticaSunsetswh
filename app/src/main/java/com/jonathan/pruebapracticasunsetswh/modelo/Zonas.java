package com.jonathan.pruebapracticasunsetswh.modelo;

import com.orm.SugarRecord;

import java.util.List;

public class Zonas extends SugarRecord {
    private long idStation;
    private  String name;
    private String desc;

    public Zonas() {
    }

    public Zonas(long idStation, String name, String desc) {
        this.idStation = idStation;
        this.name = name;
        this.desc = desc;
    }

    public long getIdStation() {
        return idStation;
    }

    public void setIdStation(long idStation) {
        this.idStation = idStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
