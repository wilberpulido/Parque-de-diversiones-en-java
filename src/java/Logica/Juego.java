package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Juego implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idJuego;
    @Basic
    private String nombreJuego;
    private int capacidadTurno;
    @OneToMany
    List<Empleado> empleadoLista;

    public Juego() {
    }

    public Juego(int idJuego, String nombreJuego, int capacidadTurno, List<Empleado> empleadoLista, List<Entrada> entradaLista) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.capacidadTurno = capacidadTurno;
        this.empleadoLista = empleadoLista;

    }

    public int getIdJuego() {
        return idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public int getCapacidadTurno() {
        return capacidadTurno;
    }

    public List<Empleado> getEmpleadoLista() {
        return empleadoLista;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public void setCapacidadTurno(int capacidadTurno) {
        this.capacidadTurno = capacidadTurno;
    }

    public void setEmpleadoLista(List<Empleado> empleadoLista) {
        this.empleadoLista = empleadoLista;
    }

}
