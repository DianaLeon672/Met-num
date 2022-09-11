package MetodosNumericos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import MetodosNumericos.Biseccion.Panel_down.Datos;

class Limpiar implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Biseccion.marco3.dispose();
		//MetodosNumericos.marco2 = new miMarco();
		//Biseccion.ventana2() = new Biseccion();
		//MetodosNumericos.Biseccion.ventana2();
		
		//MetodosNumericos.marco2.setVisible(true);
		Biseccion.TxtGrado.setText("");
		int cajas = Datos.panel1.getComponentCount();
		for (int i=0; i< cajas;i++) {
			if(Datos.panel1.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
				((JTextField)Datos.panel1.getComponent(i)).setText("");
			}
		}
		for(int i=0;i<Datos.panel_raices.getComponentCount();i++) {
			if(Datos.panel_raices.getComponent(i).getClass().getName().equals("javax.swing.JLabel")) {
				((JLabel)Datos.panel_raices.getComponent(i)).setText("");
			}
		}
		
		//Datos.panel_raices
	}
}
