package com.iconos.iconos.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pais")
@Data
public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name="cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie;

    //fetch.eager relación de tipo temprana, cuando pida un país si o si va a venir con un continente.
    //cascade type all para que un cambio replique en la tabla de continente
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    //join como voy a unir (a través de continente id. insertable updatable false porq lo uso solo para obtener información
    @JoinColumn(name="continente_id",insertable = false, updatable = false)
    private ContinenteEntity continente;

    @Column(name="continente_id", nullable = false)
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name="icon_pais",
            joinColumns = @JoinColumn(name="pais_id"),
            inverseJoinColumns = @JoinColumn(name="icon_id")
    )
    private Set<IconEntity> icons= new HashSet<>();

    @Override
    public boolean equals(Object obj){
        if (obj==null)
            return false;
        if (getClass()!=obj.getClass())
            return false;
        final PaisEntity other=(PaisEntity) obj;
        return other.id==this.id;
    }

}
