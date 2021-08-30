package com.springexample.ioc;

import java.lang.reflect.Constructor;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// 1. 다른 클래스와 메서드를 사용하는 방법 1 -> 참조변수와 인스턴스 생성에서 클래스 이름 직접 사용
//		MyServiceConsumer consumer1 = new MyServiceConsumer();
//		consumer1.doSomething();
		
		// 2. 다른 클래스와 메서드를 사용하는 방법 2 -> 참종에는 인터페이스 사용, 인스턴스 생성에는 클래스 사용
//		ServiceConsumer consumer2 = new MyServiceConsumer();
//		consumer2.doSomething();
		
		// 3. 다른 클래스와 메서드를 사용하는 방법 3 -> 참종에는 인터페이스 사용, 인스턴스 생성은 리플렉션 사용
//		try {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("생성할 클래스 이름 ( 예 : package.name.ClassName ) : ");
//			String className = scanner.nextLine();
//			Class claz = Class.forName(className); // Class.forName : 클래스 정보를 객체 만들기
//			Constructor<?> ctor = claz.getConstructor(null); // 클래스 정보 객체로부터 생성자 메서드 관리 객체 만들기
//			ServiceConsumer consumer3 = (ServiceConsumer)ctor.newInstance(); // 생성자 관리 객체로부터 인스턴스 만들기 ( new 대신 사용 )
//			consumer3.doSomething();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
		// 4. 다른 클래스와 메서드를 사용하는 방법 4 -> 스프링 IoC 컨테이너를 사용해서 객체 생성 및 사용
		GenericXmlApplicationContext appContext = new GenericXmlApplicationContext("app-context.xml"); // IoC 컨테이너 만들기
		
		ServiceConsumer serviceConsumer = appContext.getBean("serviceConsumer", ServiceConsumer.class); // id가 serviceConsumer인 클래스의 인스턴를 요청
		serviceConsumer.doSomething();
		
		serviceConsumer = appContext.getBean("serviceConsumer", ServiceConsumer.class); // id가 serviceConsumer인 클래스의 인스턴를 요청
		serviceConsumer.doSomething();
		
		appContext.close();
	}

}












