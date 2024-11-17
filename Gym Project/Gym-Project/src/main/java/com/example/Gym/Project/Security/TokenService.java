package com.example.Gym.Project.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.Gym.Project.Model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private static String secruit = "sndgkmsnd";

    public String geraToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secruit);
            return JWT.create().withIssuer("GymProject").withSubject(user.getLogin()).withExpiresAt(expireDate()).sign(algorithm);
        }
        catch(JWTCreationException e){
            throw new RuntimeException(e);
        }
    }

    public String getSubject(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secruit);
            return JWT.require(algorithm).withIssuer("GymProject").build().verify(token).getSubject();
        }
        catch(JWTVerificationException e){
            return null;
        }
    }

    private Instant expireDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}
