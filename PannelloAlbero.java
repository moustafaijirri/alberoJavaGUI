/*
 * Questa classe disegna l'albero.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;

import classi.Albero;
import classi.DataNodo;

public class PannelloAlbero extends JPanel {

    Albero alberoBin;
    
    int DIAMETRO_CERCHIO = 30;
    
    public static void main(String[] args) {
            Window tpo = new Window();

            tpo.addWindowListener(new WindowAdapter() {   // Per uscire dal programma quando viene cliccata la X
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }
    
    public void setAlbero(Albero newalberoBin)
	
    {
        alberoBin = newalberoBin;
    }
    
	//DISEGNA
	
	public void paintComponent (Graphics g) {
	
		g.setFont(Fonts.plainfont);

		if (alberoBin != null && alberoBin.getRoot() != null) {
			
			print("larghezza: " + getWidth());
			
			int x = getWidth() / 2;
			int y =  getHeight() - (getHeight() - DIAMETRO_CERCHIO);

			visualizzaalberoBin(g, alberoBin.getRoot(), x, y, 1);
			
		}

	}
  
	public void visualizzaalberoBin(Graphics g, DataNodo Nodo, int x, int y, int livello) {


		print("Nodo numero: " + Nodo.numero);
		print("livello: " + livello);
		print("x: " + x + " y: " + y);

		disegnaCerchioCentrato(g, x, y, DIAMETRO_CERCHIO);
		disegnaNumInCerchio(g, "" + Nodo.numero, x, y, DIAMETRO_CERCHIO);

		if (Nodo.figlioSinistro != null){   
			
			int newCenterX;

			if (x > getWidth() / 2) {
				
				double divisor = Math.pow(2.0, ((double)livello));
				int dividend = x - (getWidth() / 2);
				int xOffset = (int) (dividend / divisor);

				newCenterX = x - xOffset; 
				
			}
			
			else {
				
				newCenterX = x - ((int) (x /Math.pow(2.0, ((double)livello))));
				
			}

			int newCenterY = y + 60;
			disegnafiglioSinistroLinea(g, x, y, newCenterX, newCenterY);
			visualizzaalberoBin(g, (DataNodo) Nodo.figlioSinistro, newCenterX, newCenterY, (livello + 1));
		
		}

		if (Nodo.figlioDestro != null){       
			
			int newCenterX;
			
			if (x > getWidth() / 2){
				
				double divisor = Math.pow(2.0, ((double)livello));
				int dividend = x - (getWidth() / 2);
				int xOffset = (int) (dividend / divisor);

				newCenterX = x + xOffset; 
				
			}
			
			else{
				
			newCenterX = x + ((int) (x /Math.pow(2.0, ((double)livello))));
				
			}

			int newCenterY = y + 60;
			
			disegnafiglioDestroLinea(g, x, y, newCenterX, newCenterY);
			visualizzaalberoBin(g, (DataNodo) Nodo.figlioDestro, newCenterX, newCenterY, (livello + 1));
		
		}
	}

	public void disegnaCerchioCentrato(Graphics g, int x, int y, int d) {
		
		x = x-(d/2);
		y = y-(d/2);
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, d, d);
		
	}

	public void disegnafiglioSinistroLinea(Graphics g, int circleCenterX, int circleCenterY, int circle2CenterX, int circle2CenterY) {
		
		g.setColor(Color.BLUE);
		g.drawLine(circleCenterX, circleCenterY, circle2CenterX, circle2CenterY);
		
	}

	public void disegnafiglioDestroLinea(Graphics g, int circleCenterX, int circleCenterY, int circle2CenterX, int circle2CenterY) {
		
		g.setColor(Color.BLUE);
		g.drawLine(circleCenterX, circleCenterY, circle2CenterX, circle2CenterY);
		
	}

	public void disegnaNumInCerchio(Graphics g, String string, int x, int y, int d) {
		
		x = x - (d / 4);
		y = y + (d / 4);
		g.setColor(Color.BLACK);
		g.drawString(string, x, y);
		
	}

	private void print(String message) {
		
		System.out.println(message);
		
	}
}
