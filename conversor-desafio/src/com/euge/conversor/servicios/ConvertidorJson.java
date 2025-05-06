package com.euge.conversor.servicios;

import com.euge.conversor.modelos.Conversion;
import com.google.gson.Gson;

public class ConvertidorJson {
    public static Conversion convertirAJson(String json){
        return new Gson().fromJson(json, Conversion.class);
    }
}
