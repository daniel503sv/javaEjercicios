/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.segundo;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author josed
 */
public class Segundo {
    private static final String[] OPERACIONES = {"SALIR","CONSULTA DE SALDO","RETIRO","CONSIGNACIONES","TRANSFERENCIAS"};
 
    public static void main(String[] args) {
        Cajero cajero = new Cajero("resources\\cuentas.txt");
        
        try {
            cajero.cargar();
            cajero.ingresar(1010);
            cajero.retirarCuenta(50.00);
            cajero.salir();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo");
            System.out.println(ex);
        } catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }
}
