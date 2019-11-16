package com.cuboSummation.web.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cubos")
public class CubeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long x;

	@NotNull
	private Long y;

	@NotNull
	private Long z;

	@NotNull
	private Long w;

	public CubeEntity() {

	}

	public CubeEntity(Long x, Long y, Long z) {
       this.x = x;
       this.y = y;
       this.z = z;
       this.w = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getX() {
		return x;
	}

	public void setX(Long x) {
		this.x = x;
	}

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}

	public Long getZ() {
		return z;
	}

	public void setZ(Long z) {
		this.z = z;
	}

	public Long getW() {
		return w;
	}

	public void setW(Long w) {
		this.w = w;
	}
}
