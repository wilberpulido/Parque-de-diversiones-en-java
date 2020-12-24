package Servlets;

import Logica.Controladora;
import Logica.Cuenta;
import Logica.Empleado;
import Logica.FormatoFechas;
import Logica.Horario;
import Logica.Juego;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CondicionesIniciales", urlPatterns = {"/CondicionesIniciales"})
public class CondicionesIniciales extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Controladora controlar = new Controladora();
        
        //empleado 1
        
        Cuenta  cuentaEmpleado1 = controlar.crearCuenta("Juan","456");
        
        Empleado empleado1 = controlar.crearEmpleado("Juan","Marquina","24900174", cuentaEmpleado1);
        
        //empleado 2
        
        Cuenta cuentaEmpleado2 = controlar.crearCuenta("Pedro","123");
        
        Empleado empleado2 = controlar.crearEmpleado("Pedro","Paez","95774124", cuentaEmpleado2);
        
        //empleado 3
        Cuenta cuentaEmpleado3 = controlar.crearCuenta("Jaime","963");
        
        Empleado empleado3 = controlar.crearEmpleado("Jaime","Hernandez","90943147", cuentaEmpleado3);
                
        
        //juego1     
        List<Empleado> listaFortuna = new ArrayList<Empleado>();
        
        listaFortuna.add(empleado1);
        listaFortuna.add(empleado2);
        
        Juego ruedaFortuna = controlar.crearJuego("Rueda de la Fortuna",500, listaFortuna);
    
        //juego2        
        List<Empleado> listaMotaniaRusa = new ArrayList<Empleado>();
        
        listaMotaniaRusa.add(empleado2);
        listaMotaniaRusa.add(empleado3);        
        
        Juego montaniaRusa = controlar.crearJuego("Montania Rusa",1000, listaMotaniaRusa);
        
        //horarios
        
        Horario primerTurno = new Horario();
        
        String hora1 = "9:00";
        String hora2 = "14:00";
        
        try {
            Date horaInicio1 = FormatoFechas.convertirHoraStringADate(hora1);
            primerTurno.setHoraInicio(horaInicio1);
            
            Date horaFinal1 = FormatoFechas.convertirHoraStringADate(hora2);
            primerTurno.setHoraCierre(horaFinal1);

            controlar.crearHorario(horaInicio1,horaFinal1, montaniaRusa);
            controlar.crearHorario(horaInicio1,horaFinal1, ruedaFortuna);

            
        } catch (ParseException ex) {
            Logger.getLogger(LoginServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        response.sendRedirect("index.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
