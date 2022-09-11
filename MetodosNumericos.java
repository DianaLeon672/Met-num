package MetodosNumericos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MetodosNumericos{
	
	public static miMarco marco1;
	public static miMarco marco2;
	public static Ventana ventana;
	public static void main(String[] args){
		marco1 = new miMarco();
		marco1.setTitle("Método numéricos");
		Panel panel = new Panel();
		marco1.add(panel);
		ventana = new Ventana();
		marco1.addWindowListener(ventana);
		marco1.setVisible(true);
	}
	//validacion que no permite letras en las cajas de los terminos de la ecuación
	public static void num(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(((caracter >'9'))&& (caracter != '\b')){
				e.consume(); 
				}
			}
		});
	}	
	//valida decimales; evitar error cuando se indique el grado de la ecuación
	public static boolean validaDecimal(String id) {
		boolean valido=true;
		if (id.matches(".")){
			valido= false;
		}else {	
			valido= true;
		}
		return valido;
			
	}
	//Procedimiento que devuelve la cadena de la fecha del sistema
	public static String getFecha(){
		Calendar fecha = new GregorianCalendar();
		String anio = Integer.toString(fecha.get(Calendar.YEAR));
		int num_mes = fecha.get(Calendar.MONTH);
		String mes ="";
		switch(num_mes){
			case 0:
				mes = "Ene";
				break;
			case 1:
				mes = "Feb";
				break;
			case 2:
				mes = "Mar";
				break;
			case 3:
				mes = "Abr";
				break;
			case 4:
				mes = "May";
				break;
			case 5:
				mes = "Jun";
				break;
			case 6:
				mes = "Jul";
				break;
			case 7:
				mes = "Ago";
				break;
			case 8:
				mes = "Sep";
				break;
			case 9:
				mes = "Oct";
				break;
			case 10:
				mes = "Nov";
				break;
			case 11:
				mes = "Dic";
				break;
		}
		
		String dia = Integer.toString(fecha.get(Calendar.DATE));
		return dia +"-" + mes +"-"+ anio;
	}
	



}
	
	class Ventana implements WindowListener{
		public void windowActivated(WindowEvent e){}
		public void windowClose(WindowEvent e){}
		public void windowClosing(WindowEvent e){}
		public void windowDeactivated(WindowEvent e){
			MetodosNumericos.marco1.dispose();
	}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
		public void windowClosed(WindowEvent e) {}
}
	class miMarco extends JFrame{
		public static JLabel lblReloj;
		//Construye el marco principal centrado en la pantalla 
		public miMarco() {
			lblReloj = new JLabel();
			//Crea el objeto reloj para que cambie el segundero de la hora desplegada
			new Reloj();
			Toolkit pantalla = Toolkit.getDefaultToolkit();
			Dimension tamanoPantalla = pantalla.getScreenSize();
			int alturaPantalla = tamanoPantalla.height;
			int anchoPantalla = tamanoPantalla.width;
			setSize(anchoPantalla/2,alturaPantalla/2);
			setLocation(anchoPantalla/4,alturaPantalla/4);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	class Panel extends JPanel{
		public static Adios adios;
		public Panel(){
			JPanel panel_fecha_hora = new JPanel();
			JPanel panel_fecha = new JPanel();
			//panel_fecha_hora.setBackground(Color.yellow);
			panel_fecha_hora.setLayout(new BorderLayout());
			setLayout(new BorderLayout());
			Biseccion biseccion = new Biseccion();
			//setLayout(new BorderLayout(10,10));
			JButton btnBiseccion = new JButton("Biseccion");
			panel_fecha_hora.add(new JLabel(MetodosNumericos.getFecha()),BorderLayout.EAST);
			panel_fecha_hora.add(miMarco.lblReloj,BorderLayout.WEST);
			add(panel_fecha_hora,BorderLayout.NORTH);
			add(new JLabel(MetodosNumericos.getFecha()));
			JPanel panel1 = new JPanel(); 
			//panel1.setBackground(Color.green);
			add(panel1);
			panel1.add(btnBiseccion,BorderLayout.CENTER);
			btnBiseccion.addActionListener(biseccion);
			adios = new Adios();
			JButton btnAdios = new JButton("Adios");
			JPanel panel2= new JPanel();
			add(panel2,BorderLayout.SOUTH);
			panel2.add(btnAdios,BorderLayout.SOUTH);
			btnAdios.addActionListener(adios);
		}
	}	
	//Acción al oprimir Botón salir
    class Adios implements ActionListener{
    	//Sale de la aplicación
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
    //Clase para controlar las acciones al oprimir botón Bisección
    class Biseccion implements ActionListener{
    	public static JTextField TxtGrado;
    	//Acciones cuando se ejecuta el botón Bisección
    	public void actionPerformed(ActionEvent e) {
    		marco2 = new miMarco();
    		Ventana ventana = new Ventana();
    		marco2.addWindowListener(ventana);
    		ventana2();
    	}
    	public void ventana2(){
    		JPanel panel_fecha_hora = new JPanel();
    		panel_fecha_hora.setLayout(new BorderLayout());
    		panel_fecha_hora.add(new JLabel(MetodosNumericos.getFecha()),BorderLayout.EAST);
			panel_fecha_hora.add(miMarco.lblReloj,BorderLayout.WEST);
    		marco2.add(panel_fecha_hora,BorderLayout.NORTH);
    		TxtGrado = new JTextField(3);
    		MetodosNumericos.num(TxtGrado);
    		JPanel panel3 = new JPanel();
    		panel3.add(new JLabel("Grado de la ecuación: "));
    		panel3.add(TxtGrado);
    		Panel_down pd = new Panel_down();
    		marco2.add(panel3,BorderLayout.CENTER);
    		marco2.add(pd,BorderLayout.SOUTH);
    		marco2.setTitle("MetodosNumericos");
    		marco2.setVisible(true);
    	}
    	class Panel_down extends JPanel{
    		public Panel_down(){
    			JButton btnBack = new JButton("Regresar");
    			add(btnBack);
    			Regresar regresar = new Regresar();
    			btnBack.addActionListener(regresar);
    			JButton btnDatos = new JButton("Datos");
    			add(btnDatos);
    			Datos datos = new Datos();
    			btnDatos.addActionListener(datos);
    		}
    		//Regresa a la pantalla anterior
    		class Regresar implements ActionListener {
    	    	public void actionPerformed(ActionEvent e) {
    	    		marco2.setVisible(false);
    	    		Panel p = new Panel();
    	    		MetodosNumericos.marco1.setVisible(true);
    	    		MetodosNumericos.marco1 = new miMarco();
    	    		
    	    	}
    	    }
    		//Botón Datos implementación de la acción
    		class Datos implements ActionListener {
    			public JPanel panel;
    			public static JPanel panel1;
    			public JPanel panel2;
    			public static JPanel panel3;
    			public static JPanel panel_raices;
    			public static JPanel panel_grafica;
    			public static JButton btnGraficar;
    			public static JTextField limite_superior;
    			public static JTextField limite_inferior;
    			//Evento al oprimir el botón Datos
    			public void actionPerformed(ActionEvent e) {
    				//Valida que se introduzca texto para indicar el grado de la ecuación 
    				//que sea un número positivo
    				if(TxtGrado.getText().length()!=0 && Integer.parseInt(TxtGrado.getText())>0) {
    					marco3 = new miMarco();
    					ventana3();
    					//marco2.dispose();
    				}
    			}
    			//Dibuja los elementos graficos de la ventana de introducción de los terminos de la ecuación
    			public void ventana3() {
    				JPanel panel_fecha_hora = new JPanel();
    				panel_fecha_hora.setLayout(new BorderLayout());
    	    		panel_fecha_hora.add(new JLabel(MetodosNumericos.getFecha()),BorderLayout.EAST);
    				panel_fecha_hora.add(miMarco.lblReloj,BorderLayout.WEST);
    				panel3 = new JPanel(); 
    				panel_raices= new JPanel(); //Panel donde despliega las raices calculadas
    				panel_grafica =new JPanel();
    				marco3.add(panel_fecha_hora,BorderLayout.NORTH);
    				panel1 = new JPanel(); //panel de los terminos de la ecuación
    				//panel1.setBackground(Color.gray);
    				panel3.setLayout(new BorderLayout());
    				//panel3.setBackground(Color.GRAY);
    				panel3.add(panel1,BorderLayout.NORTH); //panel1 es el panel de los términos de la ecuación
    				panel = new JPanel();
    				panel_grafica.setBackground(Color.LIGHT_GRAY);
    				panel3.add(panel_grafica,BorderLayout.CENTER);
    				panel_raices.setBackground(Color.pink);
    				panel3.add(panel_raices,BorderLayout.SOUTH);
    				JButton btnEjecutar = new JButton("Ejecutar");
    				JButton btnSalir = new JButton("Salir");
    				JButton btnLimpiar = new JButton("Regresar");
    				btnGraficar = new JButton("Graficar");
    				btnGraficar.setEnabled(false);
    				panel.add(btnLimpiar);
    				panel.add(btnEjecutar,BorderLayout.SOUTH);
    				panel.add(btnGraficar);
    				panel.add(btnSalir,BorderLayout.NORTH);
    				marco3.add(panel3,BorderLayout.CENTER);
    				marco3.add(panel,BorderLayout.SOUTH);
    				marco3.setTitle("Bisección");
    				marco3.setVisible(true);
    				panel1.add(new JLabel("Terminos de la ecuación: "));
    				int grado = Integer.parseInt(TxtGrado.getText());
    				//Dibuja las cajas de texto para los terminos de la ecuación dependiendo el grado que se indique
    				for (int i = 1;i <= grado+1;i++){
    					panel1.add(new JTextField(3),BorderLayout.CENTER);
    				}
    				limite_inferior= new JTextField("0");
    				limite_superior= new JTextField("1");
    				panel1.add(new JLabel("Intervalo a evaluar:"));
    				panel1.add(limite_inferior);
    				panel1.add(limite_superior);
    				//Valida que se introduzcan valores validos en los terminos de la ecuación
    				int cajas = panel1.getComponentCount();
    				for (int i=0; i< cajas-2;i++) {
    					if(panel1.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
    						MetodosNumericos.num((JTextField)panel1.getComponent(i));
    					}
    				}
    				panel3.add(panel1,BorderLayout.NORTH);
    				Ejecutar ejecutar = new Ejecutar();
    				Graficar graficar = new Graficar();
    				Adios adios= new Adios();
    				Limpiar limpiar = new Limpiar();
    				btnEjecutar.addActionListener(ejecutar);
    				btnGraficar.addActionListener(graficar);
    				btnSalir.addActionListener(adios);
    				btnLimpiar.addActionListener(limpiar);
    			}

    		}
    		}
    	
    		public miMarco marco2;
    		public static miMarco marco3;
    	
    	
    }
    
    
    