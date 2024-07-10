public class 10-Jul {
    public int minOperations(String[] logs) {
        Stack stack = new Stack<String>();
       for(String log : logs){
           if(log.equals("../")){
               if(!stack.empty())
                   stack.pop();
           }else if(!log.equals("./")){
               stack.push(log);
           }
       }
       return stack.size();
   }
}
