package hn.uth.bancopeliculas.modelo;

import java.io.Serializable;
import java.math.*;
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

/**
 * Esto es un ejemplo de una entidad.
 * 
 * Siéntete libre de renombrarla, modificarla o borrarla a tu gusto.
 */

@Entity @Getter @Setter
public class Pelicula implements Serializable {
	//Id define la clave unica de la entidad, son obligatorias por defecto.
	//Column length 100 indica la longitud de la columna tanto en base de datos como en UI
	@Id @Column(length = 100)
	String nombre;

	//@Required @Column(length = 50)

	@ManyToOne(
			fetch = FetchType.LAZY,
			optional = false)
	@DescriptionsList //se visualiza como combobox
	Genero genero;

	LocalDate fechaVisualizacion;

	@Required @Column(length = 1)
	int calificacion;

	@Column(length=500)
	@Required
	@TextArea
	String descripcion;
}
