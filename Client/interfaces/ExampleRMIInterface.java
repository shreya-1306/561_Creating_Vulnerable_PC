package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface ExampleRMIInterface extends Remote {
 String someRemoteMethod() throws RemoteException;
 String someOtherRemoteMethod(String someStringParameter, HashMap someHashMapParameter) throws RemoteException;
}
