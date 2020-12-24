package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlets", urlPatterns = {"/LoginServlets"})
public class LoginServlets extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        boolean verificado = false;
        
        Controladora control = new Controladora();
        verificado = control.comprobarIngreso(usuario,contrasenia);
       
        
        if (verificado) {
            
            List<Entrada> entradasCliente = control.getTodasLasEntradas();
            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("usuario", usuario);
            miSession.setAttribute("contrasenia", contrasenia);
            miSession.setAttribute("entradas", entradasCliente);
 
            
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("loginError.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
