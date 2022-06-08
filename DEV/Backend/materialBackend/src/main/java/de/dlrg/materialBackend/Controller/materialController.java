package de.dlrg.materialBackend.Controller;

import de.dlrg.materialBackend.Entity.Material;
import de.dlrg.materialBackend.Repository.MaterialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path = "/material")
public class materialController {

    private MaterialRepository materialRepository;

    public materialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<Material>> get(){
        return ResponseEntity.ok(materialRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "beschreibung", required = false) String beschreibung,
            @RequestParam(value = "seriennummer", required = false) String seriennummer,
            @RequestParam(value = "aenderungsDatum")Date aenderungsdatum,
            @RequestParam(value = "herstelldatum", required = false)Date herstelldatum,
            @RequestParam(value = "pruefungstermim", required = false)Date pruefungstermin,
            @RequestParam(value = "intervall", required = false)int intervall,
            @RequestParam(value = "ablaufdatum", required = false)Date ablaufdatum,
            @RequestParam(value = "qrcode", required = false)Long qrcode
    ){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        Material material = new Material();
        material.setName(name);
        material.setBeschreibung(beschreibung);
        material.setSeriennummer(seriennummer);
        material.setÄnderungsDatum(aenderungsdatum);
        material.setHerstellDatum(herstelldatum);
        material.setPrüfungsTermin(pruefungstermin);
        material.setInterVall(intervall);
        material.setAblaufDatum(ablaufdatum);
        material.setQrCode(qrcode);

        materialRepository.save(material);
        return new ResponseEntity<>("Angelegt", HttpStatus.OK);
    }


}
