package de.dlrg.materialBackend.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Configuration
public class HashPasswordGenerator {
    private Argon2PasswordEncoder encoder;

    public HashPasswordGenerator() {
        encoder = new Argon2PasswordEncoder(32,64,1,15*1024,2);
    }

    public String encode(String requestPassword){
        if (requestPassword != null) {
            var password = encoder.encode(requestPassword);
            return password;
        }
        else {
            return null;
        }


    }

    public boolean decode(String loginPassword, String userpassword){
        boolean result =encoder.matches(loginPassword, userpassword);
        return result;
    }

}
