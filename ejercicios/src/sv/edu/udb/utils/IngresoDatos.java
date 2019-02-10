/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author josed
 */
public class IngresoDatos {
    
    public static double dinero(String mensaje){
        boolean valido = false;
        double numero = 0;
        do{
            try{
                numero = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                if(numero>=0){
                   valido = true;         
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese un numero positivo");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
                System.out.println(ex);
            }
        }while(!valido);        
       return numero;
    }
    
    public static int numeroEntero(String mensaje){
        boolean valido = false;
        int numero = 0;
        do{
            try{
                numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                valido = true;
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
                System.out.println(ex);
            }
        }while(!valido);        
       return numero;
    }
    
    public static int numeroEnteroPositivo(String mensaje){
        boolean valido = false;
        int numero =0;
        do{
            numero = IngresoDatos.numeroEntero(mensaje);
            if(numero<0){
                JOptionPane.showMessageDialog(null, "Ingrese un numero positivo");
            }else{
                valido = true;
            }
        }while(!valido);
        return numero;
    }
}
