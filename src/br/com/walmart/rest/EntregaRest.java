package br.com.walmart.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.walmart.bean.Entrega;
import br.com.walmart.business.EntregaBO;

@Controller

public class EntregaRest {

	@RequestMapping(value="/todasEntregas", method = RequestMethod.GET)
	public @ResponseBody List<Entrega> getEntregas(ModelMap model) {
		EntregaBO entregaBO = new EntregaBO();
		return entregaBO.listarEntregas();
	}
	
	@RequestMapping(value="/incluirEntrega")
	public @ResponseBody String incluirEntrega(@RequestParam("nomeMapa") String nomeMapa, 
			@RequestParam("origem") String origem, 
			@RequestParam("destino") String destino,
			@RequestParam("autonomia") float autonomia,
			@RequestParam("vlLitro") float vlLitro) {
		
		
		EntregaBO entregaBO = new EntregaBO();
		
		Entrega entrega = new Entrega();
		entrega.setNomeMapa(nomeMapa);
		entrega.setOrigem(origem);
		entrega.setDestino(destino);
		entrega.setDistancia(entregaBO.distanciaDaOrigemDestino(entrega));
		entrega.setAutonomia(autonomia);
		entrega.setValorLitro(vlLitro);
		entrega.setCusto(entregaBO.calcularEntrega(entrega));
		entregaBO.incluirEntrega(entrega);
		
		return "Custo: R$ " + entrega.getCusto() +" Reais";
	}
}
