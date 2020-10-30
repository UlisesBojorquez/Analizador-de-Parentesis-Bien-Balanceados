/*
Autor: Ulises Bojorquez Ortiz
Matricula: A01114716
Materia: Matematicas Computacionales
Programa: Validacion de parentesis, corchetes y llaves (Parentesis bien balanceados)
*/

import java.util.Stack;

public class Parentesis {
	
	private Stack<String> pila = new Stack<>();
	private char[] brackets;
	
	public void ordenamiento(String expresion) {
		this.brackets=expresion.toCharArray();
		System.out.print("El patron de brackets es el siguiente: ");
		for(int i=0;i<this.brackets.length;i++) {
			System.out.print(brackets[i]+"");
		}
		System.out.println();
	}
	
	public void resolver(String expresion) {
		
		boolean resultado,
				flag=true;
		
		ordenamiento(expresion);
		
		for(int i=0;i<this.brackets.length;i++) {
			if(this.brackets[i]=='(') {
				this.pila.push("(");
			}else if(this.brackets[i]=='['){
				this.pila.push("[");
			}else if(this.brackets[i]=='{'){
				this.pila.push("{");
			}else {
				if(this.brackets[i]==')' && !this.pila.isEmpty() && this.pila.peek()=="(") {
					this.pila.pop();
				}else if(this.brackets[i]==']' && !this.pila.isEmpty() && this.pila.peek()=="["){
					this.pila.pop();
				}else if(this.brackets[i]=='}' && !this.pila.isEmpty() && this.pila.peek()=="{"){
					this.pila.pop();
				}else {
					resultado= false;
					flag=false;
					break;
				}	
			}	
		}
		
		if(this.pila.isEmpty() && flag) {
			resultado=true;
		}else {
			resultado=false;
			
		}
		
		this.pila.clear(); //hay que limpiar la pila
		
		if(resultado==true) {
			System.out.println("Los parentesis están bien balanceados");
		}else {
			System.out.println("Los parentesis NO están bien balanceados");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Parentesis parentesis= new Parentesis();
		
		//Pruebas
		parentesis.resolver("[}");
		parentesis.resolver("[()({)(})]");
		parentesis.resolver("{([][]({()})[])}");
		parentesis.resolver("({}){{({((([])))})}}()(){({})}()");
		parentesis.resolver("{{[({})}}}");	
		parentesis.resolver("{()[()]}");	
		parentesis.resolver(")))");
		parentesis.resolver("]]]");
		parentesis.resolver("}}}");
		parentesis.resolver("}}}");
		parentesis.resolver("({[(){([])}()]})");
		
	}
}
