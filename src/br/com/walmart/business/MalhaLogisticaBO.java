package br.com.walmart.business;

import java.util.List;

import br.com.walmart.bean.MalhaLogistica;
import br.com.walmart.dao.MalhaLogisticaDAO;

/**
 * @author Samuel Oliveira Santos
 *
 */
public class MalhaLogisticaBO {

	
	/**
	 * metodo de inclusao de MalhaLogistica
	 * @param logistica
	 */
	public void incluirMalhaLogistica(MalhaLogistica logistica){
		MalhaLogisticaDAO malhaLogisticaDAO = new MalhaLogisticaDAO();
		malhaLogisticaDAO.incluirMalhaLogistica(logistica);
	}
	
	/**
	 * metodo de listar logisticas
	 * @return List<MalhaLogistica>
	 */
	public List<MalhaLogistica> listarMalhaLogisticas(){
		MalhaLogisticaDAO malhaLogisticaDAO = new MalhaLogisticaDAO();
		return malhaLogisticaDAO.listarMalhaLogistica();
	}
	
	
	
}
