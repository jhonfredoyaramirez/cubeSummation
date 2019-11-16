package com.cuboSummation.web.app.testDataBuilder;

import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.entity.CubeEntity;

public class CubeTestDataBuilder {
	
	private static final Long X_1 = 1L;
	private static final Long Y_1 = 1L;
	private static final Long Z_1 = 1L;
	private static final Long W = 23L;
	
	private Long x;

	private Long y;

	private Long z;
	
	private Long w;
	
	public CubeTestDataBuilder() {
		this.x = X_1;
		this.y = Y_1;
		this.z = Z_1;
		this.w = W;
		
	}
	
	public Cube build() {
		return new Cube(x,y,z,w);
	}
	
	public CubeEntity buildEntity() {
		return new CubeEntity(x,y,z);
	}

}
