import java.io.Serializable;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 2L;
    private int idPedido, idCliente,cantidad;
    private String producto;

    public Pedido() {
    }

    public Pedido(int idPedido, int idCliente, int cantidad, String producto) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %d, %s", idPedido, idCliente, cantidad, producto);
    }
}
