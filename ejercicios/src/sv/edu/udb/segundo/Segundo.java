/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.segundo;

import java.io.IOException;
import javax.swing.JOptionPane;
import sv.edu.udb.utils.IngresoDatos;

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
            boolean sesion = false;
            int operacion =0;
            do{     
              if(!sesion){
                  do{
                      if(cajero.ingresar(IngresoDatos.numeroEntero("Ingrese su numero de cuenta"))){
                          sesion= true;
                      }else{
                          JOptionPane.showMessageDialog(null, "No se encontro la cuenta, intente de nuevo");
                      }
                  }while(!sesion);
              }
              
              operacion = JOptionPane.showOptionDialog(null, "Cuenta "
                      +cajero.verNumeroCuenta()
                        +" seleccione una opcion"
                      , "CAJERO", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION
                      , null, OPERACIONES, OPERACIONES[0]);
              switch(operacion){
                  case 0: //salir
                      int salir = JOptionPane.showConfirmDialog(null, "Desea salir del cajero", "Salir", JOptionPane.WARNING_MESSAGE);
                      if(salir == 0){
                          operacion = -1;
                      }
                      break;
                  case 1: //Consulta de saldo
                      JOptionPane.showMessageDialog(null, "Su saldo es: "+cajero.verSaldo()+"$");
                      break;
                  case 2: //retiro
                      if(cajero.retirarCuenta(IngresoDatos.dinero("Cantidad a retirar"))){
                          JOptionPane.showMessageDialog(null, "Dinero retirado exitosamente");
                      }else{
                          JOptionPane.showMessageDialog(null, "No tiene suficientes fondos para retirar esa cantidad");
                      }
                      break;
                  case 3: //consignacion
                      if(cajero.abonarCuenta(IngresoDatos.dinero("Cantidad a consignar"))){
                          JOptionPane.showMessageDialog(null, "Dinero consignado exitosamente");
                      }else{
                          JOptionPane.showMessageDialog(null, "Error al consignar el dinero");
                      }
                      break;
                  case 4: //transferencia
                      Cuenta cuentaAbonar = cajero.obtenerCuenta(IngresoDatos.numeroEnteroPositivo("Ingrese numero de cuenta a abonar"));
                      if(cuentaAbonar !=null){
                          if(cajero.transferenciaCuenta(cuentaAbonar,
                                  IngresoDatos.dinero("Ingrese la cantidad a transferir"))>0){
                            JOptionPane.showMessageDialog(null, "Transferencia a la cuenta: "+cuentaAbonar.getId()+" completada exitosamente");
                          }else{
                            JOptionPane.showMessageDialog(null, "Fondos insuficientes para realizar la transaccion");
                          }
                          
                      }else{
                          JOptionPane.showMessageDialog(null, "Numero de cuenta de la transferencia invalido");
                      }                      
                      break;
              }
              cajero.guardar();
            }while(operacion >=0);
            
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
