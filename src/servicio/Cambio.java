package servicio;

import lectura.Scanner;
import modelo.TipoCambio;
import repositorio.ConsultaAPI;

public class Cambio {

    private java.util.Scanner sc;
    private TipoCambio tipoDeCambio;
    private ConsultaAPI baseDeDato;

    public Cambio(TipoCambio tipoDeCambio) {
        this.sc = Scanner.getInstance();
        this.tipoDeCambio = tipoDeCambio;
        this.baseDeDato = new ConsultaAPI();
    }

    public void listaDeMonedas() {
        for (String moneda : tipoDeCambio.getResults().keySet()) {
            System.out.println(" --- ");
            System.out.println(moneda);
        }
    }

    public void calculoDeMoneda() {
        double buscarValores;
        double calculo;
        String monedaInicial;
        String monedaFinal;

        do {
            System.out.println(".......................");
            System.out.println("Ingrese la moneda de origen (ejemplo: CLP):");
            monedaInicial = sc.nextLine().toUpperCase();
            if (monedaInicial.length() != 3) {
                System.out.println(" Código de moneda inválido. Debe tener solo 3 letras.");
            }
        } while (monedaInicial.length() != 3);


        do {
            System.out.println(".......................");
            System.out.println("Ingrese la moneda destino (ejemplo: USD):");
            monedaFinal = sc.nextLine().toUpperCase();
            if (monedaFinal.length() != 3) {
                System.out.println("Código de moneda inválido. Debe tener solo 3 letras.");
            }
        } while (monedaFinal.length() != 3);

        System.out.println("Cantidad a convertir:");
        double cantidad = sc.nextDouble();
        sc.nextLine();

        buscarValores = baseDeDato.consultaBaseDeDato(monedaInicial, monedaFinal);
        calculo = buscarValores * cantidad;
        System.out.println(".......................");
        System.out.println(cantidad + " " + monedaInicial + " = " + calculo + " " + monedaFinal);
        System.out.println(".......................");
        System.out.println("Tasa aplicada: " + buscarValores + " " + monedaFinal);
        System.out.println(".......................");


    }

}


