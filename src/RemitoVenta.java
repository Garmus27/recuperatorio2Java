import java.util.ArrayList;
import java.util.Scanner;

public class RemitoVenta {

    private String nombrecliente;
    private long numeroRemito;
    private ArrayList<RemitoVentaDetalle> detallesRemito= new ArrayList<>();
    private double totalVenta;
    Scanner sc = new Scanner(System.in);

    public RemitoVenta() {
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public long getNumeroRemito() {
        return numeroRemito;
    }

    public void setNumeroRemito(long numeroRemito) {
        this.numeroRemito = numeroRemito;
    }

    public ArrayList<RemitoVentaDetalle> getDetallesRemito() {
        return detallesRemito;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public void setDetallesRemito(ArrayList<RemitoVentaDetalle> detallesRemito) {
        this.detallesRemito = detallesRemito;
    }

    public void ingresarNombre(){
        System.out.println("Por favor ingrese nombre del cliente");
        String nombre = sc.nextLine().trim();
        setNombrecliente(nombre);
        if(this.nombrecliente.isEmpty()){
            System.out.println("El nombre del cliente no puede quedar en blanco");
            ingresarNombre();
        }
    }

    public void ingresarNumeroDeRemito(){
        System.out.println("Por favor ingrese numero de remito");
        String numero = sc.nextLine().trim();
        setNumeroRemito(Long.parseLong(numero));
        if(this.numeroRemito < 0||numero.isEmpty()){
            System.out.println("El numero de remito no puede ser negativo, nullo ni puede quedar en blanco");
            ingresarNumeroDeRemito();
        }
    }

    public void calcularTotalDeVentas(){

        double sumaTotal = 0;
        for(RemitoVentaDetalle remitoVentaDetalle : this.detallesRemito)  sumaTotal=sumaTotal + remitoVentaDetalle.getSubTotal();
        this.totalVenta=sumaTotal;

    }

    public void generarRemitoDeVenta(){

        RemitoVentaDetalle remitoDetalle = new RemitoVentaDetalle();

        this.ingresarNombre();
        this.ingresarNumeroDeRemito();
        this.setDetallesRemito(remitoDetalle.generarDetalleDeRemito());


    }

    public void mostrarRemito(){

        System.out.println("Nombre cliente: " + getNombrecliente());
        System.out.println("Numero de remito: " + getNumeroRemito());
        System.out.printf("%-10s %-30s %-10s %-15s %-15s%n", "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "SUBTOTAL");
        for (RemitoVentaDetalle detalles : this.detallesRemito) {
            System.out.printf("%-10s %-30s %-10s %-15.2f %-15.2f%n", detalles.getArticulo().getCodigo(), detalles.getArticulo().getDenominacion(), detalles.getCantidad(), detalles.getArticulo().getPrecio(), detalles.getSubTotal());
        }

        System.out.printf("%-10s %-30s %-10s %-15s %-15.2f%n", "", "", "", "TOTAL", this.totalVenta);

        System.out.println("********************************************************************************************");



    }







}
