package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "sesion")
public class Sesion implements Serializable{
	@Id
	@Column(name = "id_sesion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fecha;

	private String profesional;

	private String objetivo_actividad;

	private String indicacion_cuidadores;

	private String observaciones;

	private Boolean privada; // privacidad de la sesión

	private String tipo_sesion; //terapia

	private Boolean formato_presencial;

	private Boolean acompanado;



	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_ficha_clinica")
	private FichaClinica fichaClinica;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_terapia")
	private Terapia terapia;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	// ------- Getters and Setters -------

	public Boolean getFormato_presencial() {
		return formato_presencial;
	}

	public void setFormato_presencial(Boolean formato_presencial) {
		this.formato_presencial = formato_presencial;
	}

	public Boolean getAcompanado() {
		return acompanado;
	}

	public void setAcompanado(Boolean acompanado) {
		this.acompanado = acompanado;
	}
	
	public String getProfesional() {
		return profesional;
	}

	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}

	public String getObjetivo_actividad() {
		return objetivo_actividad;
	}

	public void setObjetivo_actividad(String objetivo_actividad) {
		this.objetivo_actividad = objetivo_actividad;
	}

	public String getIndicacion_cuidadores() {
		return indicacion_cuidadores;
	}

	public void setIndicacion_cuidadores(String indicacion_cuidadores) {
		this.indicacion_cuidadores = indicacion_cuidadores;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Boolean getPrivada() {
		return privada;
	}

	public void setTipo_sesion(String tipo_sesion) {
		this.tipo_sesion = tipo_sesion;
	}

	public long getId() {
		return id;
	}

	public FichaClinica obtnerFichaClinica(){
		return fichaClinica;
	}

	public long getFichaClinica() {
		return fichaClinica.getRut();
	}

	public Long getTerapia() {
		return terapia.getId();
	}

	public Long getUsuario() {
		return usuario.getId();
	}

	public void setPrivada(Boolean privada) {
		this.privada = privada;
	}

	public String getTipo_sesion() {
		return tipo_sesion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setFichaClinica(FichaClinica fichaClinica) {
		this.fichaClinica = fichaClinica;
	}

	public void setTerapia(Terapia terapia) {
		this.terapia = terapia;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
