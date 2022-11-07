package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "terapia")
public class Terapia implements Serializable{
	@Id
	@Column(name = "id_terapia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;

	private String tipo_terapia;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "terapia")
	private List<Sesion> sesiones;

	// ------- Getters and Setters -------

	public String getTipo_terapia() {
		return tipo_terapia;
	}

	public void setTipo_terapia(String tipo_terapia) {
		this.tipo_terapia = tipo_terapia;
	}

	public long getId() {
		return id;
	}
}
