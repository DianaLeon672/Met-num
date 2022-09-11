package MetodosNumericos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MetodosNumericos.Biseccion.Panel_down.Datos;

class Ejecutar implements ActionListener{
	 	public static double xi=0;
	 	public static double xs=0;
	 	public static double xr=0;
	 	public static double raiz=0;
	 	public double xrnuevo=0;
	 	public double xrviejo=0;
	 	public double result1=0;
	 	public double p_error=100; 
	 	public int raices_encontradas=0;
	 	static ArrayList<Integer>ecuacion;
	 	public static ArrayList<Double>raices;
		public void actionPerformed(ActionEvent e) {
			Datos.btnGraficar.setEnabled(true); //habilita boton graficar si hay ejecución de calculo de raices
			//validar que no esten vacios los terminos de la ecuacion y de los limites a evaluar
			for (int i=0; i<Datos.panel1.getComponentCount();i++) {
				if(Datos.panel1.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
					if (((JTextField) Datos.panel1.getComponent(i)).getText().isEmpty()){
						return;
					}
				}
			}
			
			int cajas = Datos.panel1.getComponentCount();
			JTextField caja;
			//Guarda en el arreglo ecuacion los terminos de la ecuación
			ecuacion  = new ArrayList<Integer>();
			//resta 2 para quitar los valores de los limites que se encuentran en el mismo panel
			for (int i=0; i< cajas-2;i++) {
				if(Datos.panel1.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
					caja=(JTextField)Datos.panel1.getComponent(i);
					if(caja.getText().length()!=0){
						ecuacion.add(Integer.parseInt(caja.getText()));
					}
				}
			}
		    raices  = new ArrayList<Double>();
			//xi=0;
			//xs=1;
		    //Obtiene los limites a evaluar que indica el usuario
			xi = Double.parseDouble(Datos.limite_inferior.getText());
			xs = Double.parseDouble(Datos.limite_superior.getText());
			int grado=0;
			
			for (int i=1;i<=100;i++) { //numero de posibles iteraciones
				xr = medio(xi,xs);
				/*System.out.println("Iteracion: "+i);
				System.out.println("xi= "+xi+ " xs= "+xs+" xr= " +xr);
				System.out.print(" f(xi)= "+funcion_de_x(xi));
				System.out.println("f(xr)= "+funcion_de_x(xr));*/
				result1=funcion_de_x(xi)*funcion_de_x(xr);
				if (i>1) {//se calcula el % de error a partir de la segunda iteración
					p_error=porcentaje_error(xr,xrviejo);
				}
				//System.out.println("porcentaje de error "+p_error);
				grado = getGradoEcuacion();
				
				if(p_error <=0.05){ //Cuando el % error es <0.05 termina las iteraciones
					
					break;
				} 
				procedimiento(result1);
				
			}
		
			
		}
		//Guarda en un arreglo los términos de la ecuación
		public static ArrayList<Integer> getEcuacion() {
			//resta 2 porque quita el valor de los limites inferior y superior que se encuentran en el mismo panel
			int cajas = Datos.panel1.getComponentCount();
			JTextField caja;
			ArrayList<Integer>ecuacion  = new ArrayList<Integer>();
			for (int i=0; i< cajas-2;i++) {
				if(Datos.panel1.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
					caja=(JTextField)Datos.panel1.getComponent(i);
					//agrega al arreglo ecuacion el valor de los términos
					ecuacion.add(Integer.parseInt(caja.getText()));
					
					
				}
			}
			return ecuacion;
		}
		//Obtiene el grado de la ecuación introducida
		static int getGradoEcuacion(){
			ArrayList<Integer>ecuacion2  = new ArrayList<Integer>();
			ecuacion2=getEcuacion();
			int grado=ecuacion2.size()-1;
			return grado;
		}
		//Obtiene el punto medio de acuerdo al metodo de bisección
		double medio(double xi, double xs){
			xr=(xi+xs)/2;
			return xr;
		}
		//Evalua el valor de x en la ecuación
		static double funcion_de_x(double x) {
			int grado = getGradoEcuacion();
			double res=0.0;
			ecuacion=getEcuacion();
			for (int i=0; i<ecuacion.size(); i++) {
				res = res+ecuacion.get(i)*(Math.pow(x, grado));
				//System.out.println("ecuacion.get["+i+"]"+ecuacion.get(i)+" grado "+grado );
				grado=grado-1;
			}
			return res;
		}
		void procedimiento(double resultado) {
			if (resultado<0) {
				xs = xr;
				xrviejo=xr;
				raices.add(xr); //agrega al arreglo de raices la raiz que va encontrando
				Datos.panel_raices.add(new JLabel(String.valueOf(xr)));
			}else if(resultado>0) {
				xi = xr;
				xrviejo=xr;
				raices.add(xr); //agrega al arreglo de raices la raiz que va encontrando
				Datos.panel_raices.add(new JLabel(String.valueOf(xr)));
				}
				//System.out.println("resultado= "+resultado +" >0 " +" xi=xr = "+xr +"xi= "+xi +" xs= "+xs);
				
			}
			
		
		//calcula el porcentaje de error segun el metodo de Bisección
		double porcentaje_error(double xr_nuevo,double xr_viejo) {
			double porcentaje;
			porcentaje=((Math.abs((xr_nuevo-xr_viejo)/xr_nuevo)))*100;
			return porcentaje;
		}
		
		
	}

