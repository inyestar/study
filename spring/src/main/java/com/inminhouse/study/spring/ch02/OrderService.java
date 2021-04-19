package com.inminhouse.study.spring.ch02;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

	private ClientFactoryBean clientFactoryBean;
	
	/*
	 * Autowired에 의해 주입될 빈이 같은 타입으로 여러 개 존재할 경우 구분하는 방법
	 * Qualifier 태그나 애너테이션을 사용하여 한정자를 지정
	 * Qualifier 애너테이션은 메소드 혹은 파라미터에 사용 가능
	 */
	@Autowired
	// @Autowired(required=false)일 경우 등록할 빈이 존재하지 않아도 됨
	// @Qualifier("factory2") ClientFactoryBean 타입의 빈이 두 개이상일 경우
	// @Resource(name="clientFactoryBean") autowired는 타입을 기준으로 빈을 선택한다면 resource는 이름을 기준으로 선택
	// @Inject 사용을 위해서는 추가 jar 필요하며 autowired와 다르게 반드시 bean이 존재해야 함
	public void setClientFactoryBean(ClientFactoryBean clientFactoryBean) {
		this.clientFactoryBean = clientFactoryBean;
	}
	
	public void print() {
		System.out.printf("clientFactoryBean=%s%n", clientFactoryBean);
	}
}
