package com.ideagen.solutions.calculator.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import com.ideagen.solution.calculator.Calculator;
import com.ideagen.solution.calculator.exceptions.CalculatorException;
import com.ideagen.solution.calculator.objects.Token;
import com.ideagen.solution.calculator.objects.TokenSeperatorObject;
import com.ideagen.solution.calculator.service.CalculatorService;
import com.ideagen.solution.calcutor.service.impl.CalculatorServiceImpl;

import junit.framework.Assert;

public class CalculatorServiceImplTest {
	CalculatorService calculatorService;

	@Before
	public void init() {
		calculatorService = new CalculatorServiceImpl();
	}
	
	
	@Test
	public void testTokenSeperator() throws CalculatorException{
		TokenSeperatorObject tokenSeperatorObject = calculatorService.tokenSeperator("1+1");
		List<Token> tokenList = tokenSeperatorObject.getTokenList();
		List<Character> characterList = tokenSeperatorObject.getCharacterList();
		Token tokenAssert1 =tokenList.get(0);
		Token tokenAssert2 =tokenList.get(1);
		Assert.assertEquals(tokenAssert1.getExpression(), "1");
		Assert.assertEquals(tokenAssert1.getId(), 0);
		Assert.assertEquals(tokenAssert1.getParentId(), -1);
		
		Assert.assertEquals(tokenAssert2.getExpression(), "1");
		Assert.assertEquals(tokenAssert2.getId(), 1);
		Assert.assertEquals(tokenAssert2.getParentId(), -1);
		
		Assert.assertEquals((char)characterList.get(0), '+');
	}
	
	@Test
	public void testExpressionInnerMost() throws CalculatorException {
		List<Token> tokenList = new ArrayList<Token>();
		Token tokenAssert1 = new Token();
		tokenAssert1.setExpression("1");
		tokenAssert1.setId(0);
		tokenAssert1.setParentId(-1);
		
		Token tokenAssert2 = new Token();
		tokenAssert2.setExpression("1");
		tokenAssert2.setId(1);
		tokenAssert2.setParentId(-1);
		
		tokenList.add(tokenAssert1);
		tokenList.add(tokenAssert2);
		
		List<Token> tokens = calculatorService.expressionInnerMostProcessing(tokenList);
		Token tokenAsserts1 =tokens.get(0);
		Token tokenAsserts2 =tokens.get(1);
		Assert.assertEquals(tokenAsserts1.getExpression(), "1.0");
		Assert.assertEquals(tokenAsserts1.getId(), 0);
		Assert.assertEquals(tokenAsserts1.getParentId(), -1);
		
		Assert.assertEquals(tokenAsserts2.getExpression(), "1.0");
		Assert.assertEquals(tokenAsserts2.getId(), 1);
		Assert.assertEquals(tokenAsserts2.getParentId(), -1);
	}
	
	@Test
	public void testExpressionOuterMostProcessing()  throws CalculatorException{
		List<Token> tokenList = new ArrayList<Token>();
		Token tokenAssert1 = new Token();
		tokenAssert1.setExpression("1.0");
		tokenAssert1.setId(0);
		tokenAssert1.setParentId(-1);
		
		Token tokenAssert2 = new Token();
		tokenAssert2.setExpression("1.0");
		tokenAssert2.setId(1);
		tokenAssert2.setParentId(-1);
		tokenList.add(tokenAssert1);
		tokenList.add(tokenAssert2);
		
		List<Double> doubles = calculatorService.expressionOuterMostProcessing(tokenList);
		Assert.assertEquals(doubles.get(0), 1.0);
		Assert.assertEquals(doubles.get(1), 1.0);
	}
	
	@Test
	public void testProcessList() throws CalculatorException {
		List<Double> doubleList = new ArrayList<Double>();
		doubleList.add(1.0);
		doubleList.add(1.0);
		
		List<Character> characterList = new ArrayList<Character>();
		characterList.add('+');
		Assert.assertEquals(calculatorService.processList(doubleList, characterList), 2.0);
	}

}
