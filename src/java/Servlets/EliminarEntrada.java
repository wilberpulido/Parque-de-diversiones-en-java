
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


@WebServlet(name = "EliminarEntrada", urlPatterns = {"/EliminarEntrada"})
public class EliminarEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Controladora control = new Controladora();
        
        int idEliminar = Integer.parseInt(request.getParameter("idEliminar"));
        
        control.borraEntradaPorID(idEliminar);
    
                List<Entrada> entradasCliente = control.getTodasLasEntradas();
                HttpSession miSession = request.getSession();
                miSession.setAttribute("entradas", entradasCliente);

                
        response.sendRedirect("MostrarEntradasRegistradas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
