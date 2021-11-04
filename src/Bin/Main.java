package Bin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataBase.connect;
import GUIs.Dificultad;
import GUIs.Jugar;
import GUIs.MarcoTablero;
import GUIs.Menu;
import GUIs.Ranking;
import GUIs.Reglas;

public class Main {

	public static void main(String[] args) {

		//variables para precargar una partida guardada y asi evitar fallos
		String nombre = "";
		int victorias = 0, derrotas = 0, empates = 0;
		
		//cargamos el objeto SaverAndReader que se encarga de leer, guardar y actualizar el archivo de guardado
		SaverAndReader sar = new SaverAndReader();
		
		//Hace que intente leer cada ',' y separa las palabras y las guarda en su variable correspondiente
		try {
			String strMain = sar.leertxt(); //ejectua el metodo leer, que leera el archivo de guardado y lo guardar� todo en una variable String llamana texto
			//split hace que separe las palabras cuando detecta el caracter introducido
			String[] arrSplit = strMain.split(",");  
			for (int i = 0; i < arrSplit.length; i++)    { //al tener la variable la podemos ir separando por comas.
		    	if (i==0) {
		    		nombre = arrSplit[i];
				} else if (i==1) {
		    		victorias =	Integer.parseInt(arrSplit[i]);
				} else if (i==2) {
		    		derrotas =	Integer.parseInt(arrSplit[i]);
				} else if (i==3) {
		    		empates =	Integer.parseInt(arrSplit[i]);
				}
		    } 
		} catch (Exception e) {

		}
		
		//guardamos la partida preguardada en una variable
		jugador j1 = new jugador(nombre, victorias, derrotas, empates); //introducimos esos valores en un jugador

		//precargamos el menu inicial
		Menu m1 = new Menu();
		
		//cargamos la clase donde esta las conexiones a la base de datos y la interfaz de inicio de sesion
		connect con = new connect();
		con.setVisible(true);
		con.setResizable(true);
		con.getStart1().setVisible(true);
		con.getStart2().setVisible(true);
		con.getStart3().setVisible(true);

		//cuando pulsamos el boton uno ejecuta diversas acciones
		con.getStart1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Estas acciones son para habilitar los botones de inicio de sesion
				con.getIni().setVisible(true);
				con.getReg().setVisible(false);
				con.getlocal1().setVisible(false);
				con.getBt2().setVisible(false);
				con.getTb1().setVisible(true);
				con.getTb2().setVisible(true);
				
				con.getIni().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//Esto sirve para cuando sea hora de actualizar los cambios despues de cada partida, el programa sepa si debe guardarlo de forma local o subirlo a la nube
						j1.setLocal(false);

						//cuando el usuario da clic en iniciar sesion ejecuta lo siguiente
						if (con.consulta(con.getTb1().getText(), con.getTb2().getText())==true) {
							m1.setVisible(true);
							m1.setTitle("3 en Raya | Conectado como: " + con.getUser());
							m1.setResizable(true);
							con.dispose();
							
						} else {
							JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos");
						}

						
					}
				});

				
			}
		});
		
		con.getStart2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Estas acciones son para habilitar los botones de registro de nuevo usuario
				con.getReg().setVisible(true);
				con.getBt2().setVisible(false);
				con.getIni().setVisible(false);
				con.getlocal1().setVisible(false);
				con.getTb1().setVisible(true);
				con.getTb2().setVisible(true);
				
				con.getReg().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//Esto sirve para cuando sea hora de actualizar los cambios despues de cada partida, el programa sepa si debe guardarlo de forma local o subirlo a la nube
						j1.setLocal(false);
						//cuando el usuario da clic en registrarse ejecuta lo siguiente, esto hace que el usuario se guarde en la base de datos, luego el programa cargue el usuario a traves de una consulta
						if (con.insert(con.getTb1().getText(), con.getTb2().getText())==true) {
							if (con.consulta(con.getTb1().getText(), con.getTb2().getText())==true) {
								m1.setVisible(true);
								m1.setTitle("3 en Raya | Conectado como: " + con.getUser());
								m1.setResizable(true);
								con.dispose();
								
							}
						}
						
					}
				});
				

				
			}
		});
		
		con.getStart3().addActionListener(new ActionListener() {
			
			//Si da clic en partida local
			@Override
			public void actionPerformed(ActionEvent e) {
				//habilita las opciones necesarias para esta pesta�a
				con.getlocal1().setVisible(true);
				con.getIni().setVisible(false);
				con.getReg().setVisible(false);
				con.getBt2().setVisible(true);
				con.getTb1().setVisible(false);
				con.getTb2().setVisible(false);
				

				con.getlocal1().addActionListener(new ActionListener() {
					//cuando da clic en cargar partida, ejecuta esto y como la partida ya estaba precargada solo debe modificar un par de opciones
					@Override
					public void actionPerformed(ActionEvent e) {
						j1.setLocal(true);
						System.out.println(j1.toString());
						
						JOptionPane.showMessageDialog(null, "Bienvenido " + j1.getNombre());
						
						m1.setVisible(true);
						m1.setResizable(true);
						con.dispose();
						
						
					}
				});

				con.getBt2().addActionListener(new ActionListener() {
					//cuando da clic aqui, se crea una nueva partida, el usuario solo debe introducir su nombre deseado, el programa har� el resto
					@Override
					public void actionPerformed(ActionEvent e) {

						j1.setLocal(true);
						String nombre;

						nombre = JOptionPane.showInputDialog("Diga el nombre que desea tener");
						
						//ejecuta el metodo de crear partida
						sar.CrearPartida(nombre);
						
						m1.setVisible(true);
						m1.setResizable(true);
						con.dispose();

						
					}
				});

				
			}
		});

		// Cuando en el menu inicial "m1" das clic en reglas, ejecuta lo siguiente		
		m1.getBt1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Reglas reglas = new Reglas();
				reglas.setVisible(true);
				
				//si una vez en reglas das clic en 'Atras' vuelve al menu inicial
				reglas.getBt1().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						m1.setVisible(true);
						reglas.dispose();
					}
				});
				m1.dispose();
			}
		});

		// Cuando en el menu inicial "m1" das clic en jugar, ejecuta lo siguiente	
		m1.getBt2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Jugar jugar = new Jugar();
				jugar.setVisible(true);

				//permite ir hacia atras desde la interfaz de jugar (donde eliges el tipo de juego)
				jugar.getBt3().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						m1.setVisible(true);
						jugar.dispose();
					}
				});
				

				//permite ir hacia el modo de juego Jugador contra jugador
				jugar.getBt1().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						MarcoTablero mt1 = new MarcoTablero();
						mt1.setVisible(true);
						jugar.dispose();
						

						
						mt1.botonPVP();
						//prueba si esta jugando de forma local (para posteriormente guardar la partida de una forma u otra)
						if (j1.getLocal()==false) {

							mt1.setTitle("3 en Raya: " + con.getUser() + " vs " + "invitado");
							
							mt1.getBtA().addActionListener(new ActionListener() {

								int victorias=0, derrotas=0, empates=0;
								
								@Override
								public void actionPerformed(ActionEvent e) {
									//cuando acabe la partida y aparezca el boton "Atras" este boton sirve para guardar la partida
									m1.setVisible(true);
									m1.setResizable(false);
									mt1.dispose();
									
									victorias = mt1.getVictoria();
									derrotas = mt1.getDerrota();
									empates = mt1.getEmpate();
									
									mt1.setVictoria(0);
									mt1.setDerrota(0);
									mt1.setEmpate(0);
									
									con.UpdateWD(victorias, derrotas, empates);
								}
								
							});
						} else if (j1.getLocal()==true) {
							
							System.out.println(j1.getNombre());
							mt1.setTitle("3 en Raya: " + j1.getNombre() + " vs " + "invitado");
							
							mt1.getBtA().addActionListener(new ActionListener() {

								int victorias=0, derrotas=0, empates=0;
								
								@Override
								public void actionPerformed(ActionEvent e) {
									//cuando acabe la partida y aparezca el boton "Atras" este boton sirve para guardar la partida
									m1.setVisible(true);
									m1.setResizable(false);
									mt1.dispose();
									
									String strMain = sar.leertxt();
									
									//Esto es como lo visto anteriormente al precargar la partida, solo que le agregamos los valores obtenidos dentro del juego
									String[] arrSplit = strMain.split(",");  
									for (int i = 0; i < arrSplit.length; i++)    {
								    	if (i==0) {

										} else if (i==1) {
								    		victorias =	Integer.parseInt(arrSplit[i]) + mt1.getVictoria();
										} else if (i==2) {
								    		derrotas =	Integer.parseInt(arrSplit[i]) + mt1.getDerrota();
										} else if (i==3) {
								    		empates =	Integer.parseInt(arrSplit[i]) + mt1.getEmpate();
										}
								    } 
									
									sar.Update(j1.getNombre(), victorias, derrotas, empates);
								}
								
							});
							
						}
						//sirve para volver a cargar la interfaz y as�, coloque la ficha del boton.
						mt1.repaint();
					}
				});
				
				//cuando da clic en Jugador contra Bot, va a la interfaz de dificultad
				jugar.getBt2().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					
						jugar.dispose();
						Dificultad dificultad = new Dificultad();
						dificultad.setVisible(true);

						//permite ir hacia el modo de juego Jugador contra jugador
						dificultad.getBt3().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {

								jugar.setVisible(true);
								dificultad.dispose();
								
								
							}
						});
						
						//si da clic en el boton de dificultad normal ejecuta lo siguiente
						dificultad.getBt2().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {

								MarcoTablero mt1 = new MarcoTablero();
								mt1.setVisible(true);
								dificultad.dispose();
								mt1.setTitle("3 en Raya: " + con.getUser() + " vs " + "Bot Lvl 2");
								
								//esto hace que llame al metodo cuando se pulse un boton el cual ejecutara el metodo especial del bot de lvl 2
								mt1.botonBot2();
								

								//prueba si esta jugando de forma local (para posteriormente guardar la partida de una forma u otra)
								if (j1.getLocal()==false) {
								mt1.getBtA().addActionListener(new ActionListener() {

									int victorias=0, derrotas=0, empates=0;
									
									@Override
									public void actionPerformed(ActionEvent e) {
										//es exatamente igual que anteriormente, para guardar los balores en la base de datos
										m1.setVisible(true);
										m1.setResizable(false);
										mt1.dispose();
										
										victorias = mt1.getVictoria();
										derrotas = mt1.getDerrota();
										empates = mt1.getEmpate();
										
										mt1.setVictoria(0);
										mt1.setDerrota(0);
										mt1.setEmpate(0);
										
										con.UpdateWD(victorias, derrotas, empates);
									}
									
								});
								} else if (j1.getLocal()==true) {
									
									mt1.setTitle("3 en Raya: " + j1.getNombre() + " vs " + "Bot Lvl 2");
									
									mt1.getBtA().addActionListener(new ActionListener() {

										int victorias=0, derrotas=0, empates=0;
										
										@Override
										public void actionPerformed(ActionEvent e) {
											//esto es lo que se ejecuta cuando pulsamos 'atras'
											m1.setVisible(true);
											m1.setResizable(false);
											mt1.dispose();
											

											//Esto es como lo visto anteriormente al precargar la partida, solo que le agregamos los valores obtenidos dentro del juego
											String strMain = sar.leertxt();
											String[] arrSplit = strMain.split(",");  
											for (int i = 0; i < arrSplit.length; i++)    {
										    	if (i==0) {

												} else if (i==1) {
										    		victorias =	Integer.parseInt(arrSplit[i]) + mt1.getVictoria();
												} else if (i==2) {
										    		derrotas =	Integer.parseInt(arrSplit[i]) + mt1.getDerrota();
												} else if (i==3) {
										    		empates =	Integer.parseInt(arrSplit[i]) + mt1.getEmpate();
												}
										    } 
											
											sar.Update(j1.getNombre(), victorias, derrotas, empates);
										}
										
									});
									
								}
								
								mt1.repaint();
							}
						});
						
						//Es exactamente igual que el anterior, lo unico que varia es que al colocar nuestra ficha, llama al metodo del bot de dificultad Facil
						dificultad.getBt1().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {

								MarcoTablero mt1 = new MarcoTablero();
								mt1.setVisible(true);
								dificultad.dispose();
								mt1.setTitle("3 en Raya: " + con.getUser() + " vs " + "Bot Lvl 1");
								
								//metodo del bot que colocar� su ficha una vez pongamos nosotros la nuestra
								mt1.botonBot1();
								

								if (j1.getLocal()==false) {
								mt1.getBtA().addActionListener(new ActionListener() {

									int victorias=0, derrotas=0, empates=0;
									
									@Override
									public void actionPerformed(ActionEvent e) {
										m1.setVisible(true);
										m1.setResizable(false);
										mt1.dispose();
										
										victorias = mt1.getVictoria();
										derrotas = mt1.getDerrota();
										empates = mt1.getEmpate();
										
										mt1.setVictoria(0);
										mt1.setDerrota(0);
										mt1.setEmpate(0);
										
										con.UpdateWD(victorias, derrotas, empates);
									}

								});
								} else if (j1.getLocal()==true) {
									
									System.out.println(j1.getNombre());
									mt1.setTitle("3 en Raya: " + j1.getNombre() + " vs " + "invitado");
									
									mt1.getBtA().addActionListener(new ActionListener() {

										int victorias=0, derrotas=0, empates=0;
										
										@Override
										public void actionPerformed(ActionEvent e) {
											m1.setVisible(true);
											m1.setResizable(false);
											mt1.dispose();
											
											String strMain = sar.leertxt();
											String[] arrSplit = strMain.split(",");  
											for (int i = 0; i < arrSplit.length; i++)    {
										    	if (i==0) {

												} else if (i==1) {
										    		victorias =	Integer.parseInt(arrSplit[i]) + mt1.getVictoria();
												} else if (i==2) {
										    		derrotas =	Integer.parseInt(arrSplit[i]) + mt1.getDerrota();
												} else if (i==3) {
										    		empates =	Integer.parseInt(arrSplit[i]) + mt1.getEmpate();
												}
										    } 
											
											sar.Update(j1.getNombre(), victorias, derrotas, empates);
										}
										
									});
									
								}
								
								//Pinta cuando el bot haga un cambio
								mt1.repaint();
							}
						});
					}
				});
				//cierra la pesta�a de menu mientras se juega
				m1.dispose();
			}
		});

		// Cuando en el menu damos clic sobre el boton Ranking, nos lleva a el
		m1.getBt3().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//Ejecutamos la interfaz ranking
				Ranking ranking = new Ranking();
				ranking.setVisible(true);
				ranking.getBt1().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						m1.setVisible(true);
						ranking.dispose();
					}
				});
				m1.dispose();
			}
		});

		// Cuando pulsamos el boton salir en nuestro menu, el programa se cerrar� completamente
		m1.getBt4().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}
	
	
	
}
