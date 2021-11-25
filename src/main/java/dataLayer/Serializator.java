package dataLayer;
import businessLayer.DeliveryService;
import java.io.*;

/**
 * The type Serializator.
 * @author Ariana Horvath
 */
public class Serializator {
    private final String filename = "deliveryService.ser";

    /**
     * Serialize.
     * @param deliveryService the delivery service
     */
    public void serialize(DeliveryService deliveryService) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(deliveryService);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize delivery service.
     * @return the delivery service
     */
    @SuppressWarnings("unchecked")
    public DeliveryService deserialize() {
        DeliveryService deliveryService = new DeliveryService();
        try {
            FileInputStream file = new FileInputStream(filename);
            if (file.available() > 0) {
                ObjectInputStream in = new ObjectInputStream(file);
                deliveryService = (DeliveryService) in.readObject();
                in.close();
                file.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deliveryService;
    }
}
