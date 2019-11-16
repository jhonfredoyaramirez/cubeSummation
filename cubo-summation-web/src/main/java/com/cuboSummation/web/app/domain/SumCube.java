package com.cuboSummation.web.app.domain;

import java.io.Serializable;

public class SumCube implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long x;

	private Long y;

	private Long z;

	private Long x2;

	private Long y2;

	private Long z2;
	
	public SumCube() {
		
	}
	
	public SumCube(Long x, Long y, Long z, Long x2, Long y2, Long z2) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
	}

	public Long getX() {
		return x;
	}

	public Long getY() {
		return y;
	}

	public Long getZ() {
		return z;
	}

	public Long getX2() {
		return x2;
	}

	public Long getY2() {
		return y2;
	}

	public Long getZ2() {
		return z2;
	}

}
