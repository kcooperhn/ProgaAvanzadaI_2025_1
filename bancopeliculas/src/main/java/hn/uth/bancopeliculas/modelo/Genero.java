package hn.uth.bancopeliculas.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;

import javax.persistence.*;

@Entity @Getter @Setter
public class Genero {
    
    @Id
    @GeneratedValue(generator = "system-uuid")//generador de valores aleatorios para identificadores unicos
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Hidden
    @Column(length = 36)
    String oid;
    
    @Column(length = 60)
    String descripcion;
}
