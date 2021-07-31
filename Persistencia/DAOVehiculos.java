package Persistencia;
import Logica.Vehiculo;
import Logica.ColeccionVehiculos;
import java.util.ArrayList;

public class DAOVehiculos
{
    public String convertirVehiculoACSV(Vehiculo v)
    {
        String texto = v.getPlaca() + ";" + v.getMarca() + ";" + v.getReferencia() + ";" + v.getModelo();
        return texto;
    }
    
    public Vehiculo convertirCSVAVehiculo(String texto)
    {
        String [] datos = texto.split(";");
        String placa = datos[0];
        String marca = datos[1];
        String referencia = datos[2];
        int modelo = Integer.parseInt(datos[3]);
        Vehiculo v = new Vehiculo(placa, marca, referencia, modelo);
        return v;
    }
    
    public String convertirTodosLosVehiculosACSV(ColeccionVehiculos col)
    {
        String todoElTexto = "";
        for (int i = 0; i< col.getSize(); i++)
        {
            todoElTexto = todoElTexto + convertirVehiculoACSV(col.getVehiculo(i)) + "\n";
        }
        return todoElTexto;
    }
    
    public ArrayList<Vehiculo> convertirTodoCSVAVehiculos(String todoElTexto)
    {
        ArrayList<Vehiculo> coleccion = new ArrayList<Vehiculo>();
        String [] renglones = todoElTexto.split("\n");
        for (String renglon : renglones)
        {
            Vehiculo v = convertirCSVAVehiculo(renglon);
            coleccion.add(v);
        }
        return coleccion;
    }
}








