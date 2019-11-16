package com.cuboSummation.web.app.testDataBuilder;

import com.cuboSummation.web.app.domain.SumCube;

public class SumCubeTestDataBuilder {
	
	private static final Long X_1 = 1L;
	private static final Long Y_1 = 1L;
	private static final Long Z_1 = 1L;
	private static final Long X_2 = 4L;
	private static final Long Y_2 = 4L;
	private static final Long Z_2 = 1L;
	
	private Long x;

	private Long y;

	private Long z;

	private Long x2;

	private Long y2;

	private Long z2;
	
	public SumCubeTestDataBuilder() {
		this.x = X_1;
		this.y = Y_1;
		this.z = Z_1;
		this.x2 = X_2;
		this.y2 = Y_2;
		this.z2 = Z_2;
	}
	
	public SumCube build() {
		return new SumCube(x,y,z,x2,y2,z2);
	}

}
