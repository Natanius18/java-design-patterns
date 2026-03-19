package example.natanius.proxy;

public class Member {
    private final String name;
    private final MembershipLevel level;
    private int weeklyUsageCount;

    public Member(String name, MembershipLevel level) {
        this.name = name;
        this.level = level;
    }

    public String getName() { return name; }
    public MembershipLevel getLevel() { return level; }
    public int getWeeklyUsageCount() { return weeklyUsageCount; }
    public void incrementUsage() { weeklyUsageCount++; }
}
