<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
            
        <h1>Bienvenido al registro de entradas <%= usuario %></h1>
        <br>
        <br>
        <a href="LogoutSessionServlets"> logout</a>
        </header>
        <main>
            <form style="width: 500px;" action="RegistroEntradas" method="POST">
                
                <h2 style="text-align: center;">Datos del cliente</h2>
         
                <label for="nombreCliente">Nombre: </label>
                <input required name="nombreCliente" id="nombreCliente"/>
                <br>
                <br>
                <label for="apellidoCliente">Apellido: </label>
                <input required name="apellidoCliente" id="apellidoCliente"/>
                <br>
                <br>
                <label for="dniCliente">Dni: </label>
                <input required name="dniCliente" id="dniCliente"/>

                <h2 style="text-align: center;">Entrada solicitada</h2>
                
                <label for="fechaEntrada">fecha de entrada: </label>
                <input required type="date" name="fechaEntrada" id="fechaEntrada"/>
                <br>
                <br>
                <label for="horaEntrada">hora de entrada: </label>
                <input required type="time" name="horaEntrada" id="horaEntrada"/>
                <br>
                <br>
                <label for="idJuego">Juego seleccionado: </label>
                <select required name="idJuego" id="idJuego">
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
