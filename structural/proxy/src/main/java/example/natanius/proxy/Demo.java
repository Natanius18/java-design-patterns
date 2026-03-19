package example.natanius.proxy;

import java.lang.reflect.Proxy;

public class Demo {
    @SuppressWarnings("unchecked")
    public static <T> T withAccessControl(T target, Class<T> itf, double price, int weeklyLimit) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(), new Class<?>[] { itf },
                new EquipmentAccessHandler(target, price, weeklyLimit));
    }

    public static void main(String[] args) {
        GymEquipment cryo = withAccessControl(new CryoChamber(), GymEquipment.class, 25.0, 3);

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
