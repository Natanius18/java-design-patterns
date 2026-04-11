package example.natanius.proxy_cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Demo {
    public static <T> T withAccessControl(T target, double price, int weeklyLimit) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new EquipmentAccessHandler(target, price, weeklyLimit));
        T proxy = (T) enhancer.create();
        return proxy;
    }

    public static void main(String[] args) {
        CryoChamber cryo = withAccessControl(new CryoChamber(), 25.0, 3);

        Member vip = new Member("Alice", MembershipLevel.VIP);
        Member basic = new Member("Bob", MembershipLevel.BASIC);

        System.out.println("=== VIP member session ===");
        cryo.startSession(vip);
        cryo.endSession();

        System.out.println("\n=== Basic member attempt ===");
        cryo.startSession(basic);

        System.out.println("\n=== VIP uses remaining sessions ===");
        cryo.startSession(vip);
        cryo.endSession();
        cryo.startSession(vip);
        cryo.endSession();

        System.out.println("\n=== VIP exceeds weekly limit ===");
        cryo.startSession(vip);
    }
}
