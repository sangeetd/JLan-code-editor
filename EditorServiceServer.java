
package javacoeditor.rmi;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class EditorServiceServer extends UnicastRemoteObject implements EditorService {

    String currentFileContents;
    String currentNickName;
    private static Registry registry;
    //later added code
    ArrayList<String> clientList=new ArrayList<String>();
    String clientTyping="";
    int invokeAnyChange=0;
    byte[] fileInByte=null;//remove if not work
    //later added code
    
    public EditorServiceServer() throws RemoteException{
        super();
    }
    
    @Override
    public String getCurrentFile() throws RemoteException{
        return currentFileContents;
    }

    @Override
    public boolean setCurrentFile(String file, String nick,byte[] j) throws RemoteException {
        currentFileContents = file;
        fileInByte=j;//remove if not work also this byte[] j from here and EditorServcie
        currentNickName = nick;
        return true;
    }
    
    @Override
    public String getCurrentNickName() throws RemoteException{
        return currentNickName;
    }
    
    //later added code
    
    @Override
    public boolean setClientList(String nick,int _invokeAnyChange) throws RemoteException {
        invokeAnyChange=_invokeAnyChange;
        clientList.add(nick);
        System.out.println(clientList+" are set in Server!!");
        return true;
    }

    @Override
    public boolean removeClientFromList(String nick,int _invokeAnyChange) throws RemoteException {
        invokeAnyChange=_invokeAnyChange;
        boolean what=clientList.remove(nick);
        System.out.println(clientList+" left in server after removal of "+nick);
        return what;
    }
    
    @Override
    public ArrayList<String> getClientList() throws RemoteException {
        return clientList;
    }
    
    @Override
    public int getInvokeAnyChange() throws RemoteException{
        return invokeAnyChange;
    }
    
    @Override
    //remove if not work
    public byte[] getFileInByte() throws RemoteException{
        return fileInByte;
    }
    
    @Override
    public boolean setWhoTyping(String nick)throws RemoteException{
        clientTyping=nick;
        return true;
    }
    
    @Override
    public String getWhoTyping() throws RemoteException{
        return clientTyping;
    }
    
    //later added code
    
    
    public void startServer(){
        try{
            registry = LocateRegistry.createRegistry(2055);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
        try{
            EditorServiceServer svr=new EditorServiceServer();
            registry.bind("EditorService", svr);
            System.out.println("Service Bound!");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}
