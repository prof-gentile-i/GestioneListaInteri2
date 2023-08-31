import java.io.*;
import java.util.Scanner;

public class GestioneLista {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
		Lista lista = new Lista();
		int max = 99, min = 0; // Massimo e minimo numero generabile (in valore assoluto)
		boolean fine = false;
		do {
			System.out.print(menu());
			int scelta = Integer.parseInt(stdin.readLine());

			switch(scelta) {
            	case 1:
            		System.out.print("Inserisci il numero di elementi da generare e premi Invio: ");
            		int n = Integer.parseInt(stdin.readLine());
            		lista.generaCasuale(n, min, max);
            		break;
            	case 2:
            		lista.cancella();
                	break;
            	case 3:
            		System.out.print("Inserisci l'elemento (numero intero) e premi Invio: ");
            		int elem = Integer.parseInt(stdin.readLine());
					lista.inserisciInTesta(elem);
					break;
            	case 4:
            		System.out.print("Inserisci l'elemento (numero intero) e premi Invio: ");
            		elem = Integer.parseInt(stdin.readLine());
					lista.inserisciInCoda(elem);
					break;
            	case 5:
            		System.out.print("Inserisci l'elemento (numero intero) e la posizione separati da spazio e premi Invio: ");
            		String[] elemPos = stdin.readLine().split(" ");            		
					lista.inserisciInPosizione(Integer.parseInt(elemPos[0]), Integer.parseInt(elemPos[1]));
					break;
            	case 6:
            		if(lista.eliminaInTesta())
            			System.out.println("Elemento cancellato con successo");
            		else
            			System.out.println("La lista è vuota, non c'è nessun elemento da cancellare");
            		break;
            	case 7:	
            		if(lista.eliminaInCoda())
            			System.out.println("Elemento cancellato con successo");
            		else
            			System.out.println("La lista è vuota, non c'è nessun elemento da cancellare");
            		break;
            	case 8:
            		System.out.print("Inserisci la posizione (numero intero) e premi Invio: ");
            		int posizione = Integer.parseInt(stdin.readLine());
            		lista.eliminaInPosizione(posizione);
            		break;            	
            	case 9:
            		System.out.print("Inserisci l'elemento (numero intero) e premi Invio: ");
            		elem = Integer.parseInt(stdin.readLine());
            		posizione = lista.ricercaElemento(elem);
            		if (posizione >0 )
            			System.out.println("L'elemento cercato e' stato trovato in posizione: " +  posizione);
            		else
            			System.out.println("L'elemento cercato non e' presente nella lista");
            		break;
            	case 10:
            		System.out.println(lista.toString());
            		break;
            	case 11:
            		System.out.println("Inserisci il nome del file (estensione compresa)");
            		System.out.println(", se non specificato cerca lista.txt");
            		String nomeFile = stdin.readLine();
            		if (nomeFile.trim().length() == 0 ) 
            			nomeFile = "lista.txt";
            		BufferedReader fileSorgente =  new BufferedReader(new FileReader(nomeFile));
            		Scanner sc = new Scanner(fileSorgente);
            		lista.cancella();
            		while(sc.hasNextInt()) {
            			lista.inserisciInTesta(sc.nextInt());
            		}
            		break;
            	case 12:
            		fine = true;
            		break;
            	default:
            		System.out.print("Errore comando non riconosciuto, ripeti");
            		break;
			}
//			clrscr();
		} while (fine == false);
		System.out.println("Programma terminato");
	}
	
	public static String menu() {// Costruzione del menu
		String newline  = System.lineSeparator();
		return newline 
				+ "********************************************************************" + newline
				+ "GESTIONE DI UNA LISTA" + newline
				+ "1 - Generazione di una lista di numeri casuali" + newline
				+ "2 - Cancellazione lista" + newline
				+ "3 - Inserimento di un elemento in testa" + newline
				+ "4 - Inserimento di un elemento in coda" + newline
				+ "5 - Inserimento di un elemento in una specifica posizione" + newline
				+ "6 - Cancellazione di un elmento in testa" + newline
				+ "7 - Cancellazione di un elmento in coda" + newline
				+ "8 - Cancellazione di un elmento in una specifica posizione" + newline
				+ "9 - Ricerca di un elemento" + newline
				+ "10 - Stampa della lista" + newline
				+ "11 - Lettura della lista da file" + newline
				+ "12 - Fine" + newline
				+ "Scegli l'operazione: ";
	}
}

