import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemitoVentaDetalle {

    private int cantidad;
    private Articulo articulo;
    private double subTotal ;
    Scanner sc = new Scanner(System.in);
    ArrayList<Articulo> articulosDisponibles;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void establecerArticulosDisponibles() {
        ArrayList<Articulo> articulosDisponibles = new ArrayList<Articulo>();
        Articulo art = new Articulo (10, "Filtro de Aceite", 10000);
        articulosDisponibles.add(art);
        art = new Articulo (20, "Filtro de Aire ", 8000);
        articulosDisponibles.add(art);
        art = new Articulo (30, "Filtro de Combustible", 7500);
        articulosDisponibles.add(art);
        art = new Articulo (40, "Aceite de Motor sw/10", 25000);
        articulosDisponibles.add(art);
        art = new Articulo (50, "Correa de Distribución", 20000);
        articulosDisponibles.add(art);
        this.articulosDisponibles = articulosDisponibles;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;

    }

    public void ingresarCantidad(){
        System.out.println("Ingrese la cantidad");
        int cantidad = sc.nextInt();
        if (cantidad < 0){
            System.out.println("El cantidad debe ser mayor que 0 y no puede quedar vacia");
            ingresarCantidad();
        }else {
            this.cantidad = cantidad;
        }
    }

    public void ingresarArticulo(){

        System.out.println("Ingrese el codigo del articulo");
        int codigo = sc.nextInt();
        boolean encontrado = false;
        for(Articulo articulo1 : this.articulosDisponibles){
            if (articulo1.getCodigo() == codigo){
                this.articulo = articulo1;
                encontrado = true;

            }
        }
        if (!encontrado){
            System.out.println("El codigo del articulo es incorrecto o no se encuentra en Stock");
            ingresarArticulo();
        }


    }

    public ArrayList<RemitoVentaDetalle> generarDetalleDeRemito(){

        ArrayList<RemitoVentaDetalle> detalles = new ArrayList<>();

        while(true){
            int opcion = 0;
            RemitoVentaDetalle detalle = new RemitoVentaDetalle();
            detalle.establecerArticulosDisponibles();
            detalle.ingresarArticulo();
            detalle.ingresarCantidad();
            detalle.setSubTotal(detalle.getArticulo().getPrecio() * detalle.getCantidad());
            detalles.add(detalle);

            System.out.println("Desea agregar otro articulo? 1.SI 2.NO");
            opcion = sc.nextInt();
            if (opcion == 2){
                break;
            }

        }
        return detalles;
    }


}

