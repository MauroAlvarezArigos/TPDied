package tp.dao;

import tp.dominio.Boleto;

public interface BoletoDao {
	
	public Boleto saveOrUpdate(Boleto b);
	public void borrar(Boleto b);
	public Boleto buscar(Integer numeroBoleto);

}
