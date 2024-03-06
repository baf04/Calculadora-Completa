package Modelo;

import static java.lang.Math.sqrt;

public class Model {

    private static final Model data  = new Model();

    private String primernumero;
    private String operador;
    private String numeroActual;
    private String mem;
    private double res;

    public static Model getInstance(){
        return data;
    }

    public String getPrimernumero() {
        return primernumero;
    }

    public void setPrimernumero(String primernumero) {
        this.primernumero = primernumero;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(String numeroActual) {
        this.numeroActual = numeroActual;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }
}