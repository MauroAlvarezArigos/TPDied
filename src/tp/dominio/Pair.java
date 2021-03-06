package tp.dominio;

public class Pair {
	long aux1, aux2;
	int first;
	Estacion second;
	
	public Pair(int fst, Estacion snd) {
		this.first = fst;
		this.second = snd;
	}
	public Pair(long aux1, long aux2) {
		this.aux1 = aux1;
		this.aux2 = aux2;
	}
	
	public int comparator(Pair p1, Pair p2) {
		if(p1.first > p2.first) return -1;
		else if(p1.first < p2.first) return 1;
		if(p1.second.getId() < p2.second.getId()) return -1;
		else return 1;
	}
	public long getVal() {
		return this.aux1;
	}
	public long getCost() {
		return this.aux2;
	}
	public Estacion getEstacion() {
		return this.second;
	}
	public int getRank() {
		return this.first;
	}
}
