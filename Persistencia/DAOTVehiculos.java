package Persistencia;
import Logica.Vehiculo;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOTVehiculos
{
    public int guardarVehiculo(Vehiculo v)
    {
        int id = 0;
        //Armar el SQL
        String sql = "INSERT INTO TVehiculos " + 
                     "(placa, marca, referencia, modelo) " +
                     "VALUES ('" + v.getPlaca() + "', '" + v.getMarca() + "', '" + v.getReferencia() + "', "+v.getModelo()+")";
        //Crear conexión
        Conexion c = new Conexion();
        c.crearConexion();
        //Ejecutar el sql
        try
        {
            ResultSet rs = c.ejecutarUpdate(sql);
            if (rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Cerrar conexion
        c.cerrarConexion();
        return id;
    }
    
    public ArrayList<Vehiculo> obtenerVehiculos()
    {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        //Armar el SQL
        String sql = "SELECT id, placa, marca, referencia, modelo " +
                     "FROM TVehiculos";
        
        //Crear la conexión
        Conexion c = new Conexion();
        c.crearConexion();
        
        try
        {
            //EJECUTAR EL SQL y recibir el ResultSet
            ResultSet rs = c.ejecutarQuery(sql);
            //RECORRER TODOS LOS REGISTROS DEL RESULTSET
            while(rs.next())
            {
                int id = rs.getInt("id");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String referencia = rs.getString("referencia");
                int modelo = rs.getInt("modelo");
                //ARMAR EL OBJETO VEHICULO
                Vehiculo v = new Vehiculo(id, placa, marca, referencia, modelo);
                //ARMAR MI ARRAYLIST
                listaVehiculos.add(v);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Cerrar conexion
        c.cerrarConexion();
        return listaVehiculos;
    }
    
    
    public void modificarVehiculo(Vehiculo v)
    {
        //ARMAR SQL
        String sql = "UPDATE TVehiculos " +
                     "SET placa = '" + v.getPlaca() + "', marca = '" + v.getMarca() + "', referencia = '" + v.getReferencia() + "', modelo = " + v.getModelo() + " " +
                     "WHERE id = " + v.getId() + "";
        
        //Crear conexion
        Conexion c = new Conexion();
        c.crearConexion();
        c.ejecutarUpdate(sql);
        c.cerrarConexion();
    }
    
    public void borrarVehiculo(Vehiculo v)
    {
        String sql = "DELETE FROM TVehiculos " +
                     "WHERE id = " + v.getId() + "";
        //Crear conexion
        Conexion c = new Conexion();
        c.crearConexion();
        c.ejecutarUpdate(sql);
        c.cerrarConexion();
    }
}
