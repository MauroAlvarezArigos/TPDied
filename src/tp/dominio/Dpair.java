package tp.dominio;

public class Dpair {
	long aux1, aux2;
	double first;
	Estacion second;
	
	public Dpair(double fst, Estacion snd) {
		this.first = fst;
		this.second = snd;
	}
	public Dpair(long aux1, long aux2) {
		this.aux1 = aux1;
		this.aux2 = aux2;
	}
	
	public int comparator(Dpair p1, Dpair p2) {
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
	public double getRank() {
		return this.first;
	}
}
