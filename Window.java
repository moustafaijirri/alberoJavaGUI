/*
 * Questa classe crea una finestra per visualizzare l'albero (gui)
 */

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classi.Albero;

public class Window extends JFrame implements ActionListener {

    private static int winxpos=0,winypos=0;

    private JButton insBottone,esciBottone;
    private JTextField txtfield;
    private JPanel northPanel;
    private PannelloAlbero centerPanel;
    private static final int WINWIDTH = 1500;
    private static final int WINHEIGHT = 800;
	
    private Albero alberoBins = new Albero();


    //MAIN

    public static void main(String[] args) {
            Window tpo = new Window();

            tpo.addWindowListener(new WindowAdapter() {   // Per uscire dal programma quando viene cliccata la X
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }



    //COSTRUTTORI

    public Window ()
	{
		northPanel = new JPanel();
		northPanel.add(new Label("Inserisci un numero: "));

		txtfield = new JTextField("",20);
		northPanel.add(txtfield);

		insBottone = new JButton("Inserisci");
		northPanel.add(insBottone);
		insBottone.addActionListener(this);

		esciBottone = new JButton("Esci");
		northPanel.add(esciBottone);
		esciBottone.addActionListener(this);

		getContentPane().add("North",northPanel);

		centerPanel = new PannelloAlbero();
		getContentPane().add("Center",centerPanel);


		centerPanel.setAlbero(alberoBins);

		alberoBins.inserisci(50);   //Numerooo
		alberoBins.visualizzaAlbero();

		setSize(WINWIDTH,WINHEIGHT);
		setLocation(winxpos,winypos);
		setVisible(true);

    }


    //BOTTONI

	public void actionPerformed(ActionEvent e) {

		if (e.getSource()== esciBottone) {
			
			dispose(); 
			
			System.exit(0);

		}

		if (e.getSource()== insBottone) {

			alberoBins.inserisci(Integer.parseInt(txtfield.getText()));
			
			repaint();
		}


	}
}
