package example.natanius.bridge;


import example.natanius.bridge.devices.Device;
import example.natanius.bridge.devices.Radio;
import example.natanius.bridge.devices.Tv;
import example.natanius.bridge.remotes.AdvancedRemote;
import example.natanius.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
