package com.cuboSummation.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.domain.SumCube;
import com.cuboSummation.web.app.entity.CubeEntity;
import com.cuboSummation.web.app.repository.CubeRepository;

@Service
public class CubeServiceImpl implements CubeService {

	@Autowired
	private CubeRepository cubeRepository;
	
	public CubeServiceImpl() {
	}
	
	public CubeServiceImpl(CubeRepository cubeRepository) {
		this.cubeRepository = cubeRepository;
	}

	@Override
	@Transactional
	public void createCube(Long sizeCube) {
		deleteAllPositions();
		for (int i = 1; i <= sizeCube; i++) {

			for (int j = 1; j <= sizeCube; j++) {

				for (int k = 1; k <= sizeCube; k++) {

					CubeEntity cube = new CubeEntity(Long.valueOf(i), Long.valueOf(j), Long.valueOf(k));
					cubeRepository.save(cube);
				}
			}
		}

	}
	
	@Transactional
	public void deleteAllPositions() {
		cubeRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Long SumPositionCube(SumCube cube) {
		return cubeRepository.SumPositionCube(cube.getX(), cube.getY(), cube.getZ(), cube.getX2(), cube.getY2(),
				cube.getZ2());
	}

	@Override
	@Transactional
	public void UpdateValuePositionCube(Cube cube) {
		CubeEntity cubeEntity = cubeRepository.search(cube.getX(), cube.getY(), cube.getZ());
		if (cubeEntity != null) {
			cubeEntity.setW(cube.getW());
			cubeRepository.save(cubeEntity);
		}

	}

}
