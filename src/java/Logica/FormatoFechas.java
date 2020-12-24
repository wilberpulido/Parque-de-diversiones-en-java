package Logica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoFechas {
 
    private String fechaString;
    private String horaString;

    public FormatoFechas() {
    }

    public FormatoFechas(String fechaString, String horaString) {
        this.fechaString = fechaString;
        this.horaString = horaString;
    }

    public String getFechaString() {
        return fechaString;
    }

    public String getHoraString() {
        return horaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public void setHoraString(String horaString) {
        this.horaString = horaString;
    }
    
     public static Date convertirHoraStringADate (String horaStr) throws ParseException {
      
        String horaString = horaStr;
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
         
        Date horaCompleta = new Date();
          
            horaCompleta = formatoHora.parse(horaString);
            
       System.out.println("La hora es: " + horaCompleta);
      return horaCompleta;
      }
    
    public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //formato guión año-mes-día
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static String DateAString(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }
    public static String DateHoraAString(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
        return formatoFecha.format(fecha);
    }

}
