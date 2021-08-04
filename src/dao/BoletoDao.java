package dao;

import java.util.List;

import java.util.Map;

import tp.dominio.Boleto;

public interface BoletoDao {
	
	public Boleto saveOrUpdate(Boleto b);
	public void borrar(Boleto b);

}
