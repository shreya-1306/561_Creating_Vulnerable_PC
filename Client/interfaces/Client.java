import interfaces.ExampleRMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        String host = "192.168.20.9";
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1099);

            System.out.println("Got the registry");
            ExampleRMIInterface RMIObject = (ExampleRMIInterface) registry.lookup("UserRequestService");

            System.out.println(RMIObject.someRemoteMethod());
            System.out.println(RMIObject.someOtherRemoteMethod(null, null));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
