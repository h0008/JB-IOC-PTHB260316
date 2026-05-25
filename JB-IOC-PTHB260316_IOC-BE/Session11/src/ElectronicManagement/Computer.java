package ElectronicManagement;

public class Computer extends Device implements Connectable, Chargeable {
    public Computer(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(getName() + " is booting up.");
    }

    @Override
    public void turnOff() {
        System.out.println(getName() + " is shutting down.");
    }

    @Override
    public void connectWifi() {
        System.out.println(getName() + " is connected to a wireless network.");
    }

    @Override
    public void charge() {
        System.out.println(getName() + " is plugged in and charging.");
    }
}

