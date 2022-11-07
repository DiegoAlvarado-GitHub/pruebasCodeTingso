package casaquinta.fichaclinica.backend.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.format.annotation.*;

@Entity
@Table(name = "anamnesis")
public class Anamnesis implements Serializable{

	@Id
	@Column(name = "id_anamnesis")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> incremento automático y permite que se genere un nuevo valor con cada operación de inserción
	private long id;
        
        // IDENTIFICACIÓN DEL MENOR
        
        // -- EDAD A LA FECHA
        private ArrayList<Integer> edad_actual; // representación --> [años, meses] sujeta a cambios
        // -- FECHA DE ANAMNESIS
        @Column(name = "fecha_anamnesis")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fecha_anamnesis;
        // -- NOMBR INFORMANTE Y PARENTESCO
        private String nombre_informante;
        // -- PROFESIONAL ENTREVISTADOR
        private ArrayList<String> profesional_entrevistador; // pueden haber dos o mas profesionales a la vez? se deja provisoriamente como lista
        
        // IDENTIFICACIÓN FAMILIAR
        
	// -- MAMÁ
	private String nombre_mama;
	@Column(name = "fecha_nacimiento_mama")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fecha_nacimiento_mama;
	private String ocupacion_mama;
	private String estado_civil_mama;
	// -- PAPÁ
	private String nombre_papa;
	@Column(name = "fecha_nacimiento_papa")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date fecha_nacimiento_papa;
	private String ocupacion_papa;
	private String estado_civil_papa;
        // -- HERMANOS
        private String respuesta; // casillas si o no
        // representación [jose, pepito] [10, 8] sujeto a cambio
	private String hermanos;
        //private List<Integer> edad_hermanos;
	private String grupo_familiar;
	private String cuidador_principal;
        
        // ANTECEDENTES RELEVANTES
        
        // -- ANTECENTES PRE-PERI-POST NATALES
        private ArrayList<String> complicaciones_embarazo; // pueden ser selección múltiple y además "otros" por eso es una lista
        private String ingesta_farmacos;
        private String tipo_farmacos; // Cuáles
        private Integer semanas_gestacion;
        private String tipo_parto;
        private ArrayList<String> complicaciones_parto; // pueden ser selección múltiple y además "otros" por eso es una lista
        // -- ANTECEDENTES FAMILIARES
        private ArrayList<String> antecedentes_familiares; // pueden ser selección múltiple y además "otros" por eso es una lista
        private String especificacion;
        // -- ANTECEDENTES MÓRBIDOS DEL USUARIO
        private String enfermedades_importantes;
        private String cirugias;
        private String alergias;
        private String hospitalizaciones;
        private String farmacos;
        private String otros;
        
        // ANTECEDENTES DEL COMPORTAMIENTO
        
        // -- ANTECEDENTES PSICOSOCIALES
        private String apreciacion_informante; // selección multiple o unica?
        private String especificacion1;
        private String relaciones_interpersonales;
        private String especificacion2;
        private String comportamiento_casa;
        private String especificacion3;
        // -- JUEGO
        private String juego; //solo o acompañado
        private String tipo_juego; // selección multiple o unica?
        private Integer horas_juego; // dejarlo como entero, tipo de dato tiempo o string?
        private String intereses;
        
        // ANTECEDENTES ESCOLARES
        
        // -- ESTABLECIMIENTO
        private String nombre_est; // est = establecimiento
        private String comuna_est;
        private String tipo_est;
        private String modalidad_est; // onlina, presencial, mixta
        private String horario;
        // -- CURSO ACTUAL
        private String curso_actual; // string o entero?
        // -- REPITENCIA DEL CURSO
        private String repitencia; // si o no
        private String curso_repitencia;
        private String anio_repitencia;
        // -- RENDIMIENTO
        private String lectura_escritura;
        private String dificultad_atencional_SN; // si o no
        private String dificultad_atencion_CS; // con o sin
        private String hiperactividad_SN; // si o no
        private String hiperactividad_CS; // si o no
        // -- EDAD DE INICIO ESCOLARIDAD
        private String inicio_escolaridad;
        
        // ANTECEDENTES DEL DESARROLLO
        
        // -- DESARROLLO PSICOMOTOR
        private String cefalico;
        private String sedestacion;
        private String gateo;
        private String marcha_independiente;
        private String control_esfinter;
        private String edad_control_esf;
        private String especificacion4;
        // -- DESARROLLO DE LENGUAJE
        private String edad_primeras_palabras; // corresponde a la edad, dejarlo como entero o string?
        private String primeras_palabras;
        private String edad_primeras_frases; // dice palabras pero se asocia a frases, dejarlo como entero o string?
        private String primeras_frases;
        private String lenguaje_actual;
        private String comprension_lenguaje; 
        private String conciencia_dificultad;
        private String comprension_demas; // "los demás comprenden"
        private String retroceso_lenguaje;
        // -- FUNCIONES COMUNICATIVAS
        private String afirma;
        private String gesto_afirma;
        private String rechaza;
        private String gesto_rechaza;
        private String preguntas;// realiza preguntas
        private String gesto_preguntas;
        private String indica; // indica lo que quiere
        private String gesto_indica;
        
        // ANTECEDENTES ALIMENTACION
        
        // -- ALIMENTACIÓN
        private ArrayList<String> lactancia_materna; // contendrá el si o no, junto con el horario (diurno, nocturno o ambos)
        private String lactancia_materna_exclusiva; // corresponde a la edad, dejarlo como int o string;
        private ArrayList<String> relleno; // contendrá el si o no, junto con el horario (diurno, nocturno o ambos)
        private ArrayList<String> mamadera; // contendrá el si o no, junto con el horario (diurno, nocturno o ambos)
        private String observaciones_alimentacion;
        // -- CONSISTENCIAS
        private String consistencias; // selección multiple o unica?
        // -- CARACTERÍSTICAS
        private String dependencia; // independiente, dependiente o ambos
        private String acciones_comer; // babea, escupe la comida, dificultad respiratoria mientras come
        private String otra_actividad; // "realiza otra actividad mientras come"
        // -- ALIMENTOS QUE LE AGRADAN
        private String agrado_alimentos;
        // -- RECHAZO ALIMENTARIO
        private String rechazo_alimentario;
        private String tiempo_rechazo; // corresponde a "hace cuanto tiempo", dejarlo como int o string?
        private String rechazo_comidas; // "comidas que rechaza"
        private String rechazo_comidas2; // por textura, color, olor, consistenica, otro - seleccion multiple o unica?
        // -- MALOS HÁBITOS ORALES
        private ArrayList<String> malos_habitos; // seleccion multiple o unica? se deja como lista por mientras por el campo "otros"
        private String tiempo_malos_habitos; // "desde cuando"
        private String motivo_malos_habitos;
        
        // OBSERVACIONES
        private String observaciones;
        
        // ****** RELACIONES ENTRE TABLAS ******
	@OneToOne
	private FichaClinica fichaClinica;

	// -- MOTIVO CONSULTA
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "anamnesis")
	private List<MotivoConsulta> motivo_consultas;


	// ------- Getters and Setters -------
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getId(){
	    return id;
	}


}
