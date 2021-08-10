package tp.servicios;



import tp.dao.BoletoDao;
import tp.dao.BoletoDaoSQL;
import tp.dominio.Boleto;


public class BoletoServicio {
	
	private BoletoDao boletodao;
	
	public BoletoServicio() {
		boletodao = new BoletoDaoSQL();
	}
	
	public Boleto crearBoleto(Boleto b) {
		return this.boletodao.insert(b);
	}
	
}
