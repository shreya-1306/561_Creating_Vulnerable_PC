package org.apache.jmeter.engine;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.jorphan.collections.HashTree;

/**
 * This is the interface for the RMI server engine, i.e. {@link RemoteJMeterEngineImpl}
 */
public interface RemoteJMeterEngine extends Remote {
    void rconfigure(HashTree testTree, String host, File jmxBase, String scriptName) throws RemoteException;

    void rrunTest() throws RemoteException, JMeterEngineException;

    void rstopTest(boolean now) throws RemoteException;

    void rreset() throws RemoteException;

    @SuppressWarnings("NonApiType")
    void rsetProperties(HashMap<String,String> p) throws RemoteException;

    void rexit() throws RemoteException;
}
