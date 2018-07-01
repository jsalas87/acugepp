package com.acugepp.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acugepp.dao.TipoLoteDAO;
import com.acugepp.dominio.TipoLote;

@Controller
@RequestMapping("tipolote")
public class ServicioTipoLote {
	@Autowired
	TipoLoteDAO daoTipoLote;
	
	@RequestMapping(value="/insertar", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map insertar(@RequestBody TipoLote tipoLote) {
		Map mapa = new HashMap<String,Object>();
		if (tipoLote!=null) {
			tipoLote.setId(null);
			daoTipoLote.save(tipoLote);
			if (tipoLote.getId()!=null && tipoLote.getId()>0) {
				mapa.put("exito", 1);
				mapa.put("idTipoLote", tipoLote.getId());
			}
		}
		return mapa;
		
	}
	
	@RequestMapping(value="/modificar", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map modificar(@RequestBody TipoLote tipoLote) {
		Map mapa = new HashMap<String,Object>();
		if (tipoLote!=null && tipoLote.getId()>0) {
			daoTipoLote.save(tipoLote);
			if (tipoLote.getId()!=null && tipoLote.getId()>0) {
				mapa.put("exito", 1);
				mapa.put("idTipoLote", tipoLote.getId());
			} 
		} else {
			mapa.put("exito", 0);
		}
		return mapa;
		
	}
	
	@RequestMapping(value="/buscar",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<TipoLote> buscar() {	
		return daoTipoLote.findAll();
	}
	
	@RequestMapping(value="/buscar/{id}",produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody TipoLote buscarUno(@PathVariable int id) {	
		return daoTipoLote.findOne(id);
	}
	
	@RequestMapping(value="/eliminar/{id}",produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Map eliminar(@PathVariable int id) {	
		Map mapa = new HashMap<String,Object>();

		try { 
			daoTipoLote.delete(id);
			mapa.put("exito", 1);
		} catch(Exception e) {
			mapa.put("exito", 0);
		}

		return mapa;
	}

}
