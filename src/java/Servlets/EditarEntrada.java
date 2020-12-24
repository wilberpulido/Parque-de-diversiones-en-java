package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import Logica.FormatoFechas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditarEntrada", urlPatterns = {"/EditarEntrada"})
public class EditarEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Controladora control = new Controladora();
        int idEditar = Integer.parseInt(request.getParameter("idEditar"));

        Entrada EntradaAEditar = control.buscarEntradaPorId(idEditar);
        
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("editarEntrada", EntradaAEditar);
                
        response.sendRedirect("editarEntrada.jsp");
        
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
