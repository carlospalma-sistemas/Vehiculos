package Logica;
import java.util.ArrayList;
import Persistencia.DAOTVehiculos;
import Persistencia.Archivo;

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
    
    public boolean guardarVehiculo(Vehiculo v)
    {
        DAOTVehiculos dao = new DAOTVehiculos();
        int id = dao.guardarVehiculo(v);
        if (id > 0) 
        {
            v.setId(id);
            addVehiculo(v);
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public void actualizarVehiculo(int index, Vehiculo v)
    {
        DAOTVehiculos dao = new DAOTVehiculos();
        dao.modificarVehiculo(v);
        setVehiculo(index, v);
    }
    
    public void cargarVehiculos()
    {
        DAOTVehiculos dao = new DAOTVehiculos();
        vehiculos = dao.obtenerVehiculos();
    }
    
    public void borrarVehiculo(int index)
    {
        DAOTVehiculos dao = new DAOTVehiculos();
        dao.borrarVehiculo(getVehiculo(index));
        deleteVehiculo(index);
    }
}
