package example.natanius.facade.facade;

import example.natanius.facade.subsystems.*;

public class GymFacade {
    private final AuthService auth = new AuthService();
    private final AttendanceService attendance = new AttendanceService();
    private final TrainerAssignment trainerAssignment = new TrainerAssignment();
    private final LockerManagement lockerMgmt = new LockerManagement();
    private final BillingService billing = new BillingService();
    private final QueueManagement queueMgmt;
    private final NotificationService notification = new NotificationService();

    public GymFacade(int maxCapacity) {
        this.queueMgmt = new QueueManagement(maxCapacity);
    }

    public void checkIn(String memberId) {
        System.out.println("\n--- Check-in started for " + memberId + " ---");

        if (!auth.validateMembership(memberId)) {
            notification.notify(memberId, "Membership invalid. Please visit the front desk.");
            return;
        }

        if (!queueMgmt.allowEntry()) {
            notification.notify(memberId, "Gym is full. You've been added to the waitlist.");
            return;
        }

        attendance.logVisit(memberId);
        trainerAssignment.notifyTrainer(memberId);
        lockerMgmt.reserveLocker(memberId);
        billing.chargeDayPass(memberId);
        notification.notify(memberId, "Welcome! You're checked in. Enjoy your workout!");

        System.out.println("--- Check-in complete for " + memberId + " ---");
    }
}
