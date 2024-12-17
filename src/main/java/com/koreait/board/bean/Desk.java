package com.koreait.board.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Desk {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	private String material;
	
	public Desk() {
		this.name = "Island";
		this.material = "Wood";
	}
}
