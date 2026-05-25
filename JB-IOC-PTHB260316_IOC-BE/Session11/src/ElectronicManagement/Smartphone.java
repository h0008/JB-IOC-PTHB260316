package ElectronicManagement;

public class Smartphone extends Device implements Connectable, Chargeable {
    public Smartphone(int id, String name) {
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
        System.out.println(getName() + " is connecting to Wi-Fi.");
    }

    @Override
    public void charge() {
        System.out.println(getName() + " is charging.");
    }
}

