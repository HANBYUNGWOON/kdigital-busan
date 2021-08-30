package com.springexample.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // app-context.xml 파일 처럼 bean 설정을 처리하는 클래스
@ComponentScan(basePackages = { "com.springexample.ioc" })
public class AppContext {

	@Bean // <bean id="serviceConsumer" class="...MyServiceConsumer">
	public ServiceConsumer serviceConsumer() {
		MyServiceConsumer c = new MyServiceConsumer(timeService());
		c.setMessageService(messageService());
		return c;
	}
	
	@Bean
	public TimeService timeService() {
		MyTimeService s = new MyTimeService();
		return s;
	}
	
	@Bean
	public MessageService messageService() {
		MyMessageService s = new MyMessageService();
		return s;
	}
	
}
