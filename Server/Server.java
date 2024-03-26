import implementation.ExampleRMIImplementation;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            // Create an instance of the ExampleRMIImplementation class
            ExampleRMIImplementation implementation = new ExampleRMIImplementation();

            // Specify the IP address of the network interface
            String ipAddress = "192.168.20.9"; // Replace this with the actual IP address
            //String ipAddresst = "192.168.20."; // Replace this with the actual IP address
            
            System.setProperty("java.rmi.server.hostname", ipAddress);

            // Create and export the RMI registry on the specified IP address
            Registry reg = LocateRegistry.createRegistry(1099);
            //Registry regt = LocateRegistry.createRegistry(1099);
            reg = LocateRegistry.getRegistry(ipAddress); // Specify the IP address
            //regt = LocateRegistry.getRegistry(ipAddresst); // Specify the IP address

            // Bind the remote object implementation to the registry
            reg.rebind("UserRequestService", implementation);
            //regt.rebind("UserRequestService", implementation);

            System.err.println("Server ready");

            // Keep the server alive
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
