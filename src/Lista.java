
public class Lista {
	private Nodo head;
	
	public Lista() { head = null; }
	
	public void generaCasuale (int n, int min, int max) {
		for (int i = 0; i < n; i++) {
			int segno;
			int elem;
			if((int)(Math.random()*100)%2 == 0)
				segno = +1;
			else 
				segno = -1;
			elem = ((int)(Math.random() * (max - min + 1)) + min)*segno;
			inserisciInTesta(elem);
		}
	}
	
	public void cancella() {
		head=null;
	}
	
	public void inserisciInTesta(int info) {
		Nodo p = new Nodo(info);
		p.setLink(head);
		head = p;
	}
	
	public void inserisciInCoda(int info) {
		Nodo p = new Nodo (info);
		Nodo c = head; // cursore che scorre la lista
		
		if (c == null) 
			inserisciInTesta(info);
		else {
			while(c.getLink() != null) // Scorro la lista fino al penultimo
				c = c.getLink();
			
			c.setLink(p);
		}	
	}

	public void inserisciInPosizione(int info, int posizione) {
		if ((posizione <=1) || (head==null)) { 
			inserisciInTesta(info);
			return;
		}
		// La lista ha almeno 1 elemento
		int i = 2;
		// Posizioniamoci sul primo elemento e fermiamoci al penultimo
		Nodo c = head;
		while (i<=posizione-1 && c.getLink() != null) {
			c = c.getLink();
			i++;
		}
		Nodo p = new Nodo(info);
		p.setLink(c.getLink());
		c.setLink(p);
	}
	
	public boolean eliminaInTesta() {
		if (head == null)
			return false;
		head = head.getLink();
		return true;
	}
	
	public boolean eliminaInCoda() {
		if (head == null)
			return false;
		if (head.getLink() == null) { // 1 solo elemento
			head = null;
			return true;
		}
		// Due o più elementi
		Nodo c = head, prec= head;
		while (c.getLink() != null) { // potremmo eviare prec facendo c.getLink().getLink()
			prec = c;
			c = c.getLink();
		}			
		prec.setLink(null);
		return true;
	}
	
	public void eliminaInPosizione2(int posizione) {
		if (posizione <=1 || head==null || head.getLink()==null) {
			eliminaInTesta();
			return;
		} 
		if (posizione == 2) {
			head.setLink(head.getLink().getLink());
			return;
		}
		int i = 2;
		Nodo c = head.getLink(), prec = head.getLink(); // partiamo dal secondo
		while (c.getLink()!= null && i<=posizione-1) {
			prec = c;
			c= c.getLink();
			i++;
		}
		prec.setLink(c.getLink());
	}
	
	public void eliminaInPosizione(int posizione) {
		if (posizione <=1 || head==null || head.getLink()==null) {
			eliminaInTesta();
			return;
		} 
		int i = 1;
		Nodo c = head, prec = head;
		while (c.getLink()!= null && i<=posizione-1) {
			prec = c;
			c= c.getLink();
			i++;
		}
		prec.setLink(c.getLink());
	}

	
	public int ricercaElemento(int info) {
		if (head == null)
			return -1;
		Nodo p = head;
		int posizione = 1;
		while (p != null) {
			if (p.getInfo() == info)
				return posizione;
			p = p.getLink();
			posizione++;
		}
		return -1;
	}
	
	public String toString() {
		Nodo p = head;
		String s = "";
		while (p != null) {
			s += p.getInfo() + "->";
			p = p.getLink();
		}
		s += "*";
		return s;
	}
		
}
