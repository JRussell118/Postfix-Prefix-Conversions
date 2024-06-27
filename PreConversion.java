/*Jaden Russell
  Project 1
  3/24/23
  This program converts an expression in prefix format to postfix format.
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
public class PreConversion {

  static boolean isOperator(char ch){
      if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
          return true;
      }
      return false;
  }

  public String preCon(String prefix){
      Stack<String> s = new Stack<>();
      int len = prefix.length();

      for (int i = len - 1; i >= 0; i--){
          char ch = prefix.charAt(i);

          if (isOperator(ch)){
              String op1 = s.pop() + " ";
              String op2 = s.pop() + " ";
              String temp = op1 + op2 + ch;
              s.push(temp);
          }

          else if (ch != ' '){
              s.push(ch + "");
          }
      }
      return s.pop();
}
}
