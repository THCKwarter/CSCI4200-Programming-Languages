/*
	Lexical Analyzer for Java Arithmetic Expressions
		 -- Matthew Johnston --
*/

//Global Declarations
//Imports
import java.util.*;
import java.io.*;

public class Lexer_MWJ{

	//Variables
	static int charClass;
	static ArrayList<Character> lexeme = new ArrayList<Character>();
	static ArrayList<Character> position = new ArrayList<Character>();
	static char nextChar;
	static int lexLen;
	static int token;
	static int nextToken;
	static String nextLine;
	static int arrayPosition = 0;
	static int lexemePosition = 0;

	//Character Classes
	static final int LETTER = 0;
	static final int DIGIT = 1;
	static final int UNKNOWN = 99;

	//Token Codes
	static final int INT_LIT = 10;
	static final int IDENT = 11;
	static final int ASSIGN_OP = 20;
	static final int ADD_OP = 21;
	static final int SUB_OP = 22;
	static final int MULT_OP = 23;
	static final int DIV_OP = 24;
	static final int LEFT_PAREN = 25;
	static final int RIGHT_PAREN = 26;
	static final int END_OF_FILE = 999;


	public static void main(String[] args) throws IOException{
		//Import file
		Scanner file = new Scanner(new File("input.txt"));

		//If file is empty, close, else put the file into an array
		if(!file.hasNextLine()){
			System.out.print("File was empty.");
		}else{
			while(file.hasNextLine()){
				nextLine = file.nextLine();
				for(int i = 0; i < nextLine.length(); i++){
					position.add(nextLine.charAt(i));
				}
			}
			getChar();
			do{
				lex();
			}while(nextToken != END_OF_FILE);
		}
	}

	//-------------------------------------------------------
	/*lookup - A Function to lookup operators and parentheses
	and to return the token*/
	static int lookup(){
		switch(nextChar){
			case '(':
				addChar();
				nextToken = LEFT_PAREN;
				break;
			case ')':
				addChar();
				nextToken = RIGHT_PAREN;
				break;
			case '+':
				addChar();
				nextToken = ADD_OP;
				break;
			case '-':
				addChar();
				nextToken = SUB_OP;
				break;
			case '*':
				addChar();
				nextToken = MULT_OP;
				break;
			case '/':
				addChar();
				nextToken = DIV_OP;
				break;
			case '=':
				addChar();
				nextToken = ASSIGN_OP;
				break;
			case ' ':
				getNonBlank();
				break;
			default:
				addChar();
				nextToken = END_OF_FILE;
				break;
		}
		return nextToken;
	}

	//-------------------------------------------------------
	//addChar - A function to add nextChar to lexeme
	static void addChar(){
		if(lexLen <= 98){
			lexeme.add(nextChar);
			//lexeme.set(lexLen, '0');
		}else{
			System.out.print("ERROR: Lexeme is too long.\n");
		}
	}

	//-------------------------------------------------------
	/*getChar - A function to get the next character of input
	and determine its character class*/
	static void getChar(){
		nextChar = position.get(arrayPosition);
		arrayPosition++;
		if(nextChar != END_OF_FILE){
			if(Character.isLetter(nextChar)){
				charClass = LETTER;
			}else if(Character.isDigit(nextChar)){
				charClass = DIGIT;
			}else{
				charClass = UNKNOWN;
			}
		}else{
			charClass = END_OF_FILE;
		}
	}

	//-------------------------------------------------------
	/*getNonBlank - A function to call getChar until it returns
	a non-whitespace character*/
	static void getNonBlank(){
		while(nextChar == ' '){
			getChar();
		}
	}

	//-------------------------------------------------------
	//lex - A simple lexical analyzer for arithmetic expressions
	static int lex(){
		lexLen = 0;
		getNonBlank();
		switch(charClass){
			//Parse identifiers
			case LETTER:
				addChar();
				getChar();
				while(charClass == LETTER || charClass == DIGIT){
					addChar();
					getChar();
				}
				nextToken = IDENT;
				break;
			//Parse integer literals
			case DIGIT:
				addChar();
				getChar();
				while(charClass == DIGIT){
					addChar();
					getChar();
				}
				nextToken = INT_LIT;
				break;
			//Parentheses and operators
			case UNKNOWN:
				lookup();
				getChar();
				break;
			//EOF
			case END_OF_FILE:
				nextToken = END_OF_FILE;
				lexeme.set(0,'E');
				lexeme.set(1,'O');
				lexeme.set(2,'F');
				lexeme.set(3,'0');
				break;
		}//End of switch
		System.out.print("Next token is: " + nextToken + ", Next lexeme is: " + lexeme.get(lexemePosition) + "\n");
		lexemePosition++;
		return nextToken;
	}
}