package de.dlrg.materialBackend.Controller;


import de.dlrg.materialBackend.Entity.Benutzer;
import de.dlrg.materialBackend.Repository.BenutzerRepository;
import de.dlrg.materialBackend.Security.HashPasswordGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benutzer")
public class benutzerController {
    private BenutzerRepository benutzerRepository;
    private HashPasswordGenerator encoder;


    public benutzerController(BenutzerRepository benutzerRepository, HashPasswordGenerator encoder) {
        this.benutzerRepository = benutzerRepository;
        this.encoder = encoder;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> add (@RequestParam(value = "username", required = true) String username, @RequestParam(value = "passwort", required = true) String password, String vorname, String name){
        try {
            var encodedPassword = encoder.encode(password);

            Benutzer benutzer = new Benutzer();
            benutzer.setUsername(username);
            benutzer.setName(name);
            benutzer.setVorname(vorname);
            benutzer.setPassword(encodedPassword);

            benutzerRepository.save(benutzer);
        } catch (Exception ex){

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("Erfolgreich Erstellt", HttpStatus.CREATED);

    }


}
