package it.corso.helper;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Base64;

public class SecurityManager 
{
    public static String encode(String toEncode)
    {
        return Base64.getEncoder().encodeToString(toEncode.getBytes());
    }
    
    public static String decode(String toDecode)
    {
        return new String(Base64.getDecoder().decode(toDecode)); //converte l'array di byte in stringa
    }
    
    public static String generateToken(String username, boolean type) //true =admin, false=customer
    {
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.toInstant(OffsetDateTime.now().getOffset());
        long timestamp = instant.getEpochSecond() *1000;
        String suffix ="_U";
        return encode(username) + "_" + timestamp + suffix;
    }
}