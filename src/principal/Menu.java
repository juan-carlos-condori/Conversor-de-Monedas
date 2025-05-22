package principal;

import lectura.Scanner;
import modelo.TipoCambio;
import repositorio.ConsultaAPI;
import servicio.Cambio;

public class Menu {
    private ConsultaAPI consulta;
    private java.util.Scanner sc;
    private Cambio tipoDeCambio;

    public Menu(ConsultaAPI consulta) {
        this.consulta = consulta;
        this.sc = Scanner.getInstance();
    }


    public void Menu() {
        TipoCambio datos = null;
        int numero;

        try {
            datos = consulta.tipoDeMoneda();
        } catch (Exception e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
            return;
        }

        tipoDeCambio = new Cambio(datos);


        String mensajeBienvenida = """
                
                            Bienvenido al tipo de cambio de moneda
                """;
        String mensajeOpciones= """
                1. Lista de tipos de moneda en la bolsa
                2. Realizar calculo de una moneda con respecto a otra moneda.
                3. salir
                """;
        String mensaje = """
                -----------------------------------
                   Ingrese un número entre 1 al 3.
                -----------------------------------
                """;

        String mensajeFin = """
                ------------------------
                    Hasta luego.
                ------------------------
                """;
        System.out.println(mensajeBienvenida);

        do {
            System.out.println(mensajeOpciones);
            numero = sc.nextInt();
            sc.nextLine();
            switch (numero) {
                case 1:
                    tipoDeCambio.listaDeMonedas();
                    break;
                case 2:tipoDeCambio.calculoDeMoneda();
                    break;
                case 3:
                    System.out.println(mensajeFin);
                    break;
                default:
                    System.out.println(mensaje);
            }

        } while (3 != numero);
        sc.close();
    }
}
