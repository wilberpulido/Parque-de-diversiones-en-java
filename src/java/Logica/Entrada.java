
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
public class Entrada implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEntrada;
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @OneToOne
    private Cliente entradaCliente;
    @OneToOne
    private Juego entradaJuego;

    public Entrada() {
    }

    public Entrada(int idEntrada, Date fechaEntrada, Date horaEntrada, Cliente entradaCliente, Juego entradaJuego) {
        this.idEntrada = idEntrada;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.entradaCliente = entradaCliente;
        this.entradaJuego = entradaJuego;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public Cliente getEntradaCliente() {
        return entradaCliente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    
        public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public void setEntradaCliente(Cliente entradaCliente) {
        this.entradaCliente = entradaCliente;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Juego getEntradaJuego() {
        return entradaJuego;
    }

    public void setEntradaJuego(Juego entradaJuego) {
        this.entradaJuego = entradaJuego;
    }
  
    
    
}
