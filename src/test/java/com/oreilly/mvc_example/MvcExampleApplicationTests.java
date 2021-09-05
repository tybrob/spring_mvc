package com.oreilly.mvc_example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.NumberFormat;

@SpringBootTest
class MvcExampleApplicationTests {

	@Autowired
	private ApplicationContext ctx;

	@Autowired @Qualifier("defaultCurrencyFormat")
	private NumberFormat nf;

	@Test
	public void defaultCurrency() {
		double amount = 12332.43;
		System.out.println(nf.format(amount));
	}

	@Test
	public void germanCurrency() {
		double amount = 12332.43;
		NumberFormat deutschNF =  ctx.getBean("germanCurrencyFormat",NumberFormat.class);

		System.out.println(deutschNF.format(amount));
	}

	@Test
	void contextLoads() {
		int count = ctx.getBeanDefinitionCount();
		System.out.println("There are " +count+ " beans in the application context");
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
