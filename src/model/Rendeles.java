/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

/**
 *
 * @author Pepe
 */
public class Rendeles implements Serializable {
    private int id;
    private int rendeloid;
    private String osszeg;
    private String darbszam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRendeloid() {
        return rendeloid;
    }

    public void setRendeloid(int rendeloid) {
        this.rendeloid = rendeloid;
    }

    public String getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(String osszeg) {
        this.osszeg = osszeg;
    }

    public String getDarbszam() {
        return darbszam;
    }

    public void setDarbszam(String darbszam) {
        this.darbszam = darbszam;
    }

    public Rendeles(int id, int rendeloid, String osszeg, String darbszam) {
        this.id = id;
        this.rendeloid = rendeloid;
        this.osszeg = osszeg;
        this.darbszam = darbszam;
    }

    public Rendeles(int rendeloid, String osszeg, String darbszam) {
        this.rendeloid = rendeloid;
        this.osszeg = osszeg;
        this.darbszam = darbszam;
    }

    public Rendeles() {
    }

    @Override
    public String toString() {
        return "Rendelés összege: " + osszeg + ", rendelések száma: " + darbszam;
    }
    
}
