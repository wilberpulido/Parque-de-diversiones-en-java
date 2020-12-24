
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.FormatoFechas;
import Logica.Horario;
import Logica.Juego;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegistroEntradas", urlPatterns = {"/RegistroEntradas"})
public class RegistroEntradas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);

        Controladora control = new Controladora();
   //Datos cliente     
        String nombreCliente = request.getParameter("nombreCliente");
        String apellidoCliente = request.getParameter("apellidoCliente");
        String dniCliente = request.getParameter("dniCliente");
    //Crear Cliente
        Cliente nuevoCliente = control.crearCliente(nombreCliente, apellidoCliente, dniCliente);    
   //Datos Entrada
        Date fechaEntrada = FormatoFechas.deStringToDate(request.getParameter("fechaEntrada"));
        int idJuego = Integer.parseInt(request.getParameter("idJuego"));
        System.out.println(idJuego);
        Juego juegoSeleccionado = control.buscarJuegoPorId(idJuego);

        System.out.println( "Juego seleccionado: "+juegoSeleccionado.getNombreJuego());
        
            try {
            Date horaEntrada = FormatoFechas.convertirHoraStringADate(request.getParameter("horaEntrada"));
            
            Horario horarioJuego;
                horarioJuego = control.getHorarioJuego(idJuego);
                System.out.println("horario" + horarioJuego);

                System.out.println("inicio" + horarioJuego.getHoraInicio());
                System.out.println("final:" + horarioJuego.getHoraCierre());

                        
           if(horarioJuego.getHoraInicio().compareTo(horaEntrada) >= 0  || horarioJuego.getHoraCierre().compareTo(horaEntrada) <= 0 ){
                
                response.sendError(404, "La hora suministrada se encuentra fuera del horario del juego solicitado");

            } else{

                control.crearEntrada(fechaEntrada, horaEntrada, nuevoCliente, juegoSeleccionado);
                response.sendRedirect("index.jsp");
                
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(RegistroEntradas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(nombreCliente);
        System.out.println(apellidoCliente);
        System.out.println(dniCliente);
        System.out.println(fechaEntrada);
        //System.out.println(horaEntrada);
        System.out.println(idJuego);
        System.out.println(request.getParameter("fechaEntrada"));
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
