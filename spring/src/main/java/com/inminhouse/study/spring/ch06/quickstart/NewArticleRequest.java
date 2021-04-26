package com.inminhouse.study.spring.ch06.quickstart;

public class NewArticleRequest {

	private String writerName;
	private String title;
	private String content;
	
	public NewArticleRequest(String writerName, String title, String content) {
		this.writerName = writerName;
		this.title = title;
		this.content = content;
	}
	
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
