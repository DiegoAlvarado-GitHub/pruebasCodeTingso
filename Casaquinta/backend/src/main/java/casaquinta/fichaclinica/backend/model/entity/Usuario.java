package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	@Id
	@Column(name = "rut_usuario")
	private long id;

	private String nombre;

	private String apellidos;

	private String correo;

	private String especialidad;
	
	private String password;


    @ManyToMany
	// tabla intermedia
	// id_usuario = rut
	@JoinTable(name = "usuario_anamnesis"
			,joinColumns = @JoinColumn(name = "id_usuario")
			,inverseJoinColumns = @JoinColumn(name = "id_anamnesis"))
	private Set<Anamnesis> anamnesis;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Sesion> sesiones;


	@ManyToMany
	// tabla intermedia
	// id_usuario = rut
	@JoinTable(name = "usuario_terapia"
			,joinColumns = @JoinColumn(name = "id_usuario")
			,inverseJoinColumns = @JoinColumn(name = "id_terapia"))
	private List<Terapia> terapias;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<MotivoConsulta> motivo_consultas;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_rol")
	private Rol rol;

	// ------- Getters and Setters -------

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public long getId() {
		return id;
	}


	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public List<Terapia> getTerapias() {
		return terapias;
	}

}
