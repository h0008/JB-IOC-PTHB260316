package ElectronicManagement;

public class Television extends Device implements Connectable {
    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(getName() + " is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println(getName() + " is turning off.");
    }

    @Override
    public void connectWifi() {
        System.out.println(getName() + " is connecting to the home Wi-Fi network.");
    }
}

