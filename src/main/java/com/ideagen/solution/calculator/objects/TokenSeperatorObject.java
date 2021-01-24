package com.ideagen.solution.calculator.objects;

import java.util.ArrayList;
import java.util.List;

public class TokenSeperatorObject {
	List<Token> tokenList = new ArrayList<Token>();//Stores Numeric And bracketed Tokens
	List<Character> characterList = new ArrayList<Character>();
	
	public List<Token> getTokenList() {
		return tokenList;
	}
	public void setTokenList(List<Token> tokenList) {
		this.tokenList = tokenList;
	}
	public List<Character> getCharacterList() {
		return characterList;
	}
	public void setCharacterList(List<Character> characterList) {
		this.characterList = characterList;
	}
}
