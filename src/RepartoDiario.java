
import java.util.ArrayList;
import java.util.Scanner;

public class RepartoDiario {


    private String fecha;
    private ArrayList<RemitoVenta> remitosVenta =  new ArrayList<>();
    private double totalReparto;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<RemitoVenta> getRemitosVenta() {
        return remitosVenta;
    }

    public void setRemitosVenta(ArrayList<RemitoVenta> remitosVenta) {
        this.remitosVenta = remitosVenta;
    }

    public void calcularTotalReparto(){
        this.totalReparto = 0;
        for(RemitoVenta v : remitosVenta) this.totalReparto = this.totalReparto + v.getTotalVenta();

    }

    public void cargarRepartoDiario(){
        System.out.println("ingrese la fecha del reparto");
        Scanner sc = new Scanner(System.in);
        this.fecha = sc.nextLine().trim();
        while(true){
            RemitoVenta r = new RemitoVenta();
            r.generarRemitoDeVenta();
            this.remitosVenta.add(r);
            System.out.println("Desea agregar otro remito? 1.si 2.no");
            int opcion = sc.nextInt();
            if(opcion == 2){
                break;
            }else if(opcion >2 || opcion < 1){
                System.out.println("Opcion Incorrecta");
            }
        }
        calcularTotalReparto();

    }

    public void mostrarRepartoDiario(){
        System.out.println("******************************************************");
        System.out.println("REPARTO DIARIO");
        System.out.println("FECHA DE REPARTO: " + fecha );
        System.out.println("***************** Remitos de Reparto *****************");
        this.remitosVenta.forEach(RemitoVenta::mostrarRemito);
        System.out.println("Total del reparto diario: " + totalReparto);



    }




}
