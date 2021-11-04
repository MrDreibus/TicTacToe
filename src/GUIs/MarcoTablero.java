package GUIs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarcoTablero extends JFrame implements Runnable{
	//ATRIBUTOS
	private JPanel panel;
	private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btA;
	private JLabel etiqueta;
	
	private int victoria=0, derrota=0, empate=0;
	private boolean turno = false;
	
	//METODOS
	public MarcoTablero() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tamaño de pantalla y la ubicacion
		Toolkit monitor = Toolkit.getDefaultToolkit();
		Dimension tamanio = monitor.getScreenSize();
		int alturaM = tamanio.height;
		int anchuraM = tamanio.width; 
				
		setBounds(anchuraM/4, alturaM/4, anchuraM/2, alturaM/2);

		Image iconoAPP=monitor.getImage("src/icono.png");
		setIconImage(iconoAPP);
		
		iniciarElemento();
		
	}
	
	public void colocarPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
	}
	
	public void iniciarElemento() {
		colocarPanel();
		colocarBoton();	
	}
	
	private void colocarBoton() {
		bt1 = new JButton();
		bt1.setBounds(160, 30, 125, 125);
		panel.add(bt1);

		bt2 = new JButton();
		bt2.setBounds(160, 160, 125, 125);
		panel.add(bt2);
		
		bt3 = new JButton();
		bt3.setBounds(160, 290, 125, 125);
		panel.add(bt3);
		
		bt4 = new JButton();
		bt4.setBounds(295, 30, 125, 125);
		panel.add(bt4);

		bt5 = new JButton();
		bt5.setBounds(295, 160, 125, 125);
		panel.add(bt5);
		
		bt6 = new JButton();
		bt6.setBounds(295, 290, 125, 125);
		panel.add(bt6);
		
		bt7 = new JButton();
		bt7.setBounds(430, 30, 125, 125);
		panel.add(bt7);

		bt8 = new JButton();
		bt8.setBounds(430, 160, 125, 125);
		panel.add(bt8);

		bt9 = new JButton();
		bt9.setBounds(430, 290, 125, 125);
		panel.add(bt9);
		
		btA = new JButton();
		btA.setText("Volver al menu");
		btA.setFont(new Font("courier", Font.PLAIN, 30));
		btA.setBounds(220, 390, 380, 80);
		getBtA().setVisible(false);
		panel.add(btA);
		
		etiqueta = new JLabel("");
		etiqueta.setBounds(308, 160, 800, 80);
		etiqueta.setFont(new Font("ZapfDingbats", Font.BOLD, 50));
		etiqueta.setVisible(false);
		panel.add(etiqueta);

		
	}

	//Metodo click de los botones (X O)
	//Metodo para Jugador contra Jugador
	public void botonPVP() {
		
		getBt1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt1().setText("X");
					setTurno(true);
				} else {
					getBt1().setText("O");
					setTurno(false);
				}
				getBt1().setEnabled(false);

				fin();
			}
		});

		getBt2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt2().setText("X");
					setTurno(true);
				} else {
					getBt2().setText("O");
					setTurno(false);
				}
				getBt2().setEnabled(false);

				fin();
			}
		});

		getBt3().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt3().setText("X");
					setTurno(true);
				} else {
					getBt3().setText("O");
					setTurno(false);
				}
				getBt3().setEnabled(false);

				fin();
			}
		});

		getBt4().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt4().setText("X");
					setTurno(true);
				} else {
					getBt4().setText("O");
					setTurno(false);
				}
				getBt4().setEnabled(false);

				fin();
			}
		});

		getBt5().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt5().setText("X");
					setTurno(true);
				} else {
					getBt5().setText("O");
					setTurno(false);
				}
				getBt5().setEnabled(false);

				fin();
			}
		});

		getBt6().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt6().setText("X");
					setTurno(true);
				} else {
					getBt6().setText("O");
					setTurno(false);
				}
				getBt6().setEnabled(false);

				fin();
			}
		});

		getBt7().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt7().setText("X");
					setTurno(true);
				} else {
					getBt7().setText("O");
					setTurno(false);
				}
				getBt7().setEnabled(false);
				
				fin();
			}
		});

		getBt8().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt8().setText("X");
					setTurno(true);
				} else {
					getBt8().setText("O");
					setTurno(false);
				}
				getBt8().setEnabled(false);
				
				fin();
			}
		});
		
		getBt9().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTurno()==false) {
					getBt9().setText("X");
					setTurno(true);
				} else {
					getBt9().setText("O");
					setTurno(false);
				}
				getBt9().setEnabled(false);
				
				fin();			}
		});
		
		repaint();
	}
	
	//metodo botones para bot 2
	public void botonBot2() {
		getBt1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt1().setText("X");
				getBt1().setEnabled(false);
				
				botLv2();

				fin();
			}
		});
		repaint();
		getBt2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt2().setText("X");
				getBt2().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt3().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt3().setText("X");
				getBt3().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt4().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt4().setText("X");
				getBt4().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt5().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt5().setText("X");
				getBt5().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt6().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt6().setText("X");
				getBt6().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt7().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt7().setText("X");
				getBt7().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt8().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt8().setText("X");
				getBt8().setEnabled(false);

				botLv2();

				fin();
			}
		});
		repaint();
		getBt9().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt9().setText("X");
				getBt9().setEnabled(false);

				botLv2();

				fin();			
			}
		});
		repaint();
	}
	
//metodo bot1
	public void botonBot1() {
		getBt1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt1().setText("X");
				getBt1().setEnabled(false);
				//bot();
				bot();

				fin();
			}
		});
		repaint();
		getBt2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt2().setText("X");
				getBt2().setEnabled(false);
				//bot();
				bot();

				fin();
			}
		});
		repaint();
		getBt3().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt3().setText("X");
				getBt3().setEnabled(false);
				//bot();
				bot();

				fin();
			}
		});
		repaint();
		getBt4().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt4().setText("X");
				getBt4().setEnabled(false);
				//bot();
				bot();

				fin();
			}
		});
		repaint();
		getBt5().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt5().setText("X");
				getBt5().setEnabled(false);
				//bot();
				bot();

				fin();
			}
		});
		repaint();
		getBt6().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt6().setText("X");
				getBt6().setEnabled(false);
				//bot();
				bot();

				fin();
			}
		});
		repaint();
		getBt7().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt7().setText("X");
				getBt7().setEnabled(false);
				//bot();
				bot();
				
				fin();
			}
		});
		repaint();
		getBt8().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt8().setText("X");
				getBt8().setEnabled(false);
				//bot();
				bot();
				
				fin();
			}
		});
		repaint();
		getBt9().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBt9().setText("X");
				getBt9().setEnabled(false);
				//bot();
				bot();
				
				fin();			}
		});
		repaint();
	}
	
	//Metodo del bots 
		public void bot() {
			int random;
			boolean sheck = false;
			
			
			do {
				random = (int)(Math.random()*9);
				
				if (random == 1) {
					if (getBt1().getText() == "") {
						getBt1().setText("O");
						getBt1().setEnabled(false);
						sheck = true;
					}
				}
				
				if (random == 2) {
					if (getBt2().getText() == "") {
						getBt2().setText("O");
						getBt2().setEnabled(false);
						sheck = true;
					}
				}
				if (random == 3) {
					if (getBt3().getText() == "") {
						getBt3().setText("O");
						getBt3().setEnabled(false);
						sheck = true;
					}
				}
				
				if (random == 4) {
					if (getBt4().getText() == "") {
						getBt4().setText("O");
						getBt4().setEnabled(false);
						sheck = true;
					}
				}
				if (random == 5) {
					if (getBt5().getText() == "") {
						getBt5().setText("O");
						getBt5().setEnabled(false);
						sheck = true;
					}
				}
				if (random == 6) {
					if (getBt6().getText() == "") {
						getBt6().setText("O");
						getBt6().setEnabled(false);
						sheck = true;
					}
				}
				if (random == 7) {
					if (getBt7().getText() == "") {
						getBt7().setText("O");
						getBt7().setEnabled(false);
						sheck = true;
					}
				}
				if (random == 8) {
					if (getBt8().getText() == "") {
						getBt8().setText("O");
						getBt8().setEnabled(false);
						sheck = true;
					}
				}
				if (random == 9) {
					if (getBt9().getText() == "") {
						getBt9().setText("O");
						getBt9().setEnabled(false);
						sheck = true;
					}
				}
				if (getBt1().getText() != "" && getBt2().getText() != "" && getBt3().getText() != "" && getBt4().getText() != "" && getBt5().getText() != "" && getBt6().getText() != "" && getBt7().getText() != "" && getBt8().getText() != "" && getBt9().getText() != "") {
					sheck = true;
				}
			}while(sheck != true);
		}
		
		public void botLv2() {
			int random, aleatorio;
			boolean check = false;
				
			aleatorio = (int)(Math.random()*4+1);
			if (aleatorio >= 2) {
					
				//Bot coloca "O"  para ganar
				if ((getBt1().getText().equalsIgnoreCase("O")) && (getBt4().getText().equalsIgnoreCase("O")) && (getBt7().getText().equalsIgnoreCase("")))  {
					getBt7().setText("O");
					getBt7().setEnabled(false);
				}else if ((getBt7().getText().equalsIgnoreCase("O")) && (getBt4().getText().equalsIgnoreCase("O")) && (getBt1().getText().equalsIgnoreCase("")) ){
					getBt1().setText("O");
					getBt1().setEnabled(false);

				}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt2().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("")) ){
					getBt3().setText("O");
					getBt3().setEnabled(false);

				}else if((getBt2().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("O")) && (getBt1().getText().equalsIgnoreCase("")) ) {
					getBt1().setText("O");
					getBt1().setEnabled(false);
	
				}else if((getBt2().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt8().getText().equalsIgnoreCase("")) ){
					getBt8().setText("O");
					getBt8().setEnabled(false);

				}else if((getBt8().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt2().getText().equalsIgnoreCase("")) ) {
					getBt2().setText("O");
					getBt2().setEnabled(false);

				}else if((getBt3().getText().equalsIgnoreCase("O")) && (getBt6().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("")) ){
					getBt9().setText("O");
					getBt9().setEnabled(false);

				}else if((getBt9().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("")) ) {
					getBt3().setText("O");
					getBt3().setEnabled(false);
	
				}else if((getBt4().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt6().getText().equalsIgnoreCase("")) ){
					getBt6().setText("O");
					getBt6().setEnabled(false);

				}else if((getBt6().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt4().getText().equalsIgnoreCase("")) ) {
					getBt4().setText("O");
					getBt4().setEnabled(false);

				}else if((getBt7().getText().equalsIgnoreCase("O")) && (getBt8().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("")) ){
					getBt9().setText("O");
					getBt9().setEnabled(false);
					
				}else if((getBt9().getText().equalsIgnoreCase("O")) && (getBt8().getText().equalsIgnoreCase("O")) && (getBt7().getText().equalsIgnoreCase("")) ){
					getBt7().setText("O");
					getBt7().setEnabled(false);
					
				}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt7().getText().equalsIgnoreCase("O")) && (getBt4().getText().equalsIgnoreCase("")) ){
					getBt4().setText("O");
					getBt4().setEnabled(false);	
					
				}else if((getBt2().getText().equalsIgnoreCase("O")) && (getBt8().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);
					
				}else if((getBt3().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("O")) && (getBt6().getText().equalsIgnoreCase("")) ){
					getBt6().setText("O");
					getBt6().setEnabled(false);
					
				}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("O")) && (getBt2().getText().equalsIgnoreCase("")) ){
					getBt2().setText("O");
					getBt2().setEnabled(false);	
					
				}else if((getBt4().getText().equalsIgnoreCase("O")) && (getBt6().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);
					
				}else if((getBt7().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("O")) && (getBt8().getText().equalsIgnoreCase("")) ){
					getBt8().setText("O");
					getBt8().setEnabled(false);	
					
				}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("")) ){
					getBt9().setText("O");
					getBt9().setEnabled(false);	
					
				}else if((getBt9().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt1().getText().equalsIgnoreCase("")) ){
					getBt1().setText("O");
					getBt1().setEnabled(false);
					
				}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);	
					
				}else if((getBt3().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt7().getText().equalsIgnoreCase("")) ){
					getBt7().setText("O");
					getBt7().setEnabled(false);	
					
				}else if((getBt7().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("")) ){
					getBt3().setText("O");
					getBt3().setEnabled(false);
					
				}else if((getBt7().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);
			
				//Bot bloquea si el jugador esta a uno de ganar	
				}else if ((getBt1().getText().equalsIgnoreCase("x")) && (getBt4().getText().equalsIgnoreCase("x")) && (getBt7().getText().equalsIgnoreCase("")))  {
					getBt7().setText("O");
					getBt7().setEnabled(false);
				}else if ((getBt7().getText().equalsIgnoreCase("x")) && (getBt4().getText().equalsIgnoreCase("x")) && (getBt1().getText().equalsIgnoreCase("")) ){
					getBt1().setText("O");
					getBt1().setEnabled(false);
	
				}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt2().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("")) ){
					getBt3().setText("O");
					getBt3().setEnabled(false);
	
				}else if((getBt2().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("x")) && (getBt1().getText().equalsIgnoreCase("")) ) {
					getBt1().setText("O");
					getBt1().setEnabled(false);
		
				}else if((getBt2().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt8().getText().equalsIgnoreCase("")) ){
					getBt8().setText("O");
					getBt8().setEnabled(false);
	
				}else if((getBt8().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt2().getText().equalsIgnoreCase("")) ) {
					getBt2().setText("O");
					getBt2().setEnabled(false);
	
				}else if((getBt3().getText().equalsIgnoreCase("x")) && (getBt6().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("")) ){
					getBt9().setText("O");
					getBt9().setEnabled(false);
	
				}else if((getBt9().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("")) ) {
					getBt3().setText("O");
					getBt3().setEnabled(false);
		
				}else if((getBt4().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt6().getText().equalsIgnoreCase("")) ){
					getBt6().setText("O");
					getBt6().setEnabled(false);
	
				}else if((getBt6().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt4().getText().equalsIgnoreCase("")) ) {
					getBt4().setText("O");
					getBt4().setEnabled(false);
	
				}else if((getBt7().getText().equalsIgnoreCase("x")) && (getBt8().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("")) ){
					getBt9().setText("O");
					getBt9().setEnabled(false);
						
				}else if((getBt9().getText().equalsIgnoreCase("x")) && (getBt8().getText().equalsIgnoreCase("x")) && (getBt7().getText().equalsIgnoreCase("")) ){
					getBt7().setText("O");
					getBt7().setEnabled(false);
						
				}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt7().getText().equalsIgnoreCase("x")) && (getBt4().getText().equalsIgnoreCase("")) ){
					getBt4().setText("O");
					getBt4().setEnabled(false);	
						
				}else if((getBt2().getText().equalsIgnoreCase("x")) && (getBt8().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);
						
				}else if((getBt3().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("x")) && (getBt6().getText().equalsIgnoreCase("")) ){
					getBt6().setText("O");
					getBt6().setEnabled(false);
						
				}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("x")) && (getBt2().getText().equalsIgnoreCase("")) ){
					getBt2().setText("O");
					getBt2().setEnabled(false);	
					
				}else if((getBt4().getText().equalsIgnoreCase("x")) && (getBt6().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);
						
				}else if((getBt7().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("x")) && (getBt8().getText().equalsIgnoreCase("")) ){
					getBt8().setText("O");
					getBt8().setEnabled(false);	
						
				}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("")) ){
					getBt9().setText("O");
					getBt9().setEnabled(false);	
						
				}else if((getBt9().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt1().getText().equalsIgnoreCase("")) ){
					getBt1().setText("O");
					getBt1().setEnabled(false);
						
				}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);	
						
				}else if((getBt3().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt7().getText().equalsIgnoreCase("")) ){
					getBt7().setText("O");
					getBt7().setEnabled(false);	
						
				}else if((getBt7().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("")) ){
					getBt3().setText("O");
					getBt3().setEnabled(false);
					
				}else if((getBt7().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("")) ){
					getBt5().setText("O");
					getBt5().setEnabled(false);	
						
				}else {
					do {
						random = (int)(Math.random()*9);
							
							if (random == 1) {
								if (getBt1().getText() == "") {
									getBt1().setText("O");
									getBt1().setEnabled(false);
									check = true;
								}
							}
							
							if (random == 2) {
								if (getBt2().getText() == "") {
									getBt2().setText("O");
									getBt2().setEnabled(false);
									check = true;
								}
							}
							if (random == 3) {
								if (getBt3().getText() == "") {
									getBt3().setText("O");
									getBt3().setEnabled(false);
									check = true;
								}
							}
							
							if (random == 4) {
								if (getBt4().getText() == "") {
									getBt4().setText("O");
									getBt4().setEnabled(false);
									check = true;
								}
							}
							if (random == 5) {
								if (getBt5().getText() == "") {
									getBt5().setText("O");
									getBt5().setEnabled(false);
									check = true;
								}
							}
							if (random == 6) {
								if (getBt6().getText() == "") {
									getBt6().setText("O");
									getBt6().setEnabled(false);
									check = true;
								}
							}
							if (random == 7) {
								if (getBt7().getText() == "") {
									getBt7().setText("O");
									getBt7().setEnabled(false);
									check = true;
								}
							}
							if (random == 8) {
								if (getBt8().getText() == "") {
									getBt8().setText("O");
									getBt8().setEnabled(false);
									check = true;
								}
							}
							if (random == 9) {
								if (getBt9().getText() == "") {
									getBt9().setText("O");
									getBt9().setEnabled(false);
									check = true;
								}
							}
							if (getBt1().getText() != "" && getBt2().getText() != "" && getBt3().getText() != "" && getBt4().getText() != "" && getBt5().getText() != "" && getBt6().getText() != "" && getBt7().getText() != "" && getBt8().getText() != "" && getBt9().getText() != "") {
								check = true;
							}
						}while(check != true);
					}
				}else {
					bot();
				}
			}		
	
		
	//Comprueba si el tablero esta cogido entero, para ocultarlo	
	public String tablero() {
		
		String datos;
		
		if (getBt1().getText() != "" && getBt2().getText() != "" && getBt3().getText() != "" && getBt4().getText() != "" && getBt5().getText() != "" && getBt6().getText() != "" && getBt7().getText() != "" && getBt8().getText() != "" && getBt9().getText() != "") {
			return datos = "true";
		}
		else {
			return datos = "false";
		}
	}

	
	public void fin() {
		//Comprobacion que gane el bot
		if ((getBt1().getText().equalsIgnoreCase("O")) && (getBt4().getText().equalsIgnoreCase("O")) && (getBt7().getText().equalsIgnoreCase("O")))  {
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");
			
		}else if ((getBt2().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt8().getText().equalsIgnoreCase("O")) ){
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");
		}else if((getBt3().getText().equalsIgnoreCase("O")) && (getBt6().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("O")) ){
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");

		}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt2().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("O")) ) {
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");

		}else if((getBt4().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt6().getText().equalsIgnoreCase("O")) ){
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");

		}else if((getBt8().getText().equalsIgnoreCase("O")) && (getBt7().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("O")) ) {
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");

		}else if((getBt1().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt9().getText().equalsIgnoreCase("O")) ){
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");

		}else if((getBt7().getText().equalsIgnoreCase("O")) && (getBt5().getText().equalsIgnoreCase("O")) && (getBt3().getText().equalsIgnoreCase("O")) ) {
			JOptionPane.showMessageDialog(null, "Has perdido.");
			derrota++;
			close("Derrota");
			
		
			//Comprobacion que gane el jugador
		}else if ((getBt1().getText().equalsIgnoreCase("x")) && (getBt4().getText().equalsIgnoreCase("x")) && (getBt7().getText().equalsIgnoreCase("x")))  {
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");
			
		}else if ((getBt2().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt8().getText().equalsIgnoreCase("x")) ){
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");

		}else if((getBt3().getText().equalsIgnoreCase("x")) && (getBt6().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("x")) ){
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");

		}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt2().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("x")) ) {
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");

		}else if((getBt4().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt6().getText().equalsIgnoreCase("x")) ){
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");

		}else if((getBt8().getText().equalsIgnoreCase("x")) && (getBt7().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("x")) ) {
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");

		}else if((getBt1().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt9().getText().equalsIgnoreCase("x")) ){
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");

		}else if((getBt7().getText().equalsIgnoreCase("x")) && (getBt5().getText().equalsIgnoreCase("x")) && (getBt3().getText().equalsIgnoreCase("x")) ) {
			JOptionPane.showMessageDialog(null, "Has ganado.");
			victoria++;
			close("Victoria");
			
		}else if (getBt1().getText() != "" && getBt2().getText() != "" && getBt3().getText() != "" && getBt4().getText() != "" && getBt5().getText() != "" && getBt6().getText() != "" && getBt7().getText() != "" && getBt8().getText() != "" && getBt9().getText() != ""){
			JOptionPane.showMessageDialog(null, "Habeis quedado empate.");
			empate++;
			close("Empate");
		}
		
		
	}
	
	public void close(String estado) {
		getEtiqueta().setText(estado);
		getEtiqueta().setVisible(true);
		getBtA().setVisible(true);
		
		bt1.setVisible(false);
		bt2.setVisible(false);
		bt3.setVisible(false);
		bt4.setVisible(false);
		bt5.setVisible(false);
		bt6.setVisible(false);
		bt7.setVisible(false);
		bt8.setVisible(false);
		bt9.setVisible(false);
	}
	
	
	//Getters de los botones
	public JButton getBt1() {
		return bt1;
	}

	public JButton getBt2() {
		return bt2;
	}

	public JButton getBt3() {
		return bt3;
	}

	public JButton getBt4() {
		return bt4;
	}

	public JButton getBt5() {
		return bt5;
	}

	public JButton getBt6() {
		return bt6;
	}

	public JButton getBt7() {
		return bt7;
	}

	public JButton getBt8() {
		return bt8;
	}

	public JButton getBt9() {
		return bt9;
	}

	public JButton getBtA() {
		return btA;
	}

	public int getVictoria() {
		return victoria;
	}
	
	public int getDerrota() {
		return derrota;
	}
	
	public int getEmpate() {
		return empate;
	}
	
	public void setVictoria(int victoria) {
		this.victoria=victoria;
	}
	
	public void setDerrota(int derrota) {
		this.derrota=derrota;
	}
	
	public void setEmpate(int empate) {
		this.empate=empate;
	}
	
	

	public JLabel getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	

	public boolean getTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
