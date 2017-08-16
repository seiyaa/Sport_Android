package me.moreshare.wordmap.model.entity;


import me.moreshare.wordmap.model.News;

import java.util.List;

public class NewsResult {
	private int code;
	private List<News> data;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<News> getData() {
		return data;
	}
	public void setData(List<News> data) {
		this.data = data;
	}
}
