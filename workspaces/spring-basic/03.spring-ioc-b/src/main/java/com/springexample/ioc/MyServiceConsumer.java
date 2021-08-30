package com.springexample.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceConsumer") // <bean id="serviceConsumer ...
public class MyServiceConsumer implements ServiceConsumer {
	
	private MessageService messageService; // 초기값은 null
	@Autowired @Qualifier("messageService") // <property name="messageService" ... 
	public void setMessageService(MessageService messageService) { // dependency injection의 통로 ( setter injection )
		this.messageService = messageService;
	}
	
	@Autowired 
	@Qualifier("timeService") // 필드에 직접 dependency injection
	private TimeService timeService;
	
	public void doSomething() {
		
		System.out.println("MyServiceConsumer.doSomething()");
		
		// MyMessageService 클래스를 사용해서 메서드 호출
//		MyMessageService messageService = new MyMessageService();
//		String message = messageService.getMessage();
//		System.out.println(message);

		// 스프링 IoC 컨테이를 통해 객체와 메서드 사용
//		GenericXmlApplicationContext appContext = new GenericXmlApplicationContext("app-context.xml"); // IoC 컨테이너 만들기
//		MessageService messageService = appContext.getBean("messageService", MessageService.class); // id가 messageService인 클래스의 인스턴를 요청
//		String message = messageService.getMessage();
//		System.out.println(message);
		
		// 주입된 객체 사용 ( 객체를 직접 만들거나 가져올 필요 없음 )
		String message = messageService.getMessage();
		System.out.println(message);
		
		//////////////////////////////
		
		// 1. MyTimeService timeService = new MyTimeService();
		// 2. MyTimeService timeService = appContext.getBean("timeService", TimeService.class);
		
		String timeString = timeService.getTimeString();
		System.out.println(timeString);
	}




}








