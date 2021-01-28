package com.company;

public class SharedPaczka {
     //To z bazy trzeba wyciagac jak i reszte w sumie
    float wysokosc,szerokosc,glebokosc,kubatura,koszt;

    public SharedPaczka(float wysokosc, float szerokosc, float glebokosc,float koszt){
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.glebokosc = glebokosc;
        this.koszt = koszt;
        this.kubatura = ObliczKubature();
    }

    public SharedPaczka(float wysokosc, float szerokosc, float glebokosc,float kubatura, float koszt){
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.glebokosc = glebokosc;
        this.koszt = koszt;
        this.kubatura = kubatura;
    }

    private float ObliczKubature(){
        return this.wysokosc * this.szerokosc * this.glebokosc;
    }

    @Override
    public String toString(){
        return "Wymiary: " + this.wysokosc + "x" + this.szerokosc + "x" + this.glebokosc + " KOSZT: " + this.koszt;
    }
}
