package app;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProgramaServidor {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(2000);
			reg.rebind("MathServer1", new MathServerClass());
			System.out.println("Servidor de RMI pronto....");  
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
