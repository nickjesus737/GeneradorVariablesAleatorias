
package logica;

import java.util.ArrayList;

public class MetodosEspeciales extends Metodos{

    public MetodosEspeciales() {
    }
    
    public ArrayList<Double> variables_normales(ArrayList<Double> numerosAleatorios, double media, double desviacion) {

        ArrayList<Double> numerosNormales = new ArrayList<>();

        for (int i = 0; i < numerosAleatorios.size(); i++) {

            if (i % 2 == 0) {
                numerosNormales.add(Math.sqrt(-2 * Math.log(numerosAleatorios.get(i))) * Math.cos(2 * Math.PI * numerosAleatorios.get(i + 1)));

            } else {
                numerosNormales.add(Math.sqrt(-2 * Math.log(numerosAleatorios.get(i - 1))) * Math.sin(2 * Math.PI * numerosAleatorios.get(i)));
            }
        }

        ArrayList <Double> variablesNormales = new ArrayList<>();

        for (int i = 0; i < numerosNormales.size(); i++) {
            variablesNormales.add(media + desviacion * numerosNormales.get(i));
        }

        return variablesNormales;
    }
    
}
