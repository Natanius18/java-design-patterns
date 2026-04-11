package example.natanius.proxy_cglib;

public class CryoChamber {
    public void startSession(Member member) {
        System.out.println("CryoChamber: Starting 3-min session for " + member.getName() + ". Temperature: -110C.");
    }

    public void endSession() {
        System.out.println("CryoChamber: Session complete.");
    }

    public String getName() { return "CryoChamber"; }
}
