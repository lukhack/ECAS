/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lukhack
 */
@Embeddable
public class DtrespuestazPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Form")
    private int form;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hogar")
    private int hogar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Persona")
    private int persona;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CodPreg")
    private String codPreg;
    
    

    public DtrespuestazPK() {
    }

    public DtrespuestazPK(int form, int hogar, int persona, String codPreg) {
        this.form = form;
        this.hogar = hogar;
        this.persona = persona;
        this.codPreg = codPreg;
    }

    
    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public int getHogar() {
        return hogar;
    }

    public void setHogar(int hogar) {
        this.hogar = hogar;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getCodPreg() {
        return codPreg;
    }

    public void setCodPreg(String codPreg) {
        this.codPreg = codPreg;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) form;
        hash += (int) hogar;
        hash += (int) persona;
        hash += (codPreg != null ? codPreg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DtrespuestazPK)) {
            return false;
        }
        DtrespuestazPK other = (DtrespuestazPK) object;
        if (this.form != other.form) {
            return false;
        }
        if (this.hogar != other.hogar) {
            return false;
        }
        if (this.persona != other.persona) {
            return false;
        }
        if ((this.codPreg == null && other.codPreg != null) || (this.codPreg != null && !this.codPreg.equals(other.codPreg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.lk.Entity.DtrespuestazPK[ form=" + form + ", hogar=" + hogar + ", persona=" + persona + ", codPreg=" + codPreg + " ]";
    }
    
}
