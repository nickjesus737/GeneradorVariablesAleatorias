package logica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

public class Metodos {

    public Metodos() {
    }

    //generador de numeros aleatorios con el metodo congruencial mixto
    public ArrayList numerosAleatorios(int x, int a, int c, int m) {

        ArrayList<Double> numerosAleatorios = new ArrayList<>();

        double X = x;
        double aux;
        double pro;

        aux = a * X + c;
        X = aux % m;
        pro = X;

        numerosAleatorios.add(X / m);

        do {
            aux = a * X + c;
            X = aux % m;
            numerosAleatorios.add(X / m);
        } while (pro != X);

        return numerosAleatorios;
    }

    //metodo para calcular el factorial de un numero
    public float factorial(float x) {

        float factorial = 1;

        while (x != 0) {
            factorial *= x;
            x--;
        }

        return factorial;
    }

    public boolean iguales(ArrayList<Double> a, ArrayList<Double> b) {

        for (int i = 0; i < a.size(); i++) {

            for (int j = 0; j < b.size(); j++) {
                if (a.get(i) == b.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    //metodo para redondear numeros double a dos decimales
    public double redondear(double decimal, int escala) {

        BigDecimal bd = new BigDecimal(decimal).setScale(escala, RoundingMode.DOWN);

        return Double.parseDouble(bd.toString());
    }
    
    
    public String formateador(Double numero) {
        
        String cadena = "";
        String num = numero.toString();
        
        for (int i = 0; i < num.length() ; i++) {
            
            if (num.charAt(i) == '.'){
                cadena += ',';
            }else{
                cadena += String.valueOf(num.charAt(i));
            }
            
        }
        
        return cadena;
    }

    public void exportar(ArrayList<Double> numerosAleatorios) {
        String outputFile = "C:/Users/trabajo/Desktop/NumerosAleatorios.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File ArchivoEmpleados = new File(outputFile);
            ArchivoEmpleados.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            csvOutput.write("Numeros Aleatorios");
            csvOutput.endRecord();

            for (int i = 0; i < numerosAleatorios.size(); i++) {
                csvOutput.write(formateador(numerosAleatorios.get(i)));
                csvOutput.endRecord();
            }

            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void exportarEntero(ArrayList<Integer> numerosAleatorios) {
        String outputFile = "C:/Users/trabajo/Desktop/NumerosAleatorios.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File ArchivoEmpleados = new File(outputFile);
            ArchivoEmpleados.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            csvOutput.write("Numeros Aleatorios");
            csvOutput.endRecord();

            for (int i = 0; i < numerosAleatorios.size(); i++) {
                csvOutput.write(Integer.toString(numerosAleatorios.get(i)));
                csvOutput.endRecord();
            }

            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
