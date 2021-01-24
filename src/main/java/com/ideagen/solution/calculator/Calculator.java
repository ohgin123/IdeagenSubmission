package com.ideagen.solution.calculator;

import java.util.List;

import org.apache.log4j.Logger;

import com.ideagen.solution.calculator.exceptions.CalculatorException;
import com.ideagen.solution.calculator.objects.Token;
import com.ideagen.solution.calculator.objects.TokenSeperatorObject;
import com.ideagen.solution.calculator.service.CalculatorService;
import com.ideagen.solution.calcutor.service.impl.CalculatorServiceImpl;

public class Calculator {
	static Logger logger = Logger.getLogger("ERRORLOG");
	private static CalculatorService calculatorService = new CalculatorServiceImpl();

	public static void main(String[] args) {
		System.out.println(calculate("(23 - 16.8 + (10+5 + (11 + 6)) + 17 + (1+2)) + (3+4 * 4) * 6 + (11/ 11) / 7"));//172.34285714285713	
		System.out.println(calculate("23 - 16.8"));
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate("2 * 2"));
		System.out.println(calculate("1 + 2 + 3"));
		System.out.println(calculate("6/2"));
		System.out.println(calculate("11+23"));
		System.out.println(calculate("11.1 + 23"));
		System.out.println(calculate("1+1*3"));
		System.out.println(calculate("(11 + 11)  / (11 + 11) "));
		System.out.println(calculate("(11.5+15.4)+10.1"));
		System.out.println(calculate("23 - ( 29.3 - 12.5 )"));
		System.out.println(calculate("10 - ( 2 + 3 * ( 7 - 5 ) )"));
	}

	public static double calculate(String expression) {
		List<Token> tokenList = null;
		List<Character> characterList = null;
		try {
			TokenSeperatorObject tokenSeperateObject = calculatorService.tokenSeperator(expression.replace(" ",""));
			tokenList = tokenSeperateObject.getTokenList();//Stores Numeric And bracketed Tokens
			characterList = tokenSeperateObject.getCharacterList();//Stores Operator tokens
		} catch (CalculatorException e) {
			logger.error("TokenSeperatorException", e);
			return 0.0;
		}
		try {
			tokenList = calculatorService.expressionInnerMostProcessing(tokenList);
		} catch (CalculatorException e) {
			logger.error("expressionInnerMostProcessing", e);
			return 0.0;
		}
		List<Double> doubleList = null;
		try {
			doubleList = calculatorService.expressionOuterMostProcessing(tokenList);
		} catch (CalculatorException e) {
			logger.error("expressionOuterMostProcessing", e);
			return 0.0;
		}
		Double returnDouble = 0.0;
		try {
			returnDouble = calculatorService.processList(doubleList,characterList);
		}catch (CalculatorException e) {
			logger.error("processList", e);
			return 0.0;
		}
		returnDouble = Math.round(returnDouble * 100.0) / 100.0;
		return returnDouble;
	}
	

}
