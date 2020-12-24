<%@page import="Logica.Controladora"%>
<%@page import="Logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Entradas</title>
    </head>
    <body>
        
        <%
        HttpSession miSession = request.getSession();
        String usuario = (String) request.getSession().getAttribute("usuario");
        
        if(usuario == null){
        %>

        <h1>Usuario no validado, regresar al login</h1>
        
            <a href="index.jsp">retresar el login</a>
            
        <%}
            else{
        %>
        
        <header>
            
        <h1>Registro de entradas</h1>
        <br>
        <a href="index.jsp">regresar al formulario de registro de Entradas</a>

        <table CELLPADDING="10" BORDER="1" ALIGN="LEFT">
            <thead>
            <th>id Entrada</th>
            <th>Fecha Entrada</th>
            <th>Hora Entrada</th>
            <th>Cliente</th>
            <th>Juego</th>
            </thead>
            <tbody>
                <tr>
                    <%
                    List<Entrada> EntradasRegistradas = (List<Entrada>) miSession.getAttribute("entradas");

                    for(Entrada entradaP: EntradasRegistradas){
                        
                    %>
                    <td><%= entradaP.getIdEntrada()%></td>
                    <td><%= entradaP.getFechaEntrada()%></td>
                    <td><%= entradaP.getHoraEntrada()%></td>
                    <td><%= entradaP.getEntradaCliente().getNombre()%></td>
                    <td><%= entradaP.getEntradaJuego().getNombreJuego()%></td>
                    <td> <a href=<%="EliminarEntrada?idEliminar="+entradaP.getIdEntrada()%> > ELIMINAR </a></td>
                    <td> <a href=<%="EditarEntrada?idEditar="+entradaP.getIdEntrada()%> > EDITAR </a></td>


                </tr>
                    
                <%
                }
                %>
                
            </tbody>
            
            
            
            
            
            
            
            
            
            
            
        </table>
        
        
        </header>
        <main>
            
        </main>
        
        
        <%
        }
        %>
        
        
        
    </body>
</html>
