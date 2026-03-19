package example.natanius.facade.subsystems;

public class BillingService {
    public void chargeDayPass(String memberId) {
        System.out.println("BillingService: Day pass charged for " + memberId);
    }
}
