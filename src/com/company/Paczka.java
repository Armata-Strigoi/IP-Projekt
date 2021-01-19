package com.company;


import java.util.Date;

public class Paczka {
    int numer_statusu,nr_ulica_o,nr_dom_o,nr_ulica_n,nr_dom_n,id_kuriera;
    float wysokosc,szerokosc,glebokosc,waga,kubatura;
    String idPaczki,status,ulica_o,nr_tel_o,ulica_n,nr_tel_n;
    Date data_nadania,data_dostarczenia;

    Paczka(
            String idPaczki,float wysokosc, float szerokosc, float glebokosc, float waga, String ulica_o,
            int nr_ulica_o, int nr_dom_o, String nr_tel_o,String ulica_n, int nr_ulica_n, int nr_dom_n, String nr_tel_n
    ){

        this.idPaczki = idPaczki;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.glebokosc = glebokosc;
        this.waga = waga;
        this.kubatura = ObliczKubature();
        this.numer_statusu = 0;
        this.status = "Nadana";
        this.id_kuriera = -1; // Zaden kurier nie dostarczyl jeszcze paczki

        this.nr_ulica_n = nr_ulica_n;
        this.nr_ulica_o = nr_ulica_o;
        this.nr_dom_n = nr_dom_n;
        this.nr_dom_o = nr_dom_o;
        this.nr_tel_n = nr_tel_n;
        this.nr_tel_o = nr_tel_o;
        this.ulica_n = ulica_n;
        this.ulica_o = ulica_o;
        this.data_nadania = new java.util.Date();
        this.data_dostarczenia = null;
    }

    Paczka(
           String idPaczki,int status,float wysokosc, float szerokosc, float glebokosc, float waga, float kubatura,
           Date data_nadania, Date data_dostarczenia, String ulica_o, int nr_ulica_o, int nr_dom_o,
           String nr_tel_o,String ulica_n, int nr_ulica_n, int nr_dom_n, String nr_tel_n
    ){

        this.idPaczki = idPaczki;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.glebokosc = glebokosc;
        this.waga = waga;
        this.kubatura = kubatura;
        this.numer_statusu = status;
        this.UstawStatus();
        this.id_kuriera = -1; // Zaden kurier nie dostarczyl jeszcze paczki

        this.nr_dom_o = nr_dom_o;
        this.nr_tel_n = nr_tel_n;
        this.nr_tel_o = nr_tel_o;
        this.ulica_o = ulica_o;
        this.data_nadania = data_nadania;
        this.data_dostarczenia = data_dostarczenia;
    }

    private float ObliczKubature(){
        return this.wysokosc * this.szerokosc * this.glebokosc;
    }

    public int ZaktualizujStatus() {
        this.numer_statusu++;
        if(this.numer_statusu == 1) {
            this.status = "Przekazana do doreczenia";
        }else if(this.numer_statusu == 2){
            this.status = "Doreczono";
        }else if(this.numer_statusu > 2) this.numer_statusu = 2;
        return this.numer_statusu;
    }

    public void UstawStatus() {
        if(this.numer_statusu == 0) {
            this.status = "Nadana";
        }else if(this.numer_statusu == 1){
            this.status = "Przekazana do doreczenia";
        }
        else if(this.numer_statusu == 2) {
            this.status = "Doreczono";
        }
    }

    public Date Dostarcz(int id_kuriera){
        this.id_kuriera = id_kuriera;
        this.data_dostarczenia = new java.util.Date();
        ZaktualizujStatus();
        return this.data_dostarczenia;
    }

    public void CofnijStatus(){ // Jesli nie udalo sie dostarczyc przesylki to wraca do magazuny
        this.numer_statusu = 0;
        this.status = "Nadana";
    }


}
