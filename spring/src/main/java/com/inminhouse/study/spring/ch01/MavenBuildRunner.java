package com.inminhouse.study.spring.ch01;

import java.util.List;

public class MavenBuildRunner implements BuildRunner {

	private String mavenPath;
	
	private static final String N = "\n";
	
	@Override
	public void build(List<String> srcDirs, String binDir) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("메이븐 경로: ").append(mavenPath).append(N);
		
		for(String srcDir : srcDirs) {
			builder.append("소스경로: ").append(srcDir).append(N);
		}
		
		builder.append("클래스파일 경로: ").append(binDir).append(N);
		System.out.println(builder.toString());
	}
	
	public void setMavenPath(String mavenPath) {
		this.mavenPath = mavenPath;
	}

}
