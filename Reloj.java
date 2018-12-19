import java.applet.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Reloj  extends Applet implements Runnable{
	private Thread fil = null;
	private Font fuente;
	private String horaActual = "";
	
	public void init(){
		fuente=new Font("Verdana", Font.BOLD, 26);
	}
	
	public void start(){
		if(fil == null){
			fil = new Thread(this);
			fil.start();
		}
	}
	
	public void run(){
		Thread filActual = Thread.currentThread();
		while (fil == filActual){
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			horaActual = sdf.format(cal.getTime());
			repaint();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e ){
				System.out.println("Error");
			}
		}
	}
	
	public void paint(Graphics g){
		g.clearRect(1, 1, getSize().width, getSize().height);
		setBackground (Color.yellow);
		g.setFont(fuente);
		g.drawString(horaActual,20,50);
	}
	

}

