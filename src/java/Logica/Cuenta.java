package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuenta implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCuenta;
    @Basic
    private String usuario;
    private String contrasenia;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, String usuario, String contrasenia) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
   
    
    
}
