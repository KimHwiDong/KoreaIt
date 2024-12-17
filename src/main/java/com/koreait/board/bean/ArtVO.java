package com.koreait.board.bean;

import lombok.Data;

@Data
public class ArtVO {
	private String title;
	private String artist;
	private String desc;

	// Getter and Setter methods
	public void setTitle(String title) {
		this.title = title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
