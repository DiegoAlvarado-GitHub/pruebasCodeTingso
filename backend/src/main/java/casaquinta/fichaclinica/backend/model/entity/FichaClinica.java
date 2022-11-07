package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ficha_clinica")
public class FichaClinica implements Serializable{
	@Id
	@Column(name = "id_ficha_clinica")
	private long rut;

	private String nombre;

	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fecha_nacimiento;

	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fecha_ingreso;

	private String direccion;

	private String comuna;

	private String telefono;

	private String correo;

	private String nivel_escolaridad;

	private String terapias_recibidas;


	@OneToOne
	private Anamnesis anamnesis;

	@ManyToMany
	// tabla intermedia
	@JoinTable(name = "ficha_clinica_terapia"
			,joinColumns = @JoinColumn(name = "id_ficha_clinica")
			,inverseJoinColumns = @JoinColumn(name = "id_terapia"))
	private List<Terapia> terapias;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fichaClinica")
	private List<Sesion> sesiones;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fichaClinica")
	private List<Archivo> archivos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fichaClinica")
	private List<Escolaridad> escolaridades;


	// ------- Getters and Setters -------

	public String getNombre() {
		return nombre;
	}

	public List<Terapia> getTerapias() {
		return terapias;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel_escolaridad() {
		return nivel_escolaridad;
	}

	public void setNivel_escolaridad(String nivel_escolaridad) {
		this.nivel_escolaridad = nivel_escolaridad;
	}

	public String getTerapias_recibidas() {
		return terapias_recibidas;
	}

	public void setTerapias_recibidas(String terapias_recibidas) {
		this.terapias_recibidas = terapias_recibidas;
	}

	public long getRut() {
		return this.rut;
	}

	public void setRut(Long rut) {
		this.rut = rut;
	}

	public Date getFecha_nacimiento(){
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento){
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_ingreso(){
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso){
		this.fecha_ingreso = fecha_ingreso;
	}

  public String getDireccion() {
      return direccion;
  }

  public void setDireccion(String direccion) {
      this.direccion = direccion;
  }

  public String getComuna() {
      return comuna;
  }

  public void setComuna(String comuna) {
      this.comuna = comuna;
  }

  public String getTelefono() {
      return telefono;
  }

  public void setTelefono(String telefono) {
      this.telefono = telefono;
  }

  public String getCorreo() {
      return correo;
  }

  public void setCorreo(String correo) {
      this.correo = correo;
  }
  
  
}
