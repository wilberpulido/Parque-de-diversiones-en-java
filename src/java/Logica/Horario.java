package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Horario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idHorario;
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @OneToOne
    private Juego juego;

    public Horario() {
    }

    public Horario(int idHorario, Date horaInicio, Date horaCierre, Juego juego) {
        this.idHorario = idHorario;
        this.horaInicio = horaInicio;
        this.horaCierre = horaCierre;
        this.juego = juego;
    }

    
    
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }


    public int getIdHorario() {
        return idHorario;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }


    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    
}
