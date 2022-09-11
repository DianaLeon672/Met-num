package MetodosNumericos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import MetodosNumericos.Biseccion.Panel_down.Datos;


public class Graficar implements ActionListener{

	JFreeChart grafica;
	public void actionPerformed(ActionEvent e) {
		
		grafica();
	}	
	public void grafica() {
		double x,y;
		XYSeriesCollection datos = new XYSeriesCollection();
		grafica = ChartFactory.createXYLineChart("Grafica de la ecuación", "X", "Y", datos,PlotOrientation.VERTICAL,true,true,true);
		XYPlot plot = grafica.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(4.0f)); //grosor del pincel
		plot.setRenderer(renderer);
		XYSeries s = new XYSeries("grafica");
		int num_raices = Ejecutar.raices.size();
		for (int i=0; i<num_raices; i++) {
			x=Ejecutar.raices.get(i);
			y=Ejecutar.funcion_de_x(x);
			s.add(x,y);
		}
		/*for(int i=1;i<=5;i++) {
			cuadratica(i);
			s.add(i,cuadratica(i));
		}*/
		datos.addSeries(s);
		ChartPanel panel = new ChartPanel(grafica);
		//agrega el panel de la grafica al panel de la ventana
		Datos.panel_grafica.add(panel);
	}
	
		double cuadratica(int x) {
			double y= Math.pow(x, 2)-1;
			return y;
		}
}


