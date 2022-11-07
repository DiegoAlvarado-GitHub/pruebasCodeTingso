package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "motivo_consulta")
public class MotivoConsulta implements Serializable {

	@Id
	@Column(name = "id_motivo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;

	private String motivo;

	private String inicio_sintomas;

	private String diagnosticos_terapias_previas;

	private String profesional_entrevistador;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id_anamnesis")
	private Anamnesis anamnesis;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "rut_usuario")
	private Usuario usuario;

	// -------- Getters and Setters --------
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getInicio_sintomas() {
		return inicio_sintomas;
	}

	public void setInicio_sintomas(String inicio_sintomas) {
		this.inicio_sintomas = inicio_sintomas;
	}

	public String getDiagnosticos_terapias_previas() {
		return diagnosticos_terapias_previas;
	}

	public void setDiagnosticos_terapias_previas(String diagnosticos_terapias_previas) {
		this.diagnosticos_terapias_previas = diagnosticos_terapias_previas;
	}

	public String getProfesional_entrevistador() {
		return profesional_entrevistador;
	}

	public void setProfesional_entrevistador(String profesional_entrevistador) {
		this.profesional_entrevistador = profesional_entrevistador;
	}





}
