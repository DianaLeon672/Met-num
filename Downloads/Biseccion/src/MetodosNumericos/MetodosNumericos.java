package MetodosNumericos;

import java.awt.BorderLayout;
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
	public static JLabel lblReloj;
	
	public static void main(String[] args){
		lblReloj = new JLabel();
		new Reloj();
		marco1 = new miMarco();
		//System.out.println("lblReloj.getText() "+lblReloj.getText());
		marco1.setTitle("Métodos numéricos                                "+ getFecha());
		Panel panel = new Panel();
		marco1.add(panel);
		Ventana ventana = new Ventana();
		marco1.addWindowListener(ventana);
		marco1.setVisible(true);
		
		
	}
	public static void num(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(((caracter<'0')|| (caracter >'9'))&& (caracter != '\b')){
				e.consume(); 
				}
			}
		});
	}	
	
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
	static class Ventana implements WindowListener{
    	public void windowActivated(WindowEvent e){}
    	public void windowClose(WindowEvent e){}
    	public void windowClosing(WindowEvent e){}
    	public void windowDeactivated(WindowEvent e){
    		//System.out.println("Deactivated");
    		marco1.dispose();
    	}
    	public void windowDeiconified(WindowEvent e){}
    	public void windowIconified(WindowEvent e){}
    	public void windowOpened(WindowEvent e){}
    	public void windowClosed(WindowEvent e) {}
    }



}
	class miMarco extends JFrame{
		public miMarco() {
			Toolkit pantalla = Toolkit.getDefaultToolkit();
			Dimension tamanoPantalla = pantalla.getScreenSize();
			int alturaPantalla = tamanoPantalla.height;
			int anchoPantalla = tamanoPantalla.width;
			setSize(anchoPantalla/2,alturaPantalla/2);
			setLocation(anchoPantalla/4,alturaPantalla/4);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

		
	}
	class Panel extends JPanel{
		public Panel(){
			setLayout(new BorderLayout());
			Biseccion biseccion = new Biseccion();
			setLayout(new BorderLayout());
			JButton btnBiseccion = new JButton("Biseccion");
			add(MetodosNumericos.lblReloj,BorderLayout.NORTH);
			JPanel panel1 = new JPanel(); 
			add(panel1);
			panel1.add(btnBiseccion,BorderLayout.CENTER);
			btnBiseccion.addActionListener(biseccion);
			Adios adios = new Adios();
			JButton btnAdios = new JButton("Adios");
			JPanel panel2= new JPanel();
			add(panel2,BorderLayout.SOUTH);
			panel2.add(btnAdios,BorderLayout.SOUTH);
			btnAdios.addActionListener(adios);
		}
	}	
	
    class Adios implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
    class Biseccion implements ActionListener{
    	public static JTextField TxtGrado;
    	public void actionPerformed(ActionEvent e) {
    		//System.out.println("oprimio biseccion");
    		marco2 = new miMarco();
    		ventana2();
    		
    	}
    	public void ventana2(){
    		JPanel panel2 = new JPanel();
    		//panel2.setLayout(new BorderLayout());
    		panel2.add(MetodosNumericos.lblReloj,BorderLayout.NORTH);
    		marco2.add(panel2,BorderLayout.NORTH);
    		TxtGrado = new JTextField(3);
    		MetodosNumericos.num(TxtGrado);
    		JPanel panel3 = new JPanel();
    		panel3.add(new JLabel("Grado: "));
    		panel3.add(TxtGrado);
    		Panel_down pd = new Panel_down();
    		marco2.add(panel3,BorderLayout.CENTER);
    		marco2.add(pd,BorderLayout.SOUTH);
    		marco2.setTitle("Bisección                "+ MetodosNumericos.getFecha());
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
    		class Regresar implements ActionListener {
    	    	public void actionPerformed(ActionEvent e) {
    	    		//System.out.println("Oprimió regresar");
    	    		marco2.setVisible(false);
    	    		MetodosNumericos.marco1.setVisible(true);
    	    	}
    	    }
    		class Datos implements ActionListener {
    			public JPanel panel;
    			public JPanel panel1;
    			public JPanel panel2;
    			public void actionPerformed(ActionEvent e) {
    				//System.out.println("Oprimió datos");
    				marco3 = new miMarco();
    	    		ventana3();
    			}
    			public void ventana3() {
    				panel2 = new JPanel();
    				panel2.add(MetodosNumericos.lblReloj,BorderLayout.NORTH);
    				JLabel fecha = new JLabel(MetodosNumericos.getFecha());
    				panel2.add(fecha);
    				marco3.add(panel2,BorderLayout.NORTH);
    				panel1 = new JPanel();
    				panel = new JPanel();
    				JButton btnEjecutar = new JButton("Ejecutar");
    				panel.add(btnEjecutar,BorderLayout.SOUTH);
    				marco3.add(panel,BorderLayout.SOUTH);
    				marco3.setTitle("Bisección");
    				marco3.setVisible(true);
    				int grado = Integer.parseInt(TxtGrado.getText());
    				System.out.println("grado "+ grado);
    				for (int i = 1;i <= grado+1;i++){
    					panel1.add(new JTextField(3),BorderLayout.CENTER);
    				}
    				marco3.add(panel1,BorderLayout.CENTER);
    				Ejecutar ejecutar = new Ejecutar();
    				btnEjecutar.addActionListener(ejecutar);
    			}
    			class Ejecutar implements ActionListener{
    				public void actionPerformed(ActionEvent e) {
    					int cajas = panel1.getComponentCount();
    					JTextField caja;
    					ArrayList<Integer>ecuacion  = new ArrayList<Integer>();
    					System.out.println("numero de cajas "+cajas);
    					for (int i=0; i< cajas;i++) {
    						if(panel1.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
    							caja=(JTextField)panel1.getComponent(i);
    							System.out.println(caja.getText());
    							ecuacion.add(Integer.parseInt(caja.getText()));
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	private miMarco marco2;
    	private miMarco marco3;
   
    	
    }
    
    
    