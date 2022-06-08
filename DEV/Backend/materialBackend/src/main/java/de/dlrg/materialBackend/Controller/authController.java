package de.dlrg.materialBackend.Controller;

import de.dlrg.materialBackend.Repository.BenutzerRepository;
import de.dlrg.materialBackend.Security.HashPasswordGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authController {

    private BenutzerRepository BenutzerRepository;
    private HashPasswordGenerator encoder;

    public authController(BenutzerRepository benutzerRepository, HashPasswordGenerator encoder) {
        BenutzerRepository = benutzerRepository;
        this.encoder = encoder;
    }

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password){
        var user = BenutzerRepository.findBenutzerByUsername(username);
        boolean result = encoder.decode(password, user.get().getPassword());
        if (result){

            return new ResponseEntity("Login Erfolgreich", HttpStatus.OK);

        }
        else{
            return new ResponseEntity("Login Fehlerhaft", HttpStatus.CONFLICT);
        }

    }
}
