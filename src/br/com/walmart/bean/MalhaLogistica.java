/**
 * 
 */
package br.com.walmart.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Samuel Oliveira Santos
 *
 */
@XmlRootElement
public class MalhaLogistica implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idMalhaLogistica;
	private String pontoInicial;
	private String pontoFinal;
	private int distancia;
	
	
	public MalhaLogistica() {
		super();
	}


	/**
	 * @return the idMalhaLogistica
	 */
	public int getIdMalhaLogistica() {
		return idMalhaLogistica;
	}


	/**
	 * @param idMalhaLogistica the idMalhaLogistica to set
	 */
	public void setIdMalhaLogistica(int idMalhaLogistica) {
		this.idMalhaLogistica = idMalhaLogistica;
	}


	/**
	 * @return the pontoInicial
	 */
	public String getPontoInicial() {
		return pontoInicial;
	}


	/**
	 * @param pontoInicial the pontoInicial to set
	 */
	public void setPontoInicial(String pontoInicial) {
		this.pontoInicial = pontoInicial;
	}


	/**
	 * @return the pontoFinal
	 */
	public String getPontoFinal() {
		return pontoFinal;
	}


	/**
	 * @param pontoFinal the pontoFinal to set
	 */
	public void setPontoFinal(String pontoFinal) {
		this.pontoFinal = pontoFinal;
	}


	/**
	 * @return the distancia
	 */
	public int getDistancia() {
		return distancia;
	}


	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	

	
}
