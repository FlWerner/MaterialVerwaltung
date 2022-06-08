package de.dlrg.materialBackend.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "materialProblem")
public class materialProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String beschreibung;

    private Date problemDatum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "material_id", nullable = false)
    private de.dlrg.materialBackend.Entity.material material;

    public materialProblem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getProblemDatum() {
        return problemDatum;
    }

    public void setProblemDatum(Date problemDatum) {
        this.problemDatum = problemDatum;
    }

    public de.dlrg.materialBackend.Entity.material getMaterial() {
        return material;
    }

    public void setMaterial(de.dlrg.materialBackend.Entity.material material) {
        this.material = material;
    }
}
