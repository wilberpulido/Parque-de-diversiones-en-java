package Persistencia;

import Logica.Cliente;
import Logica.Cuenta;
import Logica.Empleado;
import Logica.Entrada;
import Logica.Horario;
import Logica.Juego;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    ClienteJpaController clienteJPA = new ClienteJpaController();
    CuentaJpaController cuentaJPA = new CuentaJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    EntradaJpaController entradaJPA = new EntradaJpaController();
    HorarioJpaController horarioJPA = new HorarioJpaController();
    JuegoJpaController juegoJPA = new JuegoJpaController();
    
    public void crearCliente (Cliente cliente){
        
        clienteJPA.create(cliente);
        
    }
    public void crearCuenta (Cuenta cuentaEmpleado){
    
        cuentaJPA.create(cuentaEmpleado);
        
    }
    public void crearEmpleado (Empleado empleado){
        
        empleadoJPA.create(empleado);
        
    }
    public void crearEntrada(Entrada entrada){
        
        entradaJPA.create(entrada);
        
    }
    public void crearHorario(Horario horarioJuego){
        
        try {
            horarioJPA.create(horarioJuego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void createJuego(Juego juego){
        
        try {
            juegoJPA.create(juego);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Cuenta> getCuentas() {
   
        return cuentaJPA.findCuentaEntities();
    }

    public Juego getJuegoPorId(int idJuego) {
        return juegoJPA.findJuego(idJuego);
    }

    public Horario getHorarioJuego(int idJuego) {

        List<Horario> todosLosHorarios = horarioJPA.findHorarioEntities();
        Horario horarioJuego = null;
        
        for(Horario horario: todosLosHorarios){
            
            if (horario.getJuego().getIdJuego() == idJuego) {
                
             return horario;   
            }
            
        }
        return horarioJuego;
    }

    public List<Entrada> getEntradas(){
        return entradaJPA.findEntradaEntities();
    }
    
    public void deleteEntradaPorID(int idEntrada) {
        try {
            entradaJPA.destroy(idEntrada);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Entrada buscarEntradaPorId(int idEditar) {
        return entradaJPA.findEntrada(idEditar);
    }
    
}
