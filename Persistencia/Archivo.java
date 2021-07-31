package Persistencia;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Archivo
{
    private String nombreArchivo = "archivo_vehiculos.txt";
    
    public void escribir(String todoElTexto)
    {
        try 
        {
            FileWriter fw = new FileWriter(nombreArchivo, false);
            PrintWriter cursor = new PrintWriter(fw);
            cursor.println(todoElTexto);
            cursor.flush();
            cursor.close();
            fw.close();
            System.out.println("Archivo guardado");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
    }
    
    public String leer()
    {
        String todoElTexto = "";
        try{
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader cursor = new BufferedReader(fr);
            while(cursor.ready())
            {
                todoElTexto = todoElTexto + cursor.readLine() + "\n";
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return todoElTexto;
    }
}







