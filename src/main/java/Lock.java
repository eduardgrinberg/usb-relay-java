import org.hid4java.HidDevice;
import org.hid4java.HidManager;
import org.hid4java.HidServices;

public class Lock {
    HidDevice lockDevice = null;

    public Boolean init() {
        HidServices hidServices = HidManager.getHidServices();
        hidServices.start();

        for (HidDevice device : hidServices.getAttachedHidDevices()) {
            System.out.println(device);
            if (device.getProduct().equals("USBRelay2")) {
                lockDevice = device;
            }
        }

        if (lockDevice != null) {
            return true;
        }

        return false;
    }

    public void close() {
        lockDevice.open();

        byte[] message = new byte[9];

        message[0] = (byte) 0xFE;

        lockDevice.sendFeatureReport(message, (byte) 0);

        lockDevice.close();
    }

    public void open() {
        lockDevice.open();

        byte[] message = new byte[9];

        message[0] = (byte) 0xFC;

        lockDevice.sendFeatureReport(message, (byte) 0);

        lockDevice.close();
    }
}
