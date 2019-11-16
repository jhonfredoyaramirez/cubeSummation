package com.cuboSummation.web.app.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.domain.SumCube;
import com.cuboSummation.web.app.service.CubeService;

@RestController
@RequestMapping("/cube")
@CrossOrigin(origins = "*")
public class CubeController {
	
	@Autowired
	private CubeService cubeService;
	
	public CubeController() {
	
	}
	public CubeController(CubeService cubeService) {
		this.cubeService = cubeService;
	}
	
	@PostMapping("/create/{sizeCube}")
	public ResponseEntity<?> createCube(@PathVariable Long sizeCube) {
		Map<String, Object> response = new HashMap<>();
		try {
			cubeService.createCube(sizeCube);
		} catch (Exception e) {
			response.put("message", "Error creando el cubo");
			response.put("error", e.getMessage().concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "se creo correctamente el cubo");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/sumPositions")
	public ResponseEntity<?> SumPositionCube(@RequestBody SumCube cube) {
		Map<String, Object> response = new HashMap<>();
		Long suma = null;
		try {
		    suma = cubeService.SumPositionCube(cube);
		} catch (Exception e) {
			response.put("message", "Error calculando la suma de las posiciones");
			response.put("error", e.getMessage().concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("sum", suma);
		response.put("message", "se calculo correctamente la suma de las posiciones: ");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	   
	}
	
	@PostMapping("/updatePosition")
	public ResponseEntity<?> UpdateValuePositionCube(@RequestBody Cube cube) {
		Map<String, Object> response = new HashMap<>();
		try {
			cubeService.UpdateValuePositionCube(cube);
		} catch (Exception e) {
			response.put("message", "Error actualizando una posicion del cubo");
			response.put("error", e.getMessage().concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "se actualizo correctamente la posicion del cubo");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
      
	}
}
