/*
 *Questa classe estende la classe Nodo per creare un nodo con i dati nell'albero.
 */
 
package classi;
 
public class DataNodo extends Nodo {
	
    public int numero;
    
    public void displayNodo(){
		
        System.out.println("{");
        System.out.println(numero);
        System.out.println("} ");
		
    }
}
