package Logica;
import java.util.ArrayList;

public class ColeccionVehiculos
{
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    
    public void addVehiculo(Vehiculo v)
    {
        vehiculos.add(v);
    }
    
    public Vehiculo getVehiculo(int index)
    {
        return vehiculos.get(index);
    }
    
    public void deleteVehiculo(int index)
    {
        vehiculos.remove(index);
    }
    
    public int getSize()
    {
        return vehiculos.size();
    }
    
    public void setVehiculo(int index, Vehiculo v)
    {
        vehiculos.set(index, v);
    }
}
