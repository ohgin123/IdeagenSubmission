package com.ideagen.solution.calculator.service;

import java.util.List;

import com.ideagen.solution.calculator.exceptions.CalculatorException;
import com.ideagen.solution.calculator.objects.Token;
import com.ideagen.solution.calculator.objects.TokenSeperatorObject;

public interface CalculatorService {
	
	public TokenSeperatorObject tokenSeperator(String expressions) throws CalculatorException;
	
	public List<Token> expressionInnerMostProcessing(List<Token> tokens)throws CalculatorException; 
	
	public List<Double> expressionOuterMostProcessing(List<Token> tokens)throws CalculatorException;
	
	public Double processList(List<Double> doubleList, List<Character> characterList)throws CalculatorException;
}
