package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.Conexion;
import model.Ventas;

public class VentasRepository {
    public void agregarVenta(Ventas venta){
        String sql = "INSERT INTO VENTAS (ID_BICICLETA, CANTIDAD, TOTAL, FECHA) VALUES (?, ?, ?, ?)";
        String sqlPrecio = "SELECT PRECIO FROM BICICLETA WHERE ID_BICI = ?";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlPrecio);){

                preparedStatement2.setInt(1, venta.getIdBici());
                ResultSet resultSet = preparedStatement2.executeQuery();

                int precioUnitario = 0;
                if (resultSet.next()) {
                    precioUnitario = resultSet.getInt("Precio");
                }else{
                    System.out.println("El id de la bicicleta ingresado es incorrecto" + venta.getIdBici());
                    return;
                }

                int cantidad = venta.getCantidad();
                int total = precioUnitario * cantidad;

                preparedStatement.setInt(1, venta.getIdBici());
                preparedStatement.setInt(2, cantidad);
                preparedStatement.setInt(3, total);
                preparedStatement.setString(4, venta.getFecha());
                preparedStatement.executeUpdate();

                System.out.println("\nVenta ingresada: \n Id Bicicleta: " + venta.getIdBici() + "\n Cantidad: " + venta.getCantidad() + "\n Total: " + total + "\n Fecha: " + venta.getFecha());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarVentas(){
        String sql = "SELECT * FROM VENTAS";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){

                while (resultSet.next()) {
                    Integer idVenta = resultSet.getInt("id_ventas");
                    Integer cantidad = resultSet.getInt("cantidad");
                    Integer total = resultSet.getInt("total");
                    String fecha = resultSet.getString("fecha");
                    System.out.println("Id venta: " + idVenta + " Cantidad: " + cantidad + " Total: " + total + " Fecha: " + fecha);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void eliminarVenta(Ventas venta){
        String sql = "DELETE FROM VENTAS WHERE ID_VENTAS = ?";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            
                preparedStatement.setInt(1, venta.getId());
                preparedStatement.executeUpdate();

                System.out.println("Se eliminó la informadión de la venta realizada: \n Fecha: " + venta.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
