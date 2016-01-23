/**
 * 
 */
package br.com.walmart.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Samuel Oliveira Santos
 *
 */
@XmlRootElement
public class Entrega implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idMapa;
	private String nomeMapa;
	private String origem;
	private String destino;
	private float distancia;
	private float autonomia;
	private float valorLitro;
	private float custo;
	
	
	public Entrega() {
		super();
	}


	/**
	 * @return the idMapa
	 */
	public int getIdMapa() {
		return idMapa;
	}


	/**
	 * @param idMapa the idMapa to set
	 */
	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}


	/**
	 * @return the nomeMapa
	 */
	public String getNomeMapa() {
		return nomeMapa;
	}


	/**
	 * @param nomeMapa the nomeMapa to set
	 */
	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}


	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return origem;
	}


	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}


	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}


	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}


	/**
	 * @return the distancia
	 */
	public float getDistancia() {
		return distancia;
	}


	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}


	/**
	 * @return the autonomia
	 */
	public float getAutonomia() {
		return autonomia;
	}


	/**
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(float autonomia) {
		this.autonomia = autonomia;
	}


	/**
	 * @return the valorLitro
	 */
	public float getValorLitro() {
		return valorLitro;
	}


	/**
	 * @param valorLitro the valorLitro to set
	 */
	public void setValorLitro(float valorLitro) {
		this.valorLitro = valorLitro;
	}


	/**
	 * @return the custo
	 */
	public float getCusto() {
		return custo;
	}


	/**
	 * @param custo the custo to set
	 */
	public void setCusto(float custo) {
		this.custo = custo;
	}
	
	
	
	

	
}
