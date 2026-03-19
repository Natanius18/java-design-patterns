package example.natanius.facade;

import example.natanius.facade.facade.GymFacade;

public class Demo {
    public static void main(String[] args) {
        // Front desk uses 1 method instead of 7 subsystem calls
        GymFacade gym = new GymFacade(2);

        gym.checkIn("MEM-001");
        gym.checkIn("MEM-002");
        gym.checkIn("MEM-003"); // gym full — waitlisted
    }
}
