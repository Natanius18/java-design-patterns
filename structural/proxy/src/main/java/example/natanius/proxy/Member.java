package example.natanius.proxy;

import lombok.Getter;

@Getter
public class Member {
    private final String name;
    private final MembershipLevel level;
    private int weeklyUsageCount;

    public Member(String name, MembershipLevel level) {
        this.name = name;
        this.level = level;
    }

    public void incrementUsage() { weeklyUsageCount++; }
}
