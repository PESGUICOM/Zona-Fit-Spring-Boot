package com.pesguicom.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data //Métodos Getters-Setters
@NoArgsConstructor //Constructor vacío
@AllArgsConstructor //Constructor con todos los argumentos
@ToString //Método toString
@EqualsAndHashCode //Método equalsHashCode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia;
}
