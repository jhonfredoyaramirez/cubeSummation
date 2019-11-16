package com.cuboSummation.web.app.domain;

import java.io.Serializable;

public class Cube implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long x;

	private Long y;

	private Long z;

	private Long w;

	public Cube() {

	}
	
	public Cube(Long x, Long y, Long z, Long w) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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

	public Long getW() {
		return w;
	}

}
