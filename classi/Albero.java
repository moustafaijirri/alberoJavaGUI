/*
 *Questa classe contiene la struttura dell'albero.
 */

package classi;

import java.util.Stack;

public class Albero{
    
	private DataNodo root;
    
    public Albero() {
		
        root = null;
		
    }
    
    public DataNodo getRoot(){
		
        return root;
		
    }
    
    public DataNodo trova(int cercanumero){
		
        DataNodo corrente = root;
        
        while (corrente.numero != cercanumero){
		
            if(cercanumero < corrente.numero){
				
                corrente = (DataNodo) corrente.figlioSinistro;
			
            }
			
            else{
				
                corrente = (DataNodo) corrente.figlioDestro;
				
            }
            
            if (corrente == null){
				
                return null;
				
            }
        }
        
        return corrente;
		
    }
	
    
    public void inserisci(int numero){
		
        DataNodo nuovoNodo = new DataNodo();
        nuovoNodo.numero = numero;
		
        if (root == null){
			
            root = nuovoNodo;
			
        }
		
        else{
			
            DataNodo corrente = root;
            DataNodo parent;
			
            while (true){
				
                parent = corrente;
                
                if (numero < corrente.numero){
					
                    corrente = (DataNodo) corrente.figlioSinistro;
                    
                    if (corrente == null){
						
                        parent.figlioSinistro = nuovoNodo;
                        return;
						
                    }
                }
				
                else{
					
                    corrente = (DataNodo) corrente.figlioDestro;
                    
                    if (corrente == null){
						
                        parent.figlioDestro = nuovoNodo;
                        return;
						
                    }
                }
            }
        }
    }
    
	/*
	
	Per cancellare

	public boolean cancella (int numero){
	
		DataNodo corrente = root;
		DataNodo parent = root;
		boolean isfiglioSinistro = true;

		while (corrente.numero != numero){ //cerca il Nodo
	
			parent = corrente;
			
			if (numero < corrente.numero) {  //andare a sinistra?
	
				isfiglioSinistro = true;
				corrente = (DataNodo) corrente.figlioSinistro;
	
			}
	
			else{                    //o andare a destra?
			
				isfiglioSinistro = false;
				corrente = (DataNodo) corrente.figlioDestro;
				
			}

			if (corrente == null){
			
				return false;
			}
			
		}
		
		//Trovato nodo da cancellare

		//se non ci sono figli, semplicemente cancellare tutto
		
		if (corrente.figlioSinistro == null && corrente.figlioDestro == null){
		
			if (corrente == root)  {	 //se è il root
			
				root = null;        //l'albero è vuoto
				
			}
			
			else if (isfiglioSinistro){
		
				parent.figlioSinistro = null;
			}
			
			else{
			
			parent.figlioDestro = null;
			
			}
		}
		
		//se non ci sono figli destri, sostiuire con figlio sinistro
		
		else if (corrente.figlioDestro == null){
		
			if (corrente == root){
			
				root = (DataNodo) corrente.figlioSinistro;
				
			}
			
			else if (isfiglioSinistro){

			}
		}
	
	}*/
    
    public void visualizzaAlbero(){
		
        Stack globalStack = new Stack();
        globalStack.push(root);
		
        int nVuoti = 32;   		//Il massimo di nodi
		
        boolean isRowEmpty = false;
        System.out.println("....................................................................");
		
		
        while(isRowEmpty == false){
			
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for (int j = 0; j < nVuoti; j++){
				
                System.out.print(' ');
				
            }
            
            while (globalStack.isEmpty() == false){
				
                DataNodo temp = (DataNodo) globalStack.pop();
                if (temp != null){
					
                    System.out.print(temp.numero);
                    localStack.push((DataNodo) temp.figlioSinistro);
                    localStack.push((DataNodo) temp.figlioDestro);
                    
                    if (temp.figlioSinistro != null || temp.figlioDestro != null){
						
                        isRowEmpty = false;
						
                    }
                }
				
                else{
					
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
					
                }
                
				
                for (int j = 0; j < nVuoti * 2 - 2; j++){
					
                    System.out.print(' ');
					
                }
            }		//continua finchè il globalStack non si svuota
            
            System.out.println();
            
            nVuoti /= 2;
            
			
            while (localStack.isEmpty() == false){
				
                globalStack.push((DataNodo) localStack.pop());
				
            }
        } 	//continua finchè isRowEmpty è falso
        
        System.out.println("....................................................................");
		
    }   //finisce visualizzaAlbero()
}
