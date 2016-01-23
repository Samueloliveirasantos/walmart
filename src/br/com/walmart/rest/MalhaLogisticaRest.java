package br.com.walmart.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.walmart.bean.MalhaLogistica;
import br.com.walmart.business.MalhaLogisticaBO;

@Controller
public class MalhaLogisticaRest {

	@RequestMapping(value="/malhaLogistica", method = RequestMethod.GET)
	public @ResponseBody List<MalhaLogistica> getMalhaLogisticas(ModelMap model) {
		MalhaLogisticaBO malhaLogisticaBO = new MalhaLogisticaBO();
		return malhaLogisticaBO.listarMalhaLogisticas();
	}
	
	@RequestMapping(value="/incluirMalha")
	public @ResponseBody String incluirMalhaLogistica(@RequestParam("pontoInicial") String pontoInicial, 
			@RequestParam("pontoFinal") String pontoFinal, 
			@RequestParam("distancia") int distancia) {
		
		MalhaLogisticaBO malhaLogisticaBO = new MalhaLogisticaBO();
		
		MalhaLogistica logistica = new MalhaLogistica();
		logistica.setDistancia(distancia);
		logistica.setPontoInicial(pontoInicial);
		logistica.setPontoFinal(pontoFinal);

		try {
			malhaLogisticaBO.incluirMalhaLogistica(logistica);
			return "Malha Logistica Incluida com Sucesso!!!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao incluir Malha Logistica!";
		}
		
	}
}
