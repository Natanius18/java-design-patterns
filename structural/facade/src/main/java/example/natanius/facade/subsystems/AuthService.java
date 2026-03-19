package example.natanius.facade.subsystems;

public class AuthService {
    public boolean validateMembership(String memberId) {
        System.out.println("AuthService: Validating membership for " + memberId);
        boolean valid = !memberId.isBlank();
        System.out.println("AuthService: Membership " + (valid ? "valid" : "INVALID"));
        return valid;
    }
}
