package Presentacion;
import javax.swing.JOptionPane;
import Logica.ColeccionVehiculos;
import Logica.Vehiculo;

public class Pantalla
{
    private ColeccionVehiculos col = new ColeccionVehiculos();
    
    public void presentarMenu()
    {
        col.cargarVehiculos();
        String [] opciones = {"Listar vehiculos",
                              "Ingresar nuevo vehiculo",
                              "Borrar vehiculo",
                              "Salir" };
        do
        {
            String opcion = (String)JOptionPane.showInputDialog(null,
                                                                "Seleccione una opción",
                                                                "MENU PRINCIPAL",
                                                                JOptionPane.DEFAULT_OPTION, 
                                                                null,
                                                                opciones, 
                                                                opciones[0]);
            if (opcion.equals(opciones[0])) 
            {
                if (col.getSize() == 0)
                {
                    JOptionPane.showMessageDialog(null, "No hay vehiculos registrados");                    
                }
                else 
                {
                    String mensaje = "";
                    for (int i = 0; i < col.getSize(); i++)
                    {
                        Vehiculo v = col.getVehiculo(i);
                        mensaje = mensaje + i + ") " + v.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            }
            else if (opcion.equals(opciones[1]))
            {
                String marca = JOptionPane.showInputDialog(null, "Ingrese marca de vehículo");
                String referencia = JOptionPane.showInputDialog(null, "Ingrese referencia de vehículo");
                String placa = JOptionPane.showInputDialog(null, "Ingrese placa de vehículo");
                int modelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese modelo de vehículo"));
                Vehiculo v = new Vehiculo(placa, marca, referencia, modelo);
                boolean guardado = col.guardarVehiculo(v);
                if (guardado == true)
                {
                    JOptionPane.showMessageDialog(null, "Vehiculo agregado");                        
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Vehiculo no guardado");                        
                }
                
            }
            else if (opcion.equals(opciones[2]))
            {
                int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese posición de vehículo a borrar"));
                if (index <0 || index > col.getSize() - 1)
                {
                    JOptionPane.showMessageDialog(null, "No se puede borrar");
                }
                else 
                {
                    col.deleteVehiculo(index);
                    
                    JOptionPane.showMessageDialog(null, "Vehiculo borrado");                    
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Programa terminado");
                break;
            }
        }while (true);
    }
}
