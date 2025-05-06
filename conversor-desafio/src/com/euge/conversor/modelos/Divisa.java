package com.euge.conversor.modelos;

public enum Divisa {
    USD,
    CAD,
    CLP,
    ARS,
    BRL,
    COP,
    EUR,
    PEN,
    MXN,
    GBP;

    public static String[] buscarDivisa(int inputOrigen, int inputDestino) {
        String[] parDeDivisas = new String[2];

        for (Divisa divisa : Divisa.values()) {
            if (inputOrigen == divisa.ordinal() + 1) {
                parDeDivisas[0] = divisa.name();
            }
            if (inputDestino == divisa.ordinal() + 1) {
                parDeDivisas[1] = divisa.name();
            }

        }
        return parDeDivisas;
    }

    public static String buscarDivisa(int valor) {

        String divisa = "";
        switch (valor) {
            case 1:
                divisa = Divisa.USD.name();
                break;
            case 2:
                divisa = Divisa.CAD.name();
                break;
            case 3:
                divisa = Divisa.CLP.name();
                break;
            case 4:
                divisa = Divisa.ARS.name();
                break;
            case 5:
                divisa = Divisa.BRL.name();
                break;
            case 6:
                divisa = Divisa.COP.name();
                break;
            case 7:
                divisa = Divisa.EUR.name();
                break;
            case 8:
                divisa = Divisa.PEN.name();
                break;
            case 9:
                divisa = Divisa.MXN.name();
                break;
            case 10:
                divisa = Divisa.GBP.name();
                break;
            default:
                throw new RuntimeException("El valor ingresado debe estar entre 1 y 10...");

        }

        return divisa;
    }
}
