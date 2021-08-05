package tp.dominio;

public class Pair {
	int first;
	Estacion second;
	
	public Pair(int fst, Estacion snd) {
		this.first = fst;
		this.second = snd;
	}
	
	public int comparator(Pair p1, Pair p2) {
		if(p1.first > p2.first) return -1;
		else if(p1.first < p2.first) return 1;
		if(p1.second.getId() < p2.second.getId()) return -1;
		else return 1;
	}
}
