package de.dlrg.materialBackend.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lagerortKiste")
public class lagerortKiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "lagerort_id")
    private Lagerort lagerort;

    @ManyToOne
    @JoinColumn(name = "kiste_ID")
    private Kiste kiste;

    @OneToMany
    private List<Material> material;

}
