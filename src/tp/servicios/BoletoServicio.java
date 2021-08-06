package tp.servicios;



import tp.dao.BoletoDao;
import tp.dao.BoletoDaoSQL;
import tp.dominio.Boleto;


public class BoletoServicio {
	
	private BoletoDao boletodao;
	
	public BoletoServicio() {
		boletodao = new BoletoDaoSQL();
	}
	
	public Boleto crearEstacion(Boleto b) {
		return this.boletodao.saveOrUpdate(b);
	}
	
	public Boleto buscarBoleto(Boleto b) {
		return boletodao.buscar(b.getNumeroBoleto());
	}
	
	public void borrarBoleto(Boleto b) {
		boletodao.borrar(b);
	}
	

}
