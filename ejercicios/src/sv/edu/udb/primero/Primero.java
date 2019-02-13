package sv.udb.edu.primero;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Clase Primero.java 
 * NetBeans IDE 8.2 
 * 15/02/2019
 */

/**
 *
 * Integrantes:
 *              Jose Chinchilla
 *              Oscar Aragón
 *              Rafael Lara
 *              Daniel Choriego
 * 
 */
public class Primero {
    
    // Variables para el manejo de datos de entrada
    String nombres;         // Se ingresara nombre y apellido en una sola linea
    String[] separacionNombres;
    String edadInput;       // Se usara para guardar el input del JOptionPane
    int edad;               // Variable para guardar la conversión Int.parse
    String nacimiento;      // Se ingresara en el formato (dd-mm-aaaa)
    GregorianCalendar c = new GregorianCalendar();  // variable para manipulación de la fecha nacimiento
    String generoPersona;   
    String [] opcionesGenero = { "Femenino", "Masculino" };
    String zodiaco;
    
    // Fin de la declaracion de variables
    
    public Primero(){ 
        nombres = "Daniel Choriego";
        edad = 27;
        nacimiento = "18-12-1991";
    } // Fin del constructor
    
    public void ingresoDatos(){
       nombres = JOptionPane.showInputDialog("Por favor ingrese un nombre y un apellido");
       separacionNombres = nombres.split(" ");
        System.out.println(separacionNombres[0]);
        System.out.println(separacionNombres[1]);
       generoPersona = (String) JOptionPane.showInputDialog(null, "Ingrese su genero", 
                                "Genero de la persona", JOptionPane.DEFAULT_OPTION, 
                                null, opcionesGenero, opcionesGenero[0]);
       do{
       nacimiento = JOptionPane.showInputDialog("Por favor ingresar su fecha de nacimiento en el formato (dd-mm-yyyy)");
       if(fechaValida(nacimiento))
               JOptionPane.showMessageDialog(null, "Por favor ingrese una fecha valida segun formato indicado");
       }while(fechaValida(nacimiento));
    } // Fin del metodo ingresoDatos()
    
    // La siguiente función me permite, a traves de expresiones regulares
    // verificar que la fecha ingresada este en el formato solicitado en base 
    // tomando en cuenta los días de febrero para año bisiesto
    // Expresión regular tomada de:
    // https://stackoverflow.com/questions/15491894/regex-to-validate-date-format-dd-mm-yyyy
    
    protected boolean fechaValida(String fechaIngreso){
        String exReg = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        Pattern patron = Pattern.compile(exReg);
        Matcher valida; 
        valida = patron.matcher(fechaIngreso);
        return !valida.matches();
    }// Fin de la función fechaValida(string)
    
    public void saludo() throws ParseException{
        
        // Variables y funcion para el calculo de la edad 
        // SimpleDateFormat es una clase que permite el manejo de cadenas string a objetos date y viceversa
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento = formatoFecha.parse(nacimiento);   
        c.setTime(fechaNacimiento);
        edad = calcularEdad(c);
        
        // Switch controla saludo principal con el calculo de la edad
        switch(generoPersona)
        {
            case "Femenino":
                 if(edad>=30)
                     JOptionPane.showMessageDialog(null, "Buenos días Ms. " + separacionNombres[1] + " su edad es " + edad + " años");
                 else
                     JOptionPane.showMessageDialog(null, "Hola amiga " + separacionNombres[0] + " su edad es " + edad + " años");
                break;
                
            case "Masculino":
                 if(edad>=30)
                     JOptionPane.showMessageDialog(null, "Buenos días Mr. " + separacionNombres[1] + " su edad es " + edad + " años");
                 else
                     JOptionPane.showMessageDialog(null, "Hola amigo " + separacionNombres[0] + " su edad es " + edad + " años");
                break;
            default:
                    JOptionPane.showMessageDialog(null, "Hola amigo");
                break;
        }
        
        // Encontrando el signo zodiacal de la persona a saludar
        
        // la clase Date define MONTH de 0 a 11 
        // siendo enero 0 y diciembre 11
        // Para el manejo de una manera convencional se le sumara 1
        // así tenemos (1 enero y 12 diciembre)
        // Para el uso de la función signoZodiacal que recibe como
        // parametros diaNacimiento y mesNacimiento
        
        int mesNacimiento = c.get(Calendar.MONTH) + 1; 
        int diaNacimiento = c.get(Calendar.DAY_OF_MONTH);
        zodiaco = signoZodiacal(diaNacimiento, mesNacimiento);       
        JOptionPane.showMessageDialog(null, "Su signo zodiacal es: " + zodiaco);
        
        // Para saber el día de la semana en que naci
        int diaSemanaNacimiento = c.get(Calendar.DAY_OF_WEEK);
        JOptionPane.showMessageDialog(null, "El día " + 
                diaSemana(diaSemanaNacimiento) + " usted vino a este mundo");
        
        // Encontrando si el año es bisiesto o no
        int year = c.get(Calendar.YEAR);
        if(bisiesto(year))
            JOptionPane.showMessageDialog(null, "El año " + year + " fue bisiesto");
        else
            JOptionPane.showMessageDialog(null, "El año " + year + " no fue bisiesto");
    }
    
    protected int calcularEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance(); // se obtiene la fecha actual
        // se hace la resta de la fecha actual menos la fecha de nacimiento
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR); 
        // se hace la resta para los meses
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        // y se hace la resta para los años
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Se calcula que en el año actual no se haya cumpliado años
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1;
        }
        return diffYear;
    }
    
    protected String signoZodiacal(int Dia, int Mes){
            String signo = "Signo zodiacal no asignado";
        if (Dia >= 21 && Mes == 3 || Dia <= 20 && Mes == 4){
        return ("Aries");
        }
        if (Dia >= 21 && Mes == 4 || Dia <= 21 && Mes == 5 ){
        return ("Tauro");
        }
        if (Dia >= 22 && Mes == 5 || Dia <= 21 && Mes == 6) {
        return ("Geminis");
        }
        if (Dia >= 21 && Mes == 6 || Dia <= 27 && Mes == 7){
        return ("Cancer");
        }
        if (Dia >= 24 && Mes == 7 || Dia <= 23 && Mes == 8){
        return ("Leo");
        }
        if (Dia >= 24 && Mes == 8 || Dia <= 23 && Mes == 9){
        return ("Virgo");
        }
        if (Dia >= 24 && Mes == 9 || Dia <= 23 && Mes == 10){
        return ("Libra");
        }
        if (Dia >= 24 && Mes == 10 || Dia <= 22 && Mes == 11){
        return ("Escorpio");
        }
        if (Dia >= 23 && Mes == 11 || Dia <= 21 && Mes == 12){
        return ("Sagitario");
        }
        if (Dia >= 22 && Mes == 11 || Dia <= 20 && Mes == 1){
        return ("Capricornio");
        }
        if (Dia >= 21 && Mes == 1 || Dia <= 19 && Mes == 2){
        return ("Acuario");
        }
        if (Dia >= 20 && Mes == 2 || Dia <= 20 && Mes == 3){
        return ("Picis");
        }
        else {
        return signo;
        }
    }
    
    protected boolean bisiesto(int year){
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }
    
    protected String diaSemana(int diaSemanaNac){
        String dia;
        switch(diaSemanaNac)
        {
            case 1:
                dia = "Domingo";
                break;
            case 2:
                dia = "Lunes";
                break;
            case 3:
                dia = "Martes";
                break;
            case 4: 
                dia = "Miercoles";
                break;
            case 5: 
                dia = "Jueves";
                break;
            case 6:
                dia = "Viernes";
                break;
            case 7:
                dia = "Sabado";
                break;
            default:
                dia = "No especificado";
                break;
        }
        return dia;
    }
    
    public static void main(String[] args) throws ParseException {
        Primero saludo = new Primero();
        saludo.ingresoDatos();
        saludo.saludo();
    }
}
