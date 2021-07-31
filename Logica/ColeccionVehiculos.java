package Logica;
import java.util.ArrayList;
import Persistencia.DAOVehiculos;
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
    
    public void guardarVehiculos()
    {
        DAOVehiculos dao = new DAOVehiculos();
        String todoElTexto = dao.convertirTodosLosVehiculosACSV(this);
        System.out.println(todoElTexto);
        Archivo a = new Archivo();
        a.escribir(todoElTexto);
    }
    
    public void cargarVehiculos()
    {
        Archivo a = new Archivo();
        String todoElTexto = a.leer();
        
        DAOVehiculos dao = new DAOVehiculos();
        vehiculos = dao.convertirTodoCSVAVehiculos(todoElTexto);
        
    }
}
