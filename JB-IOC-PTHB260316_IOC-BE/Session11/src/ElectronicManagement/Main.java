package ElectronicManagement;

public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[3];
        devices[0] = new Smartphone(1, "Galaxy S24");
        devices[1] = new Computer(2, "ThinkPad Laptop");
        devices[2] = new Television(3, "LG Smart TV");

        for (Device device : devices) {
            System.out.println("ID: " + device.getId() + " - Name: " + device.getName());
            device.turnOn();

            if (device instanceof Connectable) {
                ((Connectable) device).connectWifi();
            }

            if (device instanceof Chargeable) {
                ((Chargeable) device).charge();
            }

            device.turnOff();
            System.out.println("---------------------------------");
        }
    }
}

