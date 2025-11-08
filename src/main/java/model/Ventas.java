package model;

public class Ventas {
    private Integer id;
    private Integer idBici;
    private Integer cantidad;
    private Integer total;
    private String fecha;

    public Ventas(Integer id, Integer idBici, Integer cantidad, Integer total, String fecha){
        this.id = id;
        this.idBici = idBici;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = fecha;
    }

    public Ventas(Integer idBici, Integer cantidad, String fecha){
        this.idBici = idBici;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }


    public Ventas(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getIdBici(){
        return idBici;
    }

    public void setIdBici(Integer idBici){
        this.idBici = idBici;
    }

    public Integer getCantidad(){
        return cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }

    public Integer getTotal(){
        return total;
    }

    public void setTotal(Integer total){
        this.total = total;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }
}
