package com.springexample.ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MyServiceConsumer implements ServiceConsumer {
	
	public void doSomething() {
		
		System.out.println("MyServiceConsumer.doSomething()");
		
		// MyMessageService 클래스를 사용해서 메서드 호출
//		MyMessageService messageService = new MyMessageService();
//		String message = messageService.getMessage();
//		System.out.println(message);

		// 스프링 IoC 컨테이를 통해 객체와 메서드 사용
		GenericXmlApplicationContext appContext = new GenericXmlApplicationContext("app-context.xml"); // IoC 컨테이너 만들기
		MessageService messageService = appContext.getBean("messageService", MessageService.class); // id가 messageService인 클래스의 인스턴를 요청
		String message = messageService.getMessage();
		System.out.println(message);
		
	}

}








