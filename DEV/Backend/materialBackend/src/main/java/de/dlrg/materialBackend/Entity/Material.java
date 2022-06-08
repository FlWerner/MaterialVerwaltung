package de.dlrg.materialBackend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long material_id;

    @NotNull
    private String name;
    private String beschreibung;
    private String seriennummer;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date änderungsDatum;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date herstellDatum;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date prüfungsTermin;
    private int interVall;
    private Date ablaufDatum;

    private Long qrCode;

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<materialProblem> materialProbleme;

    @ManyToOne
    @JoinColumn(name = "lagerortkiste_id")
    private Kiste kiste;


    public Material() {
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

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public Date getÄnderungsDatum() {
        return änderungsDatum;
    }

    public void setÄnderungsDatum(Date änderungsDatum) {
        this.änderungsDatum = änderungsDatum;
    }

    public Date getHerstellDatum() {
        return herstellDatum;
    }

    public void setHerstellDatum(Date herstellDatum) {
        this.herstellDatum = herstellDatum;
    }

    public Date getPrüfungsTermin() {
        return prüfungsTermin;
    }

    public void setPrüfungsTermin(Date prüfungsTermin) {
        this.prüfungsTermin = prüfungsTermin;
    }

    public int getInterVall() {
        return interVall;
    }

    public void setInterVall(int interVall) {
        this.interVall = interVall;
    }

    public Date getAblaufDatum() {
        return ablaufDatum;
    }

    public void setAblaufDatum(Date ablaufDatum) {
        this.ablaufDatum = ablaufDatum;
    }

    public Long getQrCode() {
        return qrCode;
    }

    public void setQrCode(Long qrCode) {
        this.qrCode = qrCode;
    }

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
    }

    public List<materialProblem> getMaterialProbleme() {
        return materialProbleme;
    }

    public void setMaterialProbleme(List<materialProblem> materialProbleme) {
        this.materialProbleme = materialProbleme;
    }
}
