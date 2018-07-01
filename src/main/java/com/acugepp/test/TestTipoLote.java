package com.acugepp.test;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("testTipolote")
public class TestTipoLote {
	
	private String url = "http://localhost:8080/acugepp/tipolote/";
	
	@RequestMapping(value="/insertar",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody String insertar() {
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		
		String uri = url+"insertar";
		JSONObject json = new JSONObject();
		JSONObject runParameters = new JSONObject();
		try {
			//runParameters.put("id", 0);
			runParameters.put("nombre", "lote de prueba");
			runParameters.put("estatus", 0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		System.out.println("Json enviado: "+runParameters.toString());
		System.out.println("Url: "+uri);
		HttpEntity <String> httpEntity = new HttpEntity <String> (runParameters.toString(), httpHeaders);
		
		String response = restTemplate.postForObject(uri, httpEntity, String.class);
		System.out.println("Insertar: "+response);
		return response;
	}
	
	@RequestMapping(value="/modificar/{id}",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody String modificar(@PathVariable int id) {
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		
		String uri = url+"modificar/";
		JSONObject json = new JSONObject();
		JSONObject runParameters = new JSONObject();
		try {
			runParameters.put("id", id);
			runParameters.put("nombre", "primer lote de prueba");
			runParameters.put("estatus", 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		System.out.println("Json enviado: "+runParameters.toString());
		System.out.println("Url: "+uri);
		HttpEntity <String> httpEntity = new HttpEntity <String> (runParameters.toString(), httpHeaders);
		
		String response = restTemplate.postForObject(uri, httpEntity, String.class);
		System.out.println("modificar: "+response);
		return response;
	}
	
	@RequestMapping(value="/buscar",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody String pedirServicioGet() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = url + "buscar";
		String response = restTemplate.getForObject(uri, String.class);
		System.out.println("Buscar todos: "+response);
		return response;
	}
	
	@RequestMapping(value="/buscar/{id}",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody String buscar(@PathVariable Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = url + "buscar/"+id;
		String response = restTemplate.getForObject(uri, String.class);
		System.out.println("Buscar uno: "+response);
		
		return response;
	}
	
	@RequestMapping(value="/eliminar/{id}",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map eliminar(@PathVariable Integer id) {
		String uri = url + "eliminar/"+id;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri);
		Map mapa = new HashMap<String,Object>();
		mapa.put("exito", "1");
		return mapa;
	}

}
