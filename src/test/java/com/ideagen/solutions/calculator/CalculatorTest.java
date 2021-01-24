package com.ideagen.solutions.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ideagen.solution.calculator.Calculator;


import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class CalculatorTest {

	
	@Test
	public void testCalculator() {
		Assert.assertEquals(Calculator.calculate("23 - 16.8"), 6.2);
		Assert.assertEquals(Calculator.calculate("(23 - 16.8 + (10+5 + (11 + 6)) + 17 + (1+2)) + (3+4 * 4) * 6 + (11/ 11) / 7"),172.34);
		Assert.assertEquals(Calculator.calculate("1 + 1"),2.0);
		Assert.assertEquals(Calculator.calculate("2 * 2"),4.0);
		Assert.assertEquals(Calculator.calculate("1 + 2 + 3"),6.0);
		Assert.assertEquals(Calculator.calculate("6/2"),3.0);
		Assert.assertEquals(Calculator.calculate("11+23"),34.0);
		Assert.assertEquals(Calculator.calculate("11.1 + 23"),34.1);
		Assert.assertEquals(Calculator.calculate("1+1*3"),4.0);
		Assert.assertEquals(Calculator.calculate("(11 + 11)   /   (11 + 11)  "),1.0);
		Assert.assertEquals(Calculator.calculate("(11.5+15.4)+10.1"),37.0);
		Assert.assertEquals(Calculator.calculate("23 - ( 29.3 - 12.5 )"),6.2);
		Assert.assertEquals(Calculator.calculate("10 - ( 2 + 3 * ( 7 - 5 ) )"),2.0);
	
	}

}
