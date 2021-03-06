package co.com.aptamob.core.bo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import co.com.aptamob.core.api.PrecioPropiedadApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="PRECIOS_PROPIEDAD")
public class PrecioPropiedad extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "PRO_ID")
	private Propiedad propiedad;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	@Column(name="PPR_FECHA_INI")
	private Date desde;

	@Column(name="PPR_FECHA_FIN")
	private Date hasta;
	
	@Column(name="PPR_DIA")
	private BigDecimal diario;
	
	@Column(name="PPR_MES")
	private BigDecimal mensual;
	
	public PrecioPropiedad(){
		this.propiedad = new Propiedad();
		this.estado = new Estado();
		this.desde = new Date();
		this.hasta = new Date();
	}
	
	public PrecioPropiedad(PrecioPropiedadApi api){
		this();
		this.estado.setId(Long.parseLong(api.getEstado().getId()));
		this.desde = formatoFecha(api.getFecha_inicio());
		this.hasta = formatoFecha(api.getFecha_fin());
		this.diario = new BigDecimal(api.getDiario());
		this.mensual = new BigDecimal(api.getMensual());
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public BigDecimal getDiario() {
		return diario;
	}

	public void setDiario(BigDecimal diario) {
		this.diario = diario;
	}

	public BigDecimal getMensual() {
		return mensual;
	}

	public void setMensual(BigDecimal mensual) {
		this.mensual = mensual;
	}
	
	private Date formatoFecha(String fecha){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fechaR = new Date();
		try {
			fechaR = formatter.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaR;
	}
}
