package co.com.aptamob.security.bo;

import javax.persistence.*;

import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="PERFILES")
public class Perfil extends BaseEntity{
	@Column(name="PER_TIPODOC")
	private String tipoDcto;
	
	@Column(name="PER_NUMDOC")
	private String numDcto;
	
	@Column(name="PER_NOMBRES")
	private String nombres;
	
	@Column(name="PER_APELLIDOS")
	private String apellidos;
	
	@Column(name="PER_SEXO")
	private String sexo;
	
	@Column(name="PER_EMAIL")
	private String mail;
	
	@Column(name="PER_TELEFONO")
	private String telefono;
	
	@Column(name="PER_MOVIL")
	private String movil;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Usuario usuario;
	
	public Perfil(){}

	public String getTipoDcto() {
		return tipoDcto;
	}

	public void setTipoDcto(String tipoDcto) {
		this.tipoDcto = tipoDcto;
	}

	public String getNumDcto() {
		return numDcto;
	}

	public void setNumDcto(String numDcto) {
		this.numDcto = numDcto;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
