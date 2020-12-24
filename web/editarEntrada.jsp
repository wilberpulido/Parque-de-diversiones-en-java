<%@page import="Logica.FormatoFechas"%>
<%@page import="Logica.Entrada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Entrada</title>
    </head>
    <body>
        <%
        HttpSession miSession = request.getSession();
        String usuario = (String) request.getSession().getAttribute("usuario");
        
        if(usuario == null){
        %>
        <h1>Login</h1>

        <form action="LoginServlets" method="POST">
            
            <label> Usuario </label>
            <input required type="text" name="usuario" />
            
            <label> Contraseña </label>
            <input required type="password" name="contrasenia" />
            
            <button type="submit"> Enviar </button>               
        </form>
        <br>
        <br>
            <a href="CondicionesIniciales"> Establecer condiciones iniciales, dar un solo click </a>

        <%}
            else{
        %>
        
        <header>
            
        <h1>Editar entrada</h1>
        <br>
        </header>
        <main>
            <%
            Entrada EntradaEditar = (Entrada) miSession.getAttribute("editarEntrada");
            %>

            <h2><%= FormatoFechas.DateAString(EntradaEditar.getFechaEntrada())%></h2>
            
            <form style="width: 500px;" action="editarEntradaForm" method="POST">
                
                <h2 style="text-align: center;">Datos del cliente</h2>
         
                <label for="nombreCliente">Nombre: </label>
                <input value=<%=EntradaEditar.getEntradaCliente().getNombre()%> required name="nombreCliente" id="nombreCliente"/>
                <br>
                <br>
                <label for="apellidoCliente">Apellido: </label>
                <input value=<%=EntradaEditar.getEntradaCliente().getApellido()%> required name="apellidoCliente" id="apellidoCliente"/>
                <br>
                <br>
                <label for="dniCliente">Dni: </label>
                <input value=<%=EntradaEditar.getEntradaCliente().getDni()%> required name="dniCliente" id="dniCliente"/>

                <h2 style="text-align: center;">Entrada solicitada</h2>
                
                <label for="fechaEntrada">fecha de entrada: </label>
                <input value=<%=FormatoFechas.DateAString(EntradaEditar.getFechaEntrada())%> type="date" name="fechaEntrada" id="fechaEntrada"/>
                <br>
                <br>
                <label for="horaEntrada">hora de entrada: </label>
                <input value=<%=FormatoFechas.DateHoraAString(EntradaEditar.getHoraEntrada())%> required type="time" name="horaEntrada" id="horaEntrada"/>
                <br>
                <br>
                <label for="idJuego">Juego seleccionado: </label>
                <select required name="idJuego" id="idJuego">
                    <option selected value= <%=EntradaEditar.getEntradaJuego().getIdJuego()%>><%=EntradaEditar.getEntradaJuego().getNombreJuego()%></option>
                    <option value="1">Rueda de la fortuna</option>
                    <option value="2">Montaña Rusa</option>
                </select>
                
                <button type="submit" >Enviar</button>              
            </form>

            
            <a href="MostrarEntradasRegistradas.jsp">Registro de entradas</a>
            
            
        </main>
        
        
        <%
        }
        %>
    </body>
    
</html>

