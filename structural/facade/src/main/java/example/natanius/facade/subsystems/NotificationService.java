package example.natanius.facade.subsystems;

public class NotificationService {
    public void notify(String memberId, String message) {
        System.out.println("NotificationService: notification to " + memberId + " -> \"" + message + "\"");
    }
}
