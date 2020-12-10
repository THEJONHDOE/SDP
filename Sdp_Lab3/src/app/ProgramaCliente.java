package app;


import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaCliente {

	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("0.000");
		Cliente cliente = new Cliente();
		String filename = "/Users/jonas/downloads/data.csv";
		List<Double> values = new ArrayList<>();
		File file = new File(filename);
		Scanner scanner = null;
		
		try{
			scanner = new Scanner(file);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		if (scanner != null){
			scanner.nextLine();
			
			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] split = line.split(";");
				values.add(Double.parseDouble(split[1]));
			}
			scanner.close();
		}
		
		try {
			
			System.out.println("A m�dia de vendas di�rias �: " + df.format(cliente.average(values)));
			System.out.println("O desvio padr�o �: " + df.format(cliente.desvio(values)));
			System.out.println("O valor de vendas mais baixo �: " + df.format(cliente.minimo(values)));
			System.out.println("O valor de vendas mais alto �: " + df.format(cliente.maximo(values)));
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
