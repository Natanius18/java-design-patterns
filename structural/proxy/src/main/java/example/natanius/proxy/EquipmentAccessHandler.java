package example.natanius.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EquipmentAccessHandler implements InvocationHandler {
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    private final Object target;
    private final int weeklyLimit;
    private final double sessionPrice;

    public EquipmentAccessHandler(Object target, double sessionPrice, int weeklyLimit) {
        this.target = target;
        this.sessionPrice = sessionPrice;
        this.weeklyLimit = weeklyLimit;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("startSession")) {
            Member member = (Member) args[0];

            if (member.getLevel() != MembershipLevel.VIP) {
                System.out.println(RED + "Access denied for " + member.getName() + ". VIP-only equipment. Upgrade for +$99/month." + RESET);
                return null;
            }
            if (member.getWeeklyUsageCount() >= weeklyLimit) {
                System.out.println(RED + member.getName() + " has reached the weekly limit (" + weeklyLimit + "x)." + RESET);
                return null;
            }

            System.out.println(RED + "Billing " + member.getName() + ": $" + sessionPrice + RESET);
            member.incrementUsage();
        }

        if (method.getName().equals("endSession")) {
            Object result = method.invoke(target, args);
            System.out.println(RED + "Cleanup crew notified." + RESET);
            return result;
        }

        return method.invoke(target, args);
    }
}
