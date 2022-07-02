package securityconf;

public interface PasswordEncoder {

    byte[] getSalt();
    byte[] getSaltedHash(String password, byte[] salt);
}
