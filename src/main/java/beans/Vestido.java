
package beans;

public class Vestido {
    private int id;
    private String tipo;
    private String color;
    private String disenador;
    private int cantidad;
    private String talla;
    private int anio_modelo;
    private boolean novedad;
    private double precio;

    public Vestido(int id, String tipo, String color, String disenador, int cantidad, String talla, int anio_modelo, boolean novedad, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.color = color;
        this.disenador = disenador;
        this.cantidad = cantidad;
        this.talla = talla;
        this.anio_modelo = anio_modelo;
        this.novedad = novedad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDisenador() {
        return disenador;
    }

    public void setDisenador(String disenador) {
        this.disenador = disenador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getAnio_modelo() {
        return anio_modelo;
    }

    public void setAnio_modelo(int anio_modelo) {
        this.anio_modelo = anio_modelo;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }
    
    public boolean isPrecio() {
        return novedad;
    }

    public void isPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vestidos{" + "id=" + id + ", tipo=" + tipo + ", color=" + color + ", disenador=" + disenador + ", cantidad=" + cantidad + ", talla=" + talla + ", anio_modelo=" + anio_modelo + ", novedad=" + novedad + ", precio = "+ precio +'}';
    }
    
    
}
