package main.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.Conexion;
import main.java.model.Ventas;

public class VentasRepository {
    public void agregarVenta(Ventas venta){
        String sql = "INSERT INTO VENTAS (ID_BICICLETA, CANTIDAD, TOTAL, FECHA) VALUES (?, ?, ?, ?)";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            
                preparedStatement.setInt(1, venta.getIdBici());
                preparedStatement.setInt(2, venta.getCantidad());
                preparedStatement.setInt(3, venta.getTotal());
                preparedStatement.setDate(4, venta.getFecha());

                System.out.println("Venta ingresada: \n Id Bicicleta: " + venta.getIdBici() + "\n Cantidad: " + venta.getCantidad() + "\n Total: " + venta.getTotal() + "\n Fecha: " + venta.getFecha());
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

                System.out.println("Se eliminó la informadión de la venta realizada: \n Fecha: " + venta.getFecha() + "\n Id bicicleta: " + venta.getIdBici());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
