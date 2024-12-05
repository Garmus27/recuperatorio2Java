import java.util.ArrayList;
import java.util.Scanner;

public class Articulo {
    private int codigo;
    private String denominacion;
    private double precio;
    Scanner sc = new Scanner(System.in);


    public Articulo(int codigo, String denominacion, double precio) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Articulo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
