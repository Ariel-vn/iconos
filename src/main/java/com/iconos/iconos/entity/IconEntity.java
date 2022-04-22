package com.iconos.iconos.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="icon")
@Data
@SQLDelete(sql="UPDATE icon SET deleted=true WHERE id=?")
@Where(clause = "deleted=false")
public class IconEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    private Long altura;
    private String historia;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    //cuando creo un icono no voy a poder pasarle una lista de paises para que los cree, porque el que se hace
    //cargo de la relación es el pais
    private List<PaisEntity> paises=new ArrayList<>();

    //Add and remove paises
    public void addPais(PaisEntity pais){ this.paises.add(pais);}
    public void removePais(PaisEntity pais){ this.paises.remove(pais);}



    }
