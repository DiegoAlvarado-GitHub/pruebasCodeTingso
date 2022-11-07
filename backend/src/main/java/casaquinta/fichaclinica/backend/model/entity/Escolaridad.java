package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "escolaridad")
public class Escolaridad implements Serializable{
	@Id
	@Column(name = "id_escolaridad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;

	private String nivel;

	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_ficha_clinica")
	private FichaClinica fichaClinica;

	// -------- Getters and Setters --------

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}






}
