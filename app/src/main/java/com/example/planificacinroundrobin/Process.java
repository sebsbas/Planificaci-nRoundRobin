package com.example.planificacinroundrobin;

public class Process {
    String name, tRaf, tInit, tFinal;

    public Process(String name, String tRaf, String tInit, String tFinal) {
        this.name = name;
        this.tRaf = tRaf;
        this.tInit = tInit;
        this.tFinal = tFinal;
    }

    public Process() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gettRaf() {
        return tRaf;
    }

    public void settRaf(String tRaf) {
        this.tRaf = tRaf;
    }

    public String gettInit() {
        return tInit;
    }

    public void settInit(String tInit) {
        this.tInit = tInit;
    }

    public String gettFinal() {
        return tFinal;
    }

    public void settFinal(String tFinal) {
        this.tFinal = tFinal;
    }

    @Override
    public String toString() {
        return name + "  " + tRaf + "  " + tInit + "  " + tFinal;
    }
}
