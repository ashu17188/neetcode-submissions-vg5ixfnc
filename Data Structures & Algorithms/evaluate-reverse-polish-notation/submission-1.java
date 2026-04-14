class Solution {
    public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for(String token: tokens){
      if(!token.equals("+") && !token.equals("*") && !token.equals("-") && !token.equals("/")){
        int val = Integer.parseInt(token);
        stack.push(val);
      }else{
        int b = stack.pop();
        int a = stack.pop();
        int val = evaluate(a, b, token);
        stack.push(val);
      }

    }
    return stack.pop();

  }

  private int evaluate(int a, int b, String operator){
    int val = 0;
    switch(operator){
      case "+":
        val = a + b;
        break;
      case "*":
        val = a *b ;
        break;
      case "-":
        val = a-b;
        break;
      case "/":
        val = a/b;
        break;
    }
    return val;
  }
}
