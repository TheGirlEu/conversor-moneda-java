package com.euge.conversor.modelos;

import com.euge.conversor.servicios.ClienteHttp;
import com.euge.conversor.servicios.ConvertidorJson;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void ejecutarMenu() {
        Scanner teclado = new Scanner(System.in);
        String opcion = "1";

        while (opcion.equals("1")) {
            System.out.println("""
                        --------------------------------------------------------------------------------------------------------------
                    
                        Bienvenidos al conversor de divisas, Por favor checa las opciones disponibles ¡Y convierte a la moneda de preferencia!
                    
                        --------------------------------------------------------------------------------------------------------------

                        1 -> Dólar americano (USD)
                        2 -> Dólar canadiense (CAD)
                        3 -> Peso chileno (CLP)
                        4 -> Peso argentino (ARS)
                        5 -> Real brasileño (BRL)
                        6 -> Peso colombiano (COP)
                        7 -> Euro (EUR)
                        8 -> Sol Peruano (PEN)
                        9 -> Peso mexicano (MXN)
                        10 -> Libra esterlina (GBP)

                        ------------------------------

                    """);

            try {

                // input de datos requeridos
                System.out.print("Elija la divisa de origen: ");
                int inputOrigen = teclado.nextInt();
                String divisaOrigen = Divisa.buscarDivisa(inputOrigen);
                System.out.print("Elija la divisa a la que se convertirá: ");
                int inputDestino = teclado.nextInt();
                String divisaDestino = Divisa.buscarDivisa(inputDestino);
                System.out.print("Ahora indica la cantidad que deseas convertir, por favor: ");
                double cantidadOrigen = teclado.nextDouble();

                // peticion a api
                ClienteHttp clienteHttp = new ClienteHttp(divisaOrigen, divisaDestino, cantidadOrigen);
                String respuesta = clienteHttp.getRequest();

                // Convertir json a record
                Conversion conversion = ConvertidorJson.convertirAJson(respuesta);
                conversion.mostrarResultado(cantidadOrigen);

            } catch (InputMismatchException e) {
                System.out.println("----------------------------------\n");
                System.out.println("La opción ingresada no es válida :(");
                System.out.println("----------------------------------\n");

            } catch (IOException | InterruptedException e) {
                System.out.println("----------------------------------\n");
                System.out.println(e.getMessage());
                System.out.println("----------------------------------\n");

            } catch (Exception e) {
                System.out.println("----------------------------------\n");
                System.out.println("Hubo un problema :( : ");
                System.out.println(e.getMessage());
                System.out.println("----------------------------------\n");

            }

            System.out.print("""
                    -----------------------------------------------
                    REALIZAR NUEVA CONSULTA -> PRESIONA 1 Y ENTER

                    FINALIZAR PROGRAMA -> PRESIONA ENTER (2 veces)
                    -----------------------------------------------

                    """);

            teclado.nextLine();
            opcion = teclado.nextLine();

            if (!opcion.equals("1")) {
                teclado.close();
            }

        }

    }

}
