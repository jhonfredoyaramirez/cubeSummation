package com.cuboSummation.web.app.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.cuboSummation.web.app.controller.CubeController;
import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.domain.SumCube;
import com.cuboSummation.web.app.service.CubeService;
import com.cuboSummation.web.app.testDataBuilder.CubeTestDataBuilder;
import com.cuboSummation.web.app.testDataBuilder.SumCubeTestDataBuilder;

@SpringBootTest
public class CubeControllerTest {
	
	private static CubeService cubeService;
	private static CubeController cubeController;

	@BeforeAll
	public static void setUp() {
		cubeService = Mockito.mock(CubeService.class);
		cubeController = new CubeController(cubeService);
	}
	
	@Test
	public void createCubeTest() {
		verify(cubeService, never()).createCube(4L);
		cubeController.createCube(4L);
	}
	
	@SuppressWarnings({ "rawtypes"})
	@Test
	public void SumPositionCubeTest() {
		SumCube sumCube = new SumCubeTestDataBuilder().build();
		Long suma = 46L;
		Map<String, Object> response = new HashMap<>();
		response.put("sum", suma);
		response.put("message", "se calculo correctamente la suma de las posiciones: ");

		Mockito.when(cubeService.SumPositionCube(sumCube)).thenReturn(suma);
		
		ResponseEntity responseEntityResult = cubeController.SumPositionCube(sumCube);
		
	    assertEquals(response, responseEntityResult.getBody());
		
	}
	
	@Test
	public void UpdateValuePositionCubeTest() {
		Cube cube = new CubeTestDataBuilder().build();
		verify(cubeService, never()).UpdateValuePositionCube(cube);
		cubeController.UpdateValuePositionCube(cube);
	}

}
