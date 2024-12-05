import java.util.ArrayList;
import java.util.Scanner;

public class CrearRepartoDiario {

    Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        RepartoDiario repartoDiario = new RepartoDiario();
        System.out.println("Benvenutti, vamos a crear un reparto diario");
        System.out.println("Comenzaremos por indicar la fecha del reparto");
        repartoDiario.cargarRepartoDiario();
        repartoDiario.calcularTotalReparto();
        repartoDiario.mostrarRepartoDiario();

    }

}
