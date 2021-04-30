package com.inminhouse.study.spring.ch07;

import javax.validation.Valid;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	private MessageSourceAccessor msa;
	
	public void setMsa(MessageSourceAccessor msa) {
		this.msa = msa;
	}

	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("greeting", "안녕하세요");
		return "hello";
	}

	@RequestMapping("/index")
	/*
	 * RequestMapping 애너테이션이 적용된 메소드에 파라미터로 객체를 추가하면
	 * 스프링MVC는 그 객체의 set 메소드를 이용하여 요청 파라미터 값을 전달한다.
	 * 이 객체를 커맨드 객체라고 부른다.
	 * 커맨드 객체는 객체 클래스명의 앞글자만 소문자로 변환되어 뷰에 전달할 모델에 자동으로 추가된다. 
	 * 예) TestCommandObject 는 testCommandObject
	 */
	public String index(User user, BindingResult bindingResult /* 반드시 커맨드 객체 바로 와야 한다 */) {
		new UserValidator().validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			for(ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error + ":" + error.getCode());
			}
			return "error";
		}
		return "index";
	}
	
	@RequestMapping("/index2")
	public String index2(@Valid NewUser user, Errors errors) {
		System.out.println(msa.getMessage("NotEmpty.newUser.email"));
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				System.out.println(error);
			}
			return "error";
		}
		return "index";
	}
	
	@RequestMapping("/index3")
	public String index3() {

		return "index";
	}
}
