package example.natanius.facade.subsystems;

public class TrainerAssignment {
    public void notifyTrainer(String memberId) {
        System.out.println("TrainerAssignment: Trainer notified about " + memberId + "'s arrival");
    }
}
