/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.segundo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author josed
 */
public class Cajero {
    private List<Cuenta> cuentas;
    private String file;
    
    public Cajero(){
        this.cuentas = new ArrayList<>();
    }
    
    public Cajero(String fileName){
        this.file = fileName;
        this.cuentas = new ArrayList<>();
    }
    
    public Cuenta obtenerCuenta(int numeroCuenta){
        return this.cuentas.stream()
                .filter(cuenta->cuenta.getId() == numeroCuenta) //filtra la lista con el numero de cuenta
                .findFirst().orElse(null); //toma el primer valor de la lista deberia ser solo uno si no existe retorna un null
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    public void cargar() throws IOException{
        //se carga el archivo como una coleccion de las lineas
        try (Stream<String> stream = Files.lines(Paths.get(file))) { 
            this.cuentas = new ArrayList<>(); //se borra si existe algo o se crea una nueva coleccion
            stream.forEach(e->{ //por cada linea tomando e como el valor 
                String[] columnas = e.split(","); //se dividen las celdas en este caso cuenta,saldo
                //por cada linea se parsean los valores y se crea una cuenta y se guarda en la lista
                this.cuentas.add(new Cuenta(Integer.parseInt(columnas[0]),Double.parseDouble(columnas[1])));
            });
        } catch (IOException e) { //error de lectura
            throw e; //se devuelve el error 
        } catch (Exception ex){ //cualquier otro error como parsing o archivo incorrecto
            throw ex;
        }
    }
    
    public void guardar() throws IOException{
        String datos = this.cuentas.stream() //se convierte en stream
                .map(e->e.toString()) //se crea un arreglo a de string en este caso cuenta,saldo
                .collect(Collectors.joining("\r\n")); //se unen todas las lineas del arreglo con un salto de linea
        try {
            Files.write(Paths.get(this.file), datos.getBytes()); //se guarda el archivo
        } catch (IOException ex) { //error en la escritura
            throw ex;
        }
    }
}
