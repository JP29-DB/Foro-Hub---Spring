package com.desafio.forohub.domain.curso;

import com.desafio.forohub.domain.curso.dto.ActualizarCursoDTO;
import com.desafio.forohub.domain.curso.dto.CrearCursoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //Genera los getter automáticamente
@NoArgsConstructor //Constructor para framework hibernate
@AllArgsConstructor //Genera los constructores con argumentos para todas las propiedades
@Table(name = "cursos") //Especifica a que tabla de base de datos está asociada
@Entity(name = "Curso") //Declara que esta clase es entidad de JPA
@EqualsAndHashCode(of = "id") //Escribe los equals y hascode correspondientes
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(CrearCursoDTO crearCursoDTO) {
        this.name = crearCursoDTO.name();
        this.categoria = crearCursoDTO.categoria();
        this.activo = true; //Automaticamente el curso estara activo.
    }

    public void actualizarCurso(ActualizarCursoDTO actualizarCursoDTO) {

        if(actualizarCursoDTO.name() != null){
            this.name = actualizarCursoDTO.name();
        }
        if (actualizarCursoDTO.categoria() != null){
            this.categoria = actualizarCursoDTO.categoria();
        }
        if (actualizarCursoDTO.activo() != null){
            this.activo = actualizarCursoDTO.activo();
        }
    }

    public void eliminarCurso(){
        this.activo = false;
    }
}