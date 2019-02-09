/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb;

import javax.swing.JOptionPane;

/**
 *
 * @author josed
 */
public class Ejercicios {
    private static final String[] OPCIONES = {"SALIR","SALUDO","CAJERO","MEDIATECA"};
    public static void main(String[] args) {
        int seleccion = 0;
        do {
            seleccion= JOptionPane.showOptionDialog(null, "Seleccione una operacion", "seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPCIONES, OPCIONES[0]);
            switch(seleccion){
                case -1:
                    JOptionPane.showMessageDialog(null, "Seleccione una operacion valida");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar la calculadora");
                    break;
                case 1://ejercicio 1
                    break;
                case 2://ejercicio 2
                    break;
                case 3://ejercicio 3
                    break;            
            }
        }while(seleccion!=0);
    }
}
