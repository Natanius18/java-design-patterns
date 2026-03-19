package example.natanius.facade.subsystems;

public class QueueManagement {
    private int currentOccupancy = 0;
    private final int maxCapacity;

    public QueueManagement(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean allowEntry() {
        if (currentOccupancy >= maxCapacity) {
            System.out.println("QueueManagement: Gym is full. Added to waitlist.");
            return false;
        }
        currentOccupancy++;
        System.out.println("QueueManagement: Entry allowed. Occupancy: " + currentOccupancy + "/" + maxCapacity);
        return true;
    }
}
