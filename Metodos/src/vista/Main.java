/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import logica.*;

public class Main {

    public static void main(String[] args) {
        
        Metodos me = new Metodos();
        
        MetodosTransformadaInversa  me1 = new MetodosTransformadaInversa();
        
        ArrayList numerosAleatorios1 = me.numerosAleatorios(1, 127, 11, 100003);
     /* ArrayList numerosAleatorios2 = me.numerosAleatorios(2, 127, 11, 100003);
        ArrayList numerosAleatorios3 = me.numerosAleatorios(3, 127, 11, 100003);
        ArrayList numerosAleatorios4 = me.numerosAleatorios(4, 127, 11, 100003);
        ArrayList numerosAleatorios5 = me.numerosAleatorios(5, 127, 11, 100003);
        ArrayList numerosAleatorios6 = me.numerosAleatorios(6, 127, 11, 100003);
        ArrayList numerosAleatorios7 = me.numerosAleatorios(7, 127, 11, 100003);
        ArrayList numerosAleatorios8 = me.numerosAleatorios(8, 127, 11, 100003);
        ArrayList numerosAleatorios9 = me.numerosAleatorios(9, 127, 11, 100003);
        
     */   
        ArrayList variableAleatoriaUniforme = me1.variableAleatoriaPoisson(numerosAleatorios1, 2);
        
        me1.exportarEntero(variableAleatoriaUniforme);
    }
    
}
