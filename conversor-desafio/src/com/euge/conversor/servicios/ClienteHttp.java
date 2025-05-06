package com.euge.conversor.servicios;

import com.euge.conversor.ConfigLoader;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class ClienteHttp {

    String API_KEY;
    String url;
    HttpClient cliente;
    HttpRequest peticion;

    public ClienteHttp(String origen, String destino, double cantidad){
        //Obtenemos API
        API_KEY = ConfigLoader.get("API_KEY");

        url = String.format(Locale.US,"https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                API_KEY, origen, destino, cantidad);
        this.cliente = HttpClient.newHttpClient();
        this.peticion = HttpRequest.newBuilder().uri(URI.create(this.url)).build();

    }

    public String getRequest() throws IOException, InterruptedException {
        HttpResponse<String> respuesta = this.cliente.send(this.peticion,
                HttpResponse.BodyHandlers.ofString());

        return respuesta.body();
    }
}
