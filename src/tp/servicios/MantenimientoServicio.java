package tp.servicios;

import java.util.List;

import tp.dao.MantenimientoDao;
import tp.dao.MantenimientoDaoSQL;
import tp.dominio.Mantenimiento;

public class MantenimientoServicio {
	
private MantenimientoDao mantenimientodao;
	
	public MantenimientoServicio() {
		mantenimientodao = new MantenimientoDaoSQL();
	}
	
	public List<Mantenimiento> crearMantenimiento(Integer numeroEstacion, List<Mantenimiento> m) {
		return this.mantenimientodao.saveOrUpdate(numeroEstacion, m);
	}

}
