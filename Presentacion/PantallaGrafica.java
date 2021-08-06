package Presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.ColeccionVehiculos;
import Logica.Vehiculo;

public class PantallaGrafica extends JFrame implements ActionListener
{
    JButton btnListar;
    JButton btnIngresar;
    private ColeccionVehiculos col = new ColeccionVehiculos();
    
    public PantallaGrafica()
    {
        col.cargarVehiculos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setBounds(200, 100, 600, 480);
        setTitle("Bienvenidos a las interfaces gráficas Java");
        setLayout(null);
        
        JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
        lblTitulo.setBounds(50, 50, 200, 30);
        add(lblTitulo);
        
        btnListar = new JButton("Listar vehículos");
        btnListar.setBounds(50, 100, 200, 30);
        btnListar.addActionListener(this);
        add(btnListar);
        
        btnIngresar = new JButton("Ingresar vehiculo");
        btnIngresar.setBounds(50, 150, 200, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnListar)
        {
            listarVehiculos();  
        }
        else if (e.getSource() == btnIngresar)
        {
            ingresarVehiculo(); 
        }
        
    }
    
    public void listarVehiculos()
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
    
    public void ingresarVehiculo()
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
}
