package logica;

import java.util.ArrayList;

public class MetodosTransformadaInversa extends Metodos {

    public MetodosTransformadaInversa() {
    }

    //generador de variables aleatorias con el metodo exponencial
    public ArrayList<Double> variableAleatoriaExponencial(double media, ArrayList<Double> numerosAleatorios) {

        double lambda = 1 / media;

        ArrayList<Double> variablesAleatorias = new ArrayList<>();

        for (int i = 0; i < numerosAleatorios.size(); i++) {

            if (numerosAleatorios.get(i) == 0) {
                variablesAleatorias.add(0.00);
            } else {
                variablesAleatorias.add(-(1 / lambda) * Math.log(numerosAleatorios.get(i)));
            }
        }
        return variablesAleatorias;
    }

    //generador de variables aleatorias uniformemente distribuidas
    public ArrayList<Double> variableAleatoriaUniforme(double rangoA, double rangoB, ArrayList<Double> numerosAleatorios) {

        ArrayList<Double> variablesAleatorias = new ArrayList<>();

        for (int i = 0; i < numerosAleatorios.size(); i++) {
            variablesAleatorias.add(rangoA + (rangoB - rangoA) * numerosAleatorios.get(i));
        }

        return variablesAleatorias;

    }

    //generador de variables aleatorias con el metodo de poisson
    public ArrayList<Integer> variableAleatoriaPoisson(ArrayList<Double> numerosAleatorios, double lambda) {

        double rango1 = 0;
        double rango2 = 0;

        double x = lambda + 2 * lambda;
        double poisson = 0;

        ArrayList<Double> listaPoisson = new ArrayList<>();
        ArrayList<Integer> variablePoisson = new ArrayList<>();

        poisson = (Math.pow(Math.E, -lambda) * Math.pow(lambda, 0)) / factorial(0);

        listaPoisson.add(poisson);

        for (int i = 1; i <= x; i++) {
            poisson += (Math.pow(Math.E, -lambda) * Math.pow(lambda, i)) / factorial(i);

            if (listaPoisson.get(i - 1) != poisson) {
                listaPoisson.add(poisson);
            } else {
                break;
            }
        }

        for (int i = 0; i < numerosAleatorios.size(); i++) {
            
            for (int j = 0; j < listaPoisson.size(); j++) {
                
                rango2 = listaPoisson.get(j);
                
                if (numerosAleatorios.get(i) >= rango1 && numerosAleatorios.get(i) < rango2){
                    variablePoisson.add(j);
                }
                
                rango1 = listaPoisson.get(j);
            }
            
        }

        return variablePoisson;
    }

}
