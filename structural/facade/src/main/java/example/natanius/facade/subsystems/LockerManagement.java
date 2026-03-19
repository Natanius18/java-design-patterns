package example.natanius.facade.subsystems;

public class LockerManagement {
    private int nextLocker = 1;

    public void reserveLocker(String memberId) {
        int locker = nextLocker++;
        System.out.println("LockerManagement: Locker #" + locker + " reserved for " + memberId);
    }
}
