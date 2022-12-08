package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    public static boolean isBalanced(String str) {
      try {
        Stack<Character> st = new Stack<>();
      
        //parcours la chaine de caractère
        for(char ch : str.toCharArray()) {
          if(ch == '{' || ch == '(' || ch == '[') {
            //push the character if it's { or [ or (
            st.push(ch);
          } else {
            if(st.empty()) {
              return false;
            }
            
            char dernierParOuverant = st.pop();
            
            if(dernierParOuverant == '{' && ch != '}') {
              return false;
            } else if (dernierParOuverant == '(' && ch != ')') { // this for parentheses
              return false;
            } else if (dernierParOuverant == '[' && ch != ']') { // for square braces
              return false;
            }
          }
          
        }
        return st.size() == 0;
  
      }catch(Exception e){
        System.out.println("The value passe in parameter is probably null!");
        return false;
      }    
    }

}
