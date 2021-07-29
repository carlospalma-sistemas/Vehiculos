package Logica;

public class Vehiculo
{
    private String placa;
    private String marca;
    private String referencia;
    private int modelo;
    
    public Vehiculo()
    {
        this.placa = "";
        this.marca = "";
        this.referencia = "";
        this.modelo = 0;
    }
    
    public Vehiculo(String placa, String marca, String referencia, int modelo)
    {
        this.placa = placa;
        this.marca = marca;
        this.referencia = referencia;
        this.modelo = modelo;
    }
    
    public String getPlaca(){
        return this.placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getReferencia(){
        return this.referencia;
    }

    public void setReferencia(String referencia){
        this.referencia = referencia;
    }

    public int getModelo(){
        return this.modelo;
    }

    public void setModelo(int modelo){
        this.modelo = modelo;
    }

    public String toString()
    {
        return "Vehiculo "+this.marca+ " " + this.referencia + " Modelo "+this.modelo+" - Placas: "+this.placa;
    }
}




