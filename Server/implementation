package implementation;

import interfaces.ExampleRMIInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ExampleRMIImplementation extends UnicastRemoteObject implements ExampleRMIInterface {

    public ExampleRMIImplementation() throws RemoteException {
    }

    @Override
    public String someRemoteMethod() throws RemoteException {
        return "Hello, the method without parameters was called";
    }

    //It doesn't matter that the HashMap is never used. If a malicious HashMap is passed in, it will still trigger
    @Override
    public String someOtherRemoteMethod(String someStringParamenter, HashMap someHashMapParameter) throws RemoteException {
        return "Hello, the method with parameters was called";
    }
}
