/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lk.Entity.dt;

import co.com.lk.Entity.Master.TbUiUsuario;
import co.com.lk.Entity.ma.Dtecassucursal;
import co.com.lk.Entity.ma.Dtmatipofactura;
import co.com.lk.Entity.ma.Dttercero;
import co.com.lk.Entity.ma.Dtterceroruta;
import co.com.lk.Entity.ma.Dtmamediotransporte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

/**
 *
 * @author lukhack
 */
@Entity
@Table(name = "dtfactura", schema = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtfactura.findAll", query = "SELECT d FROM Dtfactura d ORDER BY d.fecha DESC"),
    @NamedQuery(name = "Dtfactura.findById", query = "SELECT d FROM Dtfactura d WHERE d.id = :id"),
    @NamedQuery(name = "Dtfactura.findECA", query = "SELECT d FROM Dtfactura d WHERE d.dtEcassucursalid.id = ?0 and d.dtTipoFacturaid.id = ?1 ORDER BY d.fecha DESC,d.consecutivo DESC"),
    @NamedQuery(name = "Dtfactura.findByFecha", query = "SELECT d FROM Dtfactura d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Dtfactura.findByHora", query = "SELECT d FROM Dtfactura d WHERE d.hora = :hora"),
    @NamedQuery(name = "Dtfactura.findByConsecutivo", query = "SELECT d FROM Dtfactura d WHERE d.consecutivo = :consecutivo"),
    @NamedQuery(name = "Dtfactura.findByDescripcion", query = "SELECT d FROM Dtfactura d WHERE d.descripcion = :descripcion")})
public class Dtfactura implements Serializable, Cloneable {
    private static final String FINDALL="Dtfactura.findAll";
    private static final String FINDALLXECA="Dtfactura.findECA";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    
    private Date hora;
    @Size(max = 45)
    @Column(name = "consecutivo")
    private String consecutivo;
    @Size(max = 15)
    @Column(name = "consManual")
    private String consManual;
    
    
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Size(max = 1)
    @Column(name = "horario")
    private String horario="D";
    
    
    @Column(name = "subTotal")
    private Double subTotal;
    
    @Column(name = "descuento")
    private Double descuento=0.0;
    
    
    @Column(name = "totalClasificacino")
    private Double totalClasificacino=0.0;
    
    @Column(name = "total")
    private Double total;
    
    @Column(name = "placavehiculo")
    private String placavehiculo;
    
    @JoinColumn(name = "dtEcassucursal_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Dtecassucursal dtEcassucursalid;
    
    
    
    
    @JoinColumn(name = "dtTipoFactura_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Dtmatipofactura dtTipoFacturaid;
    
    @JoinColumn(name = "dtmaEstadoFactura_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dtmaestadofactura dtmaEstadoFacturaid;
    
    @JoinColumn(name = "dttercero_id", referencedColumnName = "id",nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Dttercero tercero;
    
    @JoinColumn(name = "dtRuta_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Dtterceroruta terceroRuta;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TbUiUsuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtFacturaVentaid", fetch = FetchType.LAZY)
    private List<Dtfacturadetalle> dtfacturadetalleList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtFactura", fetch = FetchType.LAZY)
    private List<DtfacturaImagenes> dtfacturaImagenesList;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = true)
    @JoinTable(name = "pr_resiborecoleccion_facturacompra", schema = "procesos",
        joinColumns = {@JoinColumn(name="idfactura", referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="idresibo", referencedColumnName="id")})
    @LazyToOne(value = LazyToOneOption.NO_PROXY)
    private Dtfactura facturaRelacion; 
     
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "dttransporte_id", referencedColumnName = "id")
    @Fetch(FetchMode.SELECT)
    Dtmamediotransporte dttransporte_id;
    
    
    
    @Transient
    public Date fechaRecoleccion;
    
    public Dtfactura() {
        dtfacturadetalleList=new ArrayList<>();
        dtfacturaImagenesList=new ArrayList<>();
    }

    public Dtfactura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dtecassucursal getDtEcassucursalid() {
        return dtEcassucursalid;
    }

    public void setDtEcassucursalid(Dtecassucursal dtEcassucursalid) {
        this.dtEcassucursalid = dtEcassucursalid;
    }

    public Dtmatipofactura getDtTipoFacturaid() {
        return dtTipoFacturaid;
    }

    public void setDtTipoFacturaid(Dtmatipofactura dtTipoFacturaid) {
        this.dtTipoFacturaid = dtTipoFacturaid;
    }

    public Dtmaestadofactura getDtmaEstadoFacturaid() {
        return dtmaEstadoFacturaid;
    }

    public void setDtmaEstadoFacturaid(Dtmaestadofactura dtmaEstadoFacturaid) {
        this.dtmaEstadoFacturaid = dtmaEstadoFacturaid;
    }

    public Dttercero getTercero() {
        return tercero;
    }

    public void setTercero(Dttercero tercero) {
        this.tercero = tercero;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public TbUiUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUiUsuario usuario) {
        this.usuario = usuario;
    }

    public Dtterceroruta getTerceroRuta() {
        return terceroRuta;
    }

    public void setTerceroRuta(Dtterceroruta terceroRuta) {
        this.terceroRuta = terceroRuta;
    }

    public String getConsManual() {
        return consManual;
    }

    public void setConsManual(String consManual) {
        this.consManual = consManual;
    }

    public List<DtfacturaImagenes> getDtfacturaImagenesList() {
        return dtfacturaImagenesList;
    }

    public void setDtfacturaImagenesList(List<DtfacturaImagenes> dtfacturaImagenesList) {
        this.dtfacturaImagenesList = dtfacturaImagenesList;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(String placavehiculo) {
        this.placavehiculo = placavehiculo;
    }
    
    
    
    
    public Object cloneObj(){
        Dtfactura objClone= new Dtfactura();
        Dtfactura factura=this;
        try{
            
            objClone.setId(null); 
            objClone.setConsManual(null);
            objClone.setConsecutivo(null);
            objClone.setDescripcion(factura.getDescripcion());
            
            objClone.setDescuento(factura.getDescuento());
            objClone.setDtEcassucursalid(factura.getDtEcassucursalid());
            objClone.setDtTipoFacturaid(null);
            objClone.setDtfacturaImagenesList(new ArrayList<>());
            objClone.setDtfacturadetalleList(new ArrayList<>());
            objClone.setDtmaEstadoFacturaid(factura.getDtmaEstadoFacturaid());
            objClone.setDttransporte_id(factura.getDttransporte_id());
            //objClone.setFacturaRelacion(factura);
            
                    
            objClone.setSubTotal(factura.getSubTotal());
            objClone.setTotal(factura.getTotalClasificacino());
            objClone.setTotal(factura.getTotal());
            
            
            List<Dtfacturadetalle> detalleList=new ArrayList<>();
            
            
            this.getDtfacturadetalleList().stream().forEach(x->{
                Dtfacturadetalle detalle = new Dtfacturadetalle();
                detalle.setCantidad(x.getCantidad());
                detalle.setClasificacion(x.getClasificacion());
                detalle.setDescripcion(x.getClasificacion());
                detalle.setDtFacturaVentaid(objClone);
                detalle.setIva(x.getIva());
                detalle.setMaterialid(x.getMaterialid());
                detalle.setSubTotal(x.getSubTotal());
                detalle.setValor(x.getValor());
                
                List<Dtfacturadetallematerial> detalleMaList=new ArrayList<>();
                x.getDtFacturaDetalle().stream().forEach(r->{
                    Dtfacturadetallematerial detalleMaterial = new Dtfacturadetallematerial();
                    detalleMaterial.setCantidad(r.getCantidad());
                    detalleMaterial.setFacturaDetalle(x);
                    detalleMaterial.setMaterialid(r.getMaterialid());
                    detalleMaterial.setValor(r.getValor());
                    detalleMaList.add(detalleMaterial);
                });
                
                detalle.setDtFacturaDetalle(detalleMaList);
                
                detalleList.add(detalle);
            }); 
            
            objClone.setDtfacturadetalleList(detalleList);
            
        }catch(Exception ex){
            System.out.println(" no se puede duplicar");
        }
        
        return objClone;
    }
    
    
    @XmlTransient
    public List<Dtfacturadetalle> getDtfacturadetalleList() {
        return dtfacturadetalleList;
    }

    public void setDtfacturadetalleList(List<Dtfacturadetalle> dtfacturadetalleList) {
        this.dtfacturadetalleList = dtfacturadetalleList;
    }

    public Double getTotalClasificacino() {
        return totalClasificacino;
    }

    public void setTotalClasificacino(Double totalClasificacino) {
        this.totalClasificacino = totalClasificacino;
    }


    public Dtfactura getFacturaRelacion() {
        return facturaRelacion;
    }

    public void setFacturaRelacion(Dtfactura facturaRelacion) {
        this.facturaRelacion = facturaRelacion;
    }

    public Dtmamediotransporte getDttransporte_id() {
        return dttransporte_id;
    }

    public void setDttransporte_id(Dtmamediotransporte dttransporte_id) {
        this.dttransporte_id = dttransporte_id;
    }

    public Date getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public void setFechaRecoleccion(Date fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtfactura)) {
            return false;
        }
        Dtfactura other = (Dtfactura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
    
    

    @Override
    public String toString() {
        return "co.com.lk.Entity.dt.Dtfactura[ id=" + id + " ]";
    }
    
}
