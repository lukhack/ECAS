/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.Master;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Likas
 * clase de tipo POJO plain olg java object.
 */


@NamedQueries({
    @NamedQuery(name = "IUConfigForm.FindALL", query = "SELECT U FROM IUConfigForm U "),
})
@Entity
@Table(name = "uiconfigform", schema = "maestros")
public class IUConfigForm implements  Serializable{
    
    private static final String FINDALL="IUConfigForm.FindALL";
        
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long Id;  
     
    @Column(name = "labelNombre")
    private String labelNombre;
     
    @Column(name = "nameId")
    private String nameId;
    
    @Column(name = "parameterValor")
    private String parameterValue;
     
    @Column(name = "valor")
    private String valor;
     
    @Column(name = "maximoValue")
    private String maxValue;
     
    @Column(name = "requerido")
    private boolean requerido;
     
    @Column(name = "mascara",nullable = true)
    private String mask;
     
    @Column(name = "messageError")
    private String messageError;
     
     
    @ManyToOne
    @JoinColumn(name = "tipo",referencedColumnName = "id",insertable = true,updatable = true)
    private IUConfig tipo;

    
    @ManyToOne
    @JoinColumn(name = "tipoCampo",referencedColumnName = "id",insertable = true,updatable = true)
    private IUConfigTipoCampo tipoCampo;
    
    public IUConfigForm() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getLabelNombre() {
        return labelNombre;
    }

    public void setLabelNombre(String labelNombre) {
        this.labelNombre = labelNombre;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public boolean getRequerido() {
        return requerido;
    }

    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }

    public IUConfig getTipo() {
        return tipo;
    }

    public void setTipo(IUConfig tipo) {
        this.tipo = tipo;
    }

    

    public IUConfigTipoCampo getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(IUConfigTipoCampo tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }
    
        
    
}
