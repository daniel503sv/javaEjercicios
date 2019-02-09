/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.segundo;

/**
 *
 * @author josed
 */
public class Cuenta {
    private int id;
    private double saldo;
    
    public Cuenta(int numeroCuenta,double saldo){
        this.id = numeroCuenta;
        this.saldo = saldo;
    }
    
    public boolean retirarEfectivo(double cantidad){
        if(cantidad <= this.saldo){
            this.saldo = saldo - cantidad;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean ingresarEfectivo(double cantidad){
        this.saldo = saldo + cantidad;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String toString(){
        return String.valueOf(this.id)+","+String.valueOf(this.saldo);
    }
}
