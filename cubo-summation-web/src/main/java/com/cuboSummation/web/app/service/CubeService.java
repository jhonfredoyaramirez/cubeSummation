package com.cuboSummation.web.app.service;

import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.domain.SumCube;

public interface CubeService {
	
	public void createCube(Long sizeCube);

	public Long SumPositionCube(SumCube cube);

	public void UpdateValuePositionCube(Cube cube);

}
