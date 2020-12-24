
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controladora {
    
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public Cuenta crearCuenta(String nombreUsuario, String contrasenia){
        
        Cuenta cuentaEmpleado = new Cuenta();
        cuentaEmpleado.setUsuario(nombreUsuario);
        cuentaEmpleado.setContrasenia(contrasenia);
        
        controlPersis.crearCuenta(cuentaEmpleado);
        
        return cuentaEmpleado;
    }
    public Empleado crearEmpleado(String nombreEmpleado, String apellidoEmpleado, String dni, Cuenta cuentaEmpleado){
        
        Empleado empleado = new Empleado();
        empleado.setNombre(nombreEmpleado);
        empleado.setApellido(apellidoEmpleado);
        empleado.setDni(dni);
        empleado.setMicuenta(cuentaEmpleado);
        
        controlPersis.crearEmpleado(empleado);
        
        return empleado;
    }
    public Juego crearJuego(String nombreJuego, int capacidad,List empleadoLista){
        
        Juego juegoNuevo = new Juego();
        juegoNuevo.setNombreJuego(nombreJuego);
        juegoNuevo.setCapacidadTurno(capacidad);
        juegoNuevo.setEmpleadoLista(empleadoLista);

        controlPersis.createJuego(juegoNuevo);
        
        return juegoNuevo;
    }
    
    public void crearHorario(Date horaInicio,Date horaCierre, Juego juego){
        
        Horario nuevoHorario = new Horario();
       
        nuevoHorario.setHoraInicio(horaInicio);
        nuevoHorario.setHoraCierre(horaCierre);
        nuevoHorario.setJuego(juego);
        
        controlPersis.crearHorario(nuevoHorario);
    }   
    public void crearEntrada(Date fechaEntrada,Date horaEntrada,Cliente entradaCliente,Juego entradaJuego){
        
        Entrada nuevaEntrada = new Entrada();
        
        nuevaEntrada.setFechaEntrada(fechaEntrada);
        nuevaEntrada.setHoraEntrada(horaEntrada);
        nuevaEntrada.setEntradaCliente(entradaCliente);
        nuevaEntrada.setEntradaJuego(entradaJuego);
        
        controlPersis.crearEntrada(nuevaEntrada);
    }
    public Cliente crearCliente(String nombreCliente,String apellidoCliente, String dniCliente){
        
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setNombre(nombreCliente);
        nuevoCliente.setApellido(apellidoCliente);
        nuevoCliente.setDni(dniCliente);
        
        controlPersis.crearCliente(nuevoCliente);
        
        return nuevoCliente;
    }
        
    
    
    
    public boolean comprobarIngreso(String usuario, String contrasenia) {
        
        List <Cuenta> cuentasEmpleados = new ArrayList<>();
     
        cuentasEmpleados = controlPersis.getCuentas();
        
        for(Cuenta cuentas: cuentasEmpleados ){
            
            if(cuentas.getUsuario().equals(usuario) && cuentas.getContrasenia().equals(contrasenia)){
                return true;
            }
        }
        
        //no consiguie nada y devuelve false
        return false;
 
    }
    public Juego buscarJuegoPorId(int idJuego) {
   
    return controlPersis.getJuegoPorId(idJuego);
    
    }

    public Horario getHorarioJuego(int idJuego) {
        
        return  controlPersis.getHorarioJuego(idJuego);        
   
    }


    public List<Entrada> getTodasLasEntradas(){
        
        return controlPersis.getEntradas();
        
    }

    public void borraEntradaPorID(int idEntrada) {
        controlPersis.deleteEntradaPorID(idEntrada);
    }

    public Entrada buscarEntradaPorId(int idEditar) {
        return controlPersis.buscarEntradaPorId(idEditar);
    }
    
    
    
}
