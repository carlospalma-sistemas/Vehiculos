package Presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.ColeccionVehiculos;
import Logica.Vehiculo;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PantallaGrafica extends JFrame implements ActionListener
{
    JButton btnListar;
    JButton btnIngresar;
    JButton btnFiltrar;
    JComboBox combo;
    JButton btnModificar;
    JButton btnEliminar;
    JTextField txtMarca, txtReferencia, txtPlaca, txtModelo;
    
    private ColeccionVehiculos col = new ColeccionVehiculos();
    
    public PantallaGrafica()
    {
        col.cargarVehiculos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setBounds(200, 100, 650, 550);
        setTitle("Bienvenidos a las interfaces gráficas Java");
        setLayout(null);
        
        JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
        lblTitulo.setBounds(50, 50, 200, 30);
        add(lblTitulo);
        
        btnListar = new JButton("Listar vehículos");
        btnListar.setBounds(50, 100, 200, 30);
        btnListar.addActionListener(this);
        add(btnListar);
        
        btnFiltrar = new JButton("Filtrar vehículos");
        btnFiltrar.setBounds(50, 150, 200, 30);
        btnFiltrar.addActionListener(this);
        add(btnFiltrar);
        
        btnIngresar = new JButton("Ingresar vehiculo");
        btnIngresar.setBounds(50, 200, 200, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
        
        btnModificar = new JButton("Modificar vehiculo");
        btnModificar.setBounds(50, 250, 200, 30);
        btnModificar.addActionListener(this);
        add(btnModificar);
        
        btnEliminar = new JButton("Eliminar vehiculo");
        btnEliminar.setBounds(50, 300, 200, 30);
        btnEliminar.addActionListener(this);
        add(btnEliminar);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0));
        panel.setBounds(300, 100, 300, 100);
        add(panel);
        
        String [] columnas = col.armarColumnas();
        Object [][] datos = col.armarMatrizVehiculos();
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas); 
        
        JTable tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(300, 100));
        JScrollPane scroll = new JScrollPane(tabla);
        panel.add(scroll);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(50, 350, 200, 30);
        add(txtMarca);
        
        txtReferencia = new JTextField();
        txtReferencia.setBounds(50, 390, 200, 30);
        add(txtReferencia);
        
        txtPlaca = new JTextField();
        txtPlaca.setBounds(50, 430, 200, 30);
        add(txtPlaca);
        
        txtModelo = new JTextField();
        txtModelo.setBounds(50, 470, 200, 30);
        add(txtModelo);
        
        combo = new JComboBox();
        combo.addItem("Dato1");
        combo.addItem("Dato2");
        combo.addItem("Dato3");
        combo.setBounds(300, 300, 150, 30);
        combo.addActionListener(this);
        add(combo);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnListar)
        {
            listarVehiculos();  
        }
        else if (e.getSource() == combo)
        {
            String seleccionado = combo.getSelectedItem().toString();
            JOptionPane.showMessageDialog(this, seleccionado);
        }
        else if (e.getSource() == btnFiltrar)
        {
            filtrarVehiculos(); 
        }
        else if (e.getSource() == btnIngresar)
        {
            ingresarVehiculo(); 
        }
        else if (e.getSource() == btnModificar)
        {
            modificarVehiculo(); 
        }
        else if (e.getSource() == btnEliminar)
        {
            eliminarVehiculo(); 
        }
        
    }
    
    public void listarVehiculos()
    {
        col.cargarVehiculos();
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
    
    public void filtrarVehiculos()
    {
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese id de vehículo a buscar", 0));
        String marcaBuscar = JOptionPane.showInputDialog(null, "Ingrese marca de vehículo a buscar");
        String referenciaBuscar = JOptionPane.showInputDialog(null, "Ingrese referencia de vehículo a buscar");
        String placaBuscar = JOptionPane.showInputDialog(null, "Ingrese placa de vehículo a buscar");
        int modeloBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese modelo de vehículo a buscar", 0));
        col.cargarVehiculos(idBuscar, marcaBuscar, referenciaBuscar, placaBuscar, modeloBuscar);
        
        if (col.getSize() == 0)
        {
            JOptionPane.showMessageDialog(null, "No hay vehiculos con el filtro buscado");    
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
        String marca = txtMarca.getText();
        String referencia = txtReferencia.getText();
        String placa = txtPlaca.getText();
        int modelo = Integer.parseInt(txtModelo.getText());
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
    
    public void modificarVehiculo()
    {
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese posición de vehículo a modificar"));
        if (index <0 || index > col.getSize() - 1)
        {
            JOptionPane.showMessageDialog(null, "No se puede modificar");
        }
        else 
        {
            Vehiculo v = col.getVehiculo(index);
            String marca = JOptionPane.showInputDialog(null, "Ingrese marca de vehículo para modificar", v.getMarca());
            String referencia = JOptionPane.showInputDialog(null, "Ingrese referencia de vehículo para modificar", v.getReferencia());
            String placa = JOptionPane.showInputDialog(null, "Ingrese placa de vehículo para modificar", v.getPlaca());
            int modelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese modelo de vehículo para modificar", v.getModelo()));
            v.setMarca(marca);
            v.setReferencia(referencia);
            v.setPlaca(placa);
            v.setModelo(modelo);
            col.actualizarVehiculo(index, v);
            JOptionPane.showMessageDialog(null, "Vehículo actualizado");
        }
    }
    
    public void eliminarVehiculo()
    {
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese posición de vehículo a borrar"));
        if (index <0 || index > col.getSize() - 1)
        {
            JOptionPane.showMessageDialog(null, "No se puede borrar");
        }
        else 
        {
            col.borrarVehiculo(index);
            JOptionPane.showMessageDialog(null, "Vehiculo borrado");                    
        }   
    }
}
