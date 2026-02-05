package example.natanius.components;


import lombok.Getter;

@Getter
public class GPSNavigator {
    private final String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

}
