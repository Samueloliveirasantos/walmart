package br.com.walmart.business;

import java.util.List;

import br.com.walmart.bean.Entrega;
import br.com.walmart.dao.EntregaDAO;

/**
 * @author Samuel Oliveira Santos
 *
 */
public class EntregaBO {

	
	/**
	 * metodo de inclusao de Entrega
	 * @param entrega
	 */
	public void incluirEntrega(Entrega entrega){
		EntregaDAO entregaDAO = new EntregaDAO();
		entregaDAO.incluirEntrega(entrega);
	}
	
	/**
	 * metodo de listar entregas
	 * @return List<Entrega>
	 */
	public List<Entrega> listarEntregas(){
		EntregaDAO entregaDAO = new EntregaDAO();
		return entregaDAO.listarEntregas();
	}
	
	/**
	 * calcula custo da entrega
	 * 
	 * @param entrega
	 * @return float
	 */
	public float calcularEntrega(Entrega entrega){
		return (entrega.getDistancia() / entrega.getAutonomia()) * entrega.getValorLitro(); 
	}
	
	/**
	 * metodo que calcula na base a distancia entre os dois pontos.
	 * @param entrega
	 * @return
	 */
	public float distanciaDaOrigemDestino(Entrega entrega){
		EntregaDAO entregaDAO = new EntregaDAO();
		return entregaDAO.distaciaEntreOsDoisPontos(entrega);
	}
	
	
}
