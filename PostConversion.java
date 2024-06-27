/*Jaden Russell
  Project 1
  3/24/23
  This program converts an expression in postfix format to prefix format.
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1_jaden_russell;
import java.util.Stack;
/**
 *
 * @author jaden
 */
public class PostConversion {

    static boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }
 
    public String postCon(String postfix){
        Stack<String> s = new Stack<>();
        int length = postfix.length();

        for (int i = 0; i < length; i++) {
            char ch = postfix.charAt(i);

            if (isOperator(ch)) {
                String op1 = s.pop() + " ";                
                String op2 = s.pop() + " ";
                String temp = ch + op2 + op1;
                s.push(temp + " ");
            }

            else if (ch != ' '){
                s.push(ch + "");
            }
        }
        return s.pop();
    }
}
