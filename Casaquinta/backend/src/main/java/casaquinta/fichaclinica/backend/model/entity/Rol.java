package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;

	private String tipo_rol;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	private List<Usuario> usuarios;

	// ------- Getters and Setters -------

	public String getTipo_rol() {
		return tipo_rol;
	}

	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}

	public long getId() {
		return id;
	}

	// public List<Usuario> getUsuarios() {
	// 	return usuarios;
	// }

	public void setId(long id) {
		this.id = id;
	}




}
