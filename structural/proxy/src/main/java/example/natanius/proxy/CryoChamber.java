package example.natanius.proxy;

public class CryoChamber implements GymEquipment {
    @Override
    public void startSession(Member member) {
        System.out.println("CryoChamber: Starting 3-min session for " + member.getName() + ". Temperature: -110C.");
    }

    @Override
    public void endSession() {
        System.out.println("CryoChamber: Session complete.");
    }

    @Override
    public String getName() { return "CryoChamber"; }
}
