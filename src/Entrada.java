import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Entrada {
    public static void main(String[] args) {

        //DATOS DE CLIENTE
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1, "Andres Peña", "andres.peña@pedidosya.com"));
        listaClientes.add(new Cliente(2, "Marina Sanz", "marina.sanz@pedidosya.com"));
        listaClientes.add(new Cliente(3, "Claudia Martin", "claudia.martin@pedidosya.com"));
        // DATOS DE PEDIDO
        List<Pedido> listaPedido = new ArrayList<>();
        listaPedido.add(new Pedido(100, 1, 1, "Ordenador"));
        listaPedido.add(new Pedido(115, 1, 2, "Pantalla"));
        listaPedido.add(new Pedido(130, 2, 1, "Teclado"));
        listaPedido.add(new Pedido(145, 2, 1, "Raton"));
        listaPedido.add(new Pedido(160, 3, 1, "Silla ergonomica"));
        listaPedido.add(new Pedido(175, 3, 2, "Cable HDMI"));

        //GENERAR FICHERO:

        //1-CSV
        File file = new File("datos.csv");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file));

            printWriter.println("PEDIDOS:");
            printWriter.println("idCliente, nombre, email");
            for (Cliente cliente : listaClientes) {
                printWriter.println(cliente);
            }
            printWriter.println("\nCLIENTES:");
            printWriter.println("idPedido, idCliente, cantidad, producto");
            for (Pedido pedido : listaPedido) {
                printWriter.println(pedido);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            printWriter.close();
        }

        //2-DAT (OBJETO)
        File file2 = new File("datos.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file2);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listaPedido + "\n");
            oos.writeObject(listaClientes + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura.");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado de objetos");
            }
        }
    }
}
