package DataBase;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class connect extends JFrame {
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String cadenaConeccion="jdbc:mysql://masterdev2887-do-user-8339774-0.b.db.ondigitalocean.com:25060/jugadores";
	private String usuario = "rootie";
	private String contrasena = "ay4e3yslo5agfqhg";
	public Connection con;
	
	private String username="";
	private int v, d, em;
	
	private JPanel panel;
	private JLabel etiqueta;
	private JButton local1, Ini, Reg, bt2, Start1, Start2, Start3;
	private JTextField tb1, tb2;
	
	private static int cont = 0;
	

	public connect() {

		setTitle("Iniciar Sesion / Registrarse");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Toolkit monitor = Toolkit.getDefaultToolkit();
		Dimension tamanio = monitor.getScreenSize();
		
		int AltM = tamanio.height;
		int AnchM = tamanio.width;
		
		setSize(AnchM/2, AltM/2);
		setLocation(AnchM/4,AltM/4);
		
		//Establece una imagen de icono
		Image iconoAPP=monitor.getImage("src/icono.png");
		setIconImage(iconoAPP);
		
		//hace que tengamos musica de fondo durante toda la ejecucion del programa
		if (cont==0) {
			try {
				File file = new File("src/musica.wav"); //buscamos el archivo deseado
			     Clip clip = AudioSystem.getClip(); //cargamos la variable Clip
			     AudioInputStream Audio = AudioSystem.getAudioInputStream(file); //introducimos la variable deseada anteriormente donde est� la ubicacion de nuestra musica
			     clip.open(Audio); //ejecuta la cancion
			     clip.loop(Clip.LOOP_CONTINUOUSLY); //la pone en bucle
			} catch (Exception e) {
				System.out.println("error " + e.getMessage()); //en caso de error ejecuta esto
			}
			
			cont++; //suma uno al cont para que cada vez que se ejecute haga una llamada a esta clase, no se ponga una cancion sobre otra
		} else if (cont==1) {
			
		}
		 //cargamos los elementos
		iniciarComponentes();
				
		repaint(); //repintamos los cambios
		
	}
	
	//cargamos cada uno de los componentes
	private void iniciarComponentes() {
		colocarPanel();
		colocarElementos();
		colocarEtiqueta();
		
	}
	
	//creamos el panel
	private void colocarPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
	}
	
	//creamos las etiquetas de texto
	private void colocarEtiqueta() {

		etiqueta = new JLabel("Iniciar sesion | Registrarse");
		etiqueta.setBounds(95, 20, 800, 80);
		etiqueta.setFont(new Font("courier", Font.PLAIN, 30));
		panel.add(etiqueta);
		
	}
	
	//creamos los elementos
	private void colocarElementos() {
		setStart1(new JButton("Iniciar Sesion"));
		getStart1().setFont(new Font("courier", Font.PLAIN, 15));
		getStart1().setBounds(50, 110, 200, 45);
		panel.add(getStart1());
		
		setStart2(new JButton("Registrarse"));
		getStart2().setFont(new Font("courier", Font.PLAIN, 15));
		getStart2().setBounds(260, 110, 200, 45);
		panel.add(getStart2());
		
		setStart3(new JButton("Partida Local"));
		getStart3().setFont(new Font("courier", Font.PLAIN, 15));
		getStart3().setBounds(470, 110, 200, 45);
		panel.add(getStart3());

		setlocal1(new JButton("Cargar partida local"));
		getlocal1().setFont(new Font("courier", Font.PLAIN, 20));
		getlocal1().setBounds(215, 280, 300, 90);
		getlocal1().setVisible(false);
		panel.add(getlocal1());

		setReg(new JButton("Registrarse"));
		getReg().setFont(new Font("courier", Font.PLAIN, 20));
		getReg().setBounds(250, 280, 220, 90);
		getReg().setVisible(false);
		panel.add(getReg());

		setIni(new JButton("Iniciar Sesion"));
		getIni().setFont(new Font("courier", Font.PLAIN, 20));
		getIni().setBounds(250, 280, 220, 90);
		getIni().setVisible(false);
		panel.add(getIni());
		
		setBt2(new JButton("Crear partida nueva"));
		getBt2().setFont(new Font("courier", Font.PLAIN, 20));
		getBt2().setBounds(215, 180, 300, 90);
		getBt2().setVisible(false);
		panel.add(getBt2());

		tb1 = new JTextField("Username");
		getTb1().setFont(new Font("courier", Font.PLAIN, 20));
		getTb1().setBounds(295, 175, 140, 40);
		getTb1().setVisible(false);
		panel.add(getTb1());
		
		tb2 = new JTextField("Password");
		getTb2().setFont(new Font("courier", Font.PLAIN, 20));
		getTb2().setBounds(295, 215, 140, 40);
		getTb2().setVisible(false);
		panel.add(getTb2());
		
	}
	


	public boolean consulta(String nombre, String password) { //hacemos la consulta de inicio de sesion para comprobar usuario y contrase�a
		try {
			Class.forName(Driver);  //cargamos el driver que usaremos
			con = DriverManager.getConnection(cadenaConeccion, usuario, contrasena); //establecemos la conexion
			
			//hacer consulta

			Statement s =  con.createStatement(); //cargamos el Statement
			ResultSet rs = s.executeQuery ("select * from jugador where nombre ='" + nombre + "' and password ='" + password + "'"); //aqui escribimos la consulta, es algo lioso debido a las comillas de eclipse
			
			//ir� recorriendo fila por fila (siempre que la halla detectado la consulta)
			while (rs.next())
			{
				//guardamos el nombre del usuario para usarlo proximamente como en el titulo
			    setUser(rs.getString(2));
			    
			    //en el caso de que detecte el nombre de usuario devuelve true, que permitir� el acceso al juego
			    if (getUser()!="") {
					return true;
				
					//en caso de que no lo detecte, no lo dejar� entrar a jugar
				} else if (getUser()==""){
					return false;
					
				}
			}
			      
			      
			      
			      con.close(); //cierra conexion con la base de datos
		      //Ya no inserta dato
			return false;
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos " + e.getMessage()); //Preparamos mensaje de error por si acaso
			return false;
		}
	}
	
	public String ranking() {
		String ranking="";
		
		try {
			Class.forName(Driver); //cargamos el driver que usaremos
			con = DriverManager.getConnection(cadenaConeccion, usuario, contrasena); //establecemos la conexion
			
			//hacer consulta

			Statement s =  con.createStatement();
			ResultSet rs = s.executeQuery ("select * from jugador order by victorias desc"); //hacemos la consulta para el ranking
			
			while (rs.next())
			{
				//guardar� cada usuario en un String ranking y de esta forma hacer una interfaz mas bonita
				ranking +="-----------------------------------------------------------------------------------\n";
				ranking += rs.getString (2) + "\t " + rs.getInt (3)+ "\t " + rs.getInt(4) + "\t " + rs.getInt(5) + "\t" + (rs.getInt(3)+rs.getInt(4)+rs.getInt(5)) + "\n";
			}
			          
			      
			      con.close(); //cierra conexion con la base de datos
		      //Ya no inserta dato
			return ranking;  
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos " + e.getMessage()); //Preparamos mensaje de error por si acaso
			return ranking;  //en caso de no funcionar, devolvemos ranking, que ya esta por defecto como "", osea, como vacio.
		}
	}
	
	
	public boolean insert(String nombre, String password) { //crear nuevo usuario
		int id = 0;
		String name = ""; //solicitamos el nombre
		boolean check=false; //esto es para comprobar si el nombre ya est� o no en uso

		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(cadenaConeccion, usuario, contrasena);
			
			//consulta para saber el id necesario
			Statement s =  con.createStatement();
			ResultSet rs = s.executeQuery ("select max(id) from jugador"); //pedimos el id mas alto, para luego sumarle uno
			
			while (rs.next())
			{
				id = rs.getInt (1); //pedimos el id para que no se repita
			}
			   
			   id++; //le sumamos 1
			   

			ResultSet rs1 = s.executeQuery ("select nombre from jugador where nombre='" + nombre + "'");
			String test ="";
			
			while (rs1.next())
			{
				test=rs1.getString(1);
					check=true;
					
			}

			if (check==true) { //si est� en uso, ejecutara esto
				JOptionPane.showMessageDialog(null, "Este nombre de usuario ya est� en uso");
				con.close(); //cierra conexion
				return false; //devuelve false
				
			} else { //si no esta en uso, ejecuta lo siguiente 
				//Insertar 1 dato
				String query = "INSERT INTO jugador"+ " VALUES (?, ?, ?, ?, ?, ?)"; //cargamos la consulta para insertar los datos
				      // create the mysql insert preparedstatement
				      PreparedStatement preparedStmt = con.prepareStatement(query); //prepara el insert a ejecutar
				      //cada uno de los siguientes cambos es una columna distinta (debe estar en orden)
				      preparedStmt.setInt (1, id);
				      preparedStmt.setString (2, nombre);
				      preparedStmt.setInt (3, 0);
				      preparedStmt.setInt (4, 0);
				      preparedStmt.setInt (5, 0);
				      preparedStmt.setString (6, password);

				      preparedStmt.execute(); //Ejecuta el insert
				      
				      con.close(); //cierra conexion con la base de datos
			      //Ya no inserta dato
				      
				  JOptionPane.showMessageDialog(null, "Usuario Creado");
				  return true; //cuando esta creado devuelve true y permite al usuario jugar
			}
				  
				
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos " + e.getMessage()); //mensaje de error por si las moscas
				  return false;
			}
		
			 
		
	}
	
	public void UpdateWD(int victorias, int derrotas, int empate) { //metodo para actualizar cambios tras cada partida


		try {
			Class.forName(Driver); //cargamos el driver
			con = DriverManager.getConnection(cadenaConeccion, usuario, contrasena); //establecemos conexion
			
			//consulta para saber el id necesario
			Statement s =  con.createStatement();
			String update = "update jugador set victorias=?, derrotas=?, empates=? where nombre='" + username + "'"; //cargamos el update que haremos mas tarde
			PreparedStatement stmt = con.prepareStatement(update); //preparamos el update

			ResultSet rs1 = s.executeQuery ("select victorias, derrotas, empates from jugador where nombre = '" + username + "'"); //hacemos una consulta para sacar los datos que ya posee el jugador
			
			while (rs1.next())
			{
				//los guardamos en variables
				v = rs1.getInt (1);
				d = rs1.getInt(2);
				em = rs1.getInt(3);
			}
			
			//le sumamos los valores obtenido a traves del main
			v+=victorias;
			d+=derrotas;
			em+=empate;
			
			//insertamos los datos en el update escrito con anterioridad
		    stmt.setInt   (1, v);
		    stmt.setInt   (2, d);
		    stmt.setInt   (3, em);
		    
		    //ejecutamos el update y listo, cambios guardados
		    stmt.executeUpdate();
			
			 
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos " + e.getMessage()); //Por si acaso, mensaje de error
			}
	}
	

	public void setUser(String user) {
		username = user;
	}
	public String getUser() {
		return username;
	}

	public JTextField getTb1() {
		return tb1;
	}

	public void setTb1(JTextField tb1) {
		this.tb1 = tb1;
	}

	public JTextField getTb2() {
		return tb2;
	}

	public void setTb2(JTextField tb2) {
		this.tb2 = tb2;
	}
	
	public String getNombre() {
		  return username;
	  }

	public JButton getBt2() {
		return bt2;
	}

	public void setBt2(JButton bt2) {
		this.bt2 = bt2;
	}

	public JButton getStart1() {
		return Start1;
	}

	public void setStart1(JButton start1) {
		Start1 = start1;
	}

	public JButton getStart2() {
		return Start2;
	}

	public void setStart2(JButton start2) {
		Start2 = start2;
	}

	public JButton getStart3() {
		return Start3;
	}

	public void setStart3(JButton start3) {
		Start3 = start3;
	}

	public JButton getlocal1() {
		return local1;
	}

	public void setlocal1(JButton setlocal1) {
		this.local1 = setlocal1;
	}

	public JButton getIni() {
		return Ini;
	}

	public void setIni(JButton setIni) {
		this.Ini = setIni;
	}

	public JButton getReg() {
		return Reg;
	}

	public void setReg(JButton setReg) {
		this.Reg = setReg;
	}
	
	
	
	
;}