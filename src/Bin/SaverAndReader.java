package Bin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SaverAndReader {
	File f; //TxT para rellenar con datos
	FileWriter w; //Escribe datos en el archivo
	BufferedWriter br;
	PrintWriter pw;
	BufferedReader bw;
	FileReader fr;
	

	public String leertxt() { //Lee el archivo de guardado
		String texto = "";
		try {
			fr=new FileReader("save.txt"); //prepara el archivo save.txt
			bw=new BufferedReader(fr); //cargamos en un buffer el archivo
			String temp="";
			String brreader; //Es donde se leera las lineas y las introducir� en el archivo de guardado
			while((brreader=bw.readLine()) !=null) {
				temp= temp +brreader;//Introduce la linea en Temp
			}
			texto=temp; //introduce temp en texto
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se detectó el archivo de guardado local");
		}
		
		return texto; //retorna texto, en el main se dividir� por palabras y el programa lo guardara en variables distintas
	}	
	public void CrearPartida (String nombre) { //Creamos partida, para ello el usuario debe elegir un nombre en el main
		

		jugador j1 = new jugador(nombre, 0, 0, 0); //Hacemos el jugador, el cual tendr� todos los valores a 0 menos el nombre
		
		File fichero = new File("save.txt");
		fichero.delete();

		
		try {
			f=new File("save.txt"); //creamos el archivo de guardado
			w=new FileWriter(f); //habilitamos la escritura del archivo de guardado
			br=new BufferedWriter(w); //Cargamos lo anterior en el buffer de escritura
			pw=new PrintWriter(br); //Preparamos lo que imprimir� el buffer dentro del archivo
			pw.write(j1.getNombre()+","+j1.getVictorias() + "," + j1.getDerrotas() + "," + j1.getEmpate()); //Lo anterior guardar� estos valores dentro del archivo de guardado
			pw.close(); //cerramos la ejecucion del sistema de guardado
			br.close();//cerramos la ejecucion del buffer de guardado
			
			System.out.println("Partida creada"); //mensaje de notificacion para el usuario
			
		}
		catch(Exception e) {
			
		}
	}
	public void Update (String nombre, int Victoria, int Derrota, int Empate) {
		

		jugador j1 = new jugador(nombre, Victoria, Derrota, Empate);
		
		try {
			
			//es exactamente igual que lo anterior, pero no cargamos el jugador, y los valores que escribimos son los que recibimos a trav�s del main
			f=new File("save.txt");
			w=new FileWriter(f);
			br=new BufferedWriter(w);
			pw=new PrintWriter(br);
			//valores obtenidos del main
			pw.write(j1.getNombre()+","+j1.getVictorias() + "," + j1.getDerrotas() + "," + j1.getEmpate());
			pw.close();
			br.close();
			
			System.out.println("Partida guardada");
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el archivo de guardado");
		}
	}
}
