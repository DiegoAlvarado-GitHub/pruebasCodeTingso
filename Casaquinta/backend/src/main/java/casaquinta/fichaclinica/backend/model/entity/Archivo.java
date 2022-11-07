package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "archivo")
public class Archivo implements Serializable{
	@Id
	@Column(name = "id_motivo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;

	private String nombre;

	private String link_archivo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_ficha_clinica")
	private FichaClinica fichaClinica;


	// ------- Getters and Setters -------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLink_archivo() {
		return link_archivo;
	}

	public void setLink_archivo(String link_archivo) {
		this.link_archivo = link_archivo;
	}


}
