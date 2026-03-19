package example.natanius.proxy;

public interface GymEquipment {
    void startSession(Member member);
    void endSession();
    String getName();
}
