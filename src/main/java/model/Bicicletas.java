package model;

public class Bicicletas {
    private Integer id;
    private String modelo;
    private Integer precio;
    private Integer stock;

    public Bicicletas(Integer id, String modelo, Integer precio, Integer stock){
        this.id = id;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    public Bicicletas(String modelo, Integer precio, Integer stock){
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    public Bicicletas(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public Integer getPrecio(){
        return precio;
    }

    public void setPrecio(Integer precio){
        this.precio = precio;
    }

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }
}
