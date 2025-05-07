/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Nahuel Paroldo
 * @author Jonathan Garcia
 */
public class Config {

    private boolean requiereContacto = false;
    private boolean largoFijo = true;
    private int largoDefault = 4;
    private int minLargo = 1;
    private int maxLargo = 4;
    private int maximoBandas = 10;
    private int numTableros = 1;

    public boolean isRequiereContacto() {
        return requiereContacto;
    }

    public void setRequiereContacto(boolean c) {
        this.requiereContacto = c;
    }

    public boolean isLargoFijo() {
        return largoFijo;
    }

    public void setLargoFijo(boolean fijo) {
        this.largoFijo = fijo;
    }

    public int getLargoDefault() {
        return largoDefault;
    }

    public void setLargoDefault(int d) {
        this.largoDefault = d;
    }

    public int getMinLargo() {
        return minLargo;
    }

    public int getMaxLargo() {
        return maxLargo;
    }

    public void setRangoLargo(int min, int max) {
        this.minLargo = min;
        this.maxLargo = max;
    }

    public int getMaximoBandas() {
        return maximoBandas;
    }

    public void setMaxBandas(int m) {
        this.maximoBandas = m;
    }

    public int getNumTableros() {
        return numTableros;
    }

    public void setNumTableros(int n) {
        this.numTableros = n;
    }

    public void valoresIniciales() {
        requiereContacto = false;
        largoFijo = true;
        largoDefault = 4;
        minLargo = 1;
        maxLargo = 4;
        maximoBandas = 10;
        numTableros = 1;
    }
}

