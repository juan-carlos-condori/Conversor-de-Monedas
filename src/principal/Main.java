package principal;

import repositorio.ConsultaAPI;

public class Main {
    public static void main(String[] args) {
        ConsultaAPI consulta = new ConsultaAPI();
        Menu incio = new Menu(consulta);
        incio.Menu();
    }
}