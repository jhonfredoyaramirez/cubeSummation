package com.cuboSummation.web.app.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.domain.SumCube;
import com.cuboSummation.web.app.entity.CubeEntity;
import com.cuboSummation.web.app.repository.CubeRepository;
import com.cuboSummation.web.app.service.CubeServiceImpl;
import com.cuboSummation.web.app.testDataBuilder.CubeTestDataBuilder;
import com.cuboSummation.web.app.testDataBuilder.SumCubeTestDataBuilder;

public class CubeServiceTest {
	
	private static CubeRepository cubeRepository;
	private static CubeServiceImpl cubeService;
	
	@BeforeAll
	public static void setUp() {
		cubeRepository = Mockito.mock(CubeRepository.class);
		cubeService = new CubeServiceImpl(cubeRepository);
	}
	
	@Test
	public void createCubeTest() {
		CubeEntity cubeEntity = new CubeTestDataBuilder().buildEntity();
		verify(cubeRepository, never()).save(cubeEntity);
		cubeService.createCube(4L);
	}
	
	@Test
	public void SumPositionCubeTest() {
		SumCube cube = new SumCubeTestDataBuilder().build();
		Long suma = 46L;
		Mockito.when(cubeRepository.SumPositionCube(cube.getX(), cube.getY(), cube.getZ(), cube.getX2(), cube.getY2(),
				cube.getZ2())).thenReturn(suma);
		
		Long resultado = cubeService.SumPositionCube(cube);
		
		 assertEquals(suma, resultado);
	}
	
	@Test
	public void UpdateValuePositionCubeTest() {
		Cube cube = new CubeTestDataBuilder().build();
		CubeEntity cubeEntity = new CubeTestDataBuilder().buildEntity();
		verify(cubeRepository, never()).save(cubeEntity);
		cubeService.UpdateValuePositionCube(cube);
	}

}
