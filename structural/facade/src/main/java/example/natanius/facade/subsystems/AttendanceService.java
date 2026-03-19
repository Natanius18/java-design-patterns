package example.natanius.facade.subsystems;

public class AttendanceService {
    public void logVisit(String memberId) {
        System.out.println("AttendanceService: Visit logged for " + memberId);
    }
}
