/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.edu.udb.segundo.Segundo;
import sv.edu.udb.tercero.Tercero;
import sv.udb.edu.primero.Primero;

/**
 *
 * @author josed
 */
public class Ejercicios {
    private static final String[] OPCIONES = {"SALIR","SALUDO","CAJERO","MEDIATECA"};
    public static void main(String[] args) {
        int seleccion = 0;
        do {
            seleccion= JOptionPane.showOptionDialog(null, "Seleccione un ejercicio a evaluar", "seleccion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, OPCIONES, OPCIONES[0]);
            switch(seleccion){
                case -1:
                    JOptionPane.showMessageDialog(null, "Seleccione una operacion valida");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por completar la revision");
                    break;
                case 1:{
                try {
                    //ejercicio 1
                    Primero.main(args);
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
                    break;
                case 2://ejercicio 2
                    Segundo.main(args); //cajero
                    break;
                case 3://ejercicio 3
                    Tercero.main(args); //mediateca
                    break;            
            }
        }while(seleccion!=0);
    }
}
