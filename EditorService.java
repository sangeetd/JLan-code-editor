
package javacoeditor.rmi;

import java.rmi.*;
import java.util.*;


public interface EditorService extends java.rmi.Remote {
    public String getCurrentFile() throws RemoteException;
    public boolean setCurrentFile(String file, String nick,byte[] j) throws RemoteException;//remove byte[] j
    public String getCurrentNickName() throws RemoteException;
    //later added code
    public boolean removeClientFromList(String nick,int invokeAnyChange) throws RemoteException;
    public ArrayList<String> getClientList() throws RemoteException;
    public boolean setClientList(String nick,int invokeAnyChange) throws RemoteException;
    public int getInvokeAnyChange() throws RemoteException;
    public boolean setWhoTyping(String nick)throws RemoteException;
    public String getWhoTyping() throws RemoteException;
    public byte[] getFileInByte() throws RemoteException;//remove if not work
    //later added code
}
