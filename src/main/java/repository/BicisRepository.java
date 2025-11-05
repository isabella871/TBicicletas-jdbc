package main.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.model.Bicicletas;
import db.Conexion;

public class BicisRepository {
    
    public void agregarBici(Bicicletas bici){
        String sql = "INSERT INTO BICICLETA (MODELO, PRECIO, STOCK) VALUES (?, ?, ?)";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
                preparedStatement.setString(1, bici.getModelo());
                preparedStatement.setInt(2, bici.getPrecio());
                preparedStatement.setInt(3, bici.getStock());
                preparedStatement.executeUpdate();
            
            System.out.println("Bicicleta insertada correctamente: " + bici.getModelo() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarBici(){
        String sql = "SELECT * FROM bicicleta";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){

                while (resultSet.next()) {
                    Integer idBici = resultSet.getInt("id_bici");
                    String modelo = resultSet.getString("modelo");
                    Integer precio = resultSet.getInt("precio");
                    Integer stock = resultSet.getInt("stock");

                    System.out.println("\n Id: " + idBici + "\n Modelo: " + modelo + "\n Precio: " + precio + "\n Stock: " + stock);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarBici(Bicicletas bici){
        String sql = "UPDATE BICICLETA SET MODELO = ?, PRECIO = ?, STOCK = ? WHERE ID_BICI = ?";
    
        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            
                preparedStatement.setString(1, bici.getModelo());
                preparedStatement.setInt(2, bici.getPrecio());
                preparedStatement.setInt(3, bici.getStock());
                preparedStatement.setInt(4, bici.getId());
                preparedStatement.executeUpdate();

                System.out.println("\n Datos actualizados: \n Modelo: "  + bici.getModelo() + "\n Precio: " + bici.getPrecio() + "\n Stock: " + bici.getStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarDatos(Bicicletas bici){
        String sql = "DELETE FROM BICICLETA WHERE ID_BICI = ?";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            
                preparedStatement.setInt(1, bici.getId());
                preparedStatement.executeUpdate();

                System.out.print("Se elimino la información de: \n Modelo: " + bici.getModelo() + " ha sido eliminada \n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
