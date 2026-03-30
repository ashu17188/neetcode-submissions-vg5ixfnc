class Solution {
  public boolean isPalindrome(String s) {
    int l=0;
    int r = s.length()-1;

    while(l < r){

      while(l<r && !isAlpha(s.charAt(l))){
        l++;
      }
      while(r>l && !isAlpha(s.charAt(r))){
        r--;
      }

      char clLower= Character.toLowerCase(s.charAt(l));
      char crLower = Character.toLowerCase(s.charAt(r));
      if(clLower != crLower){
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  private boolean isAlpha(char c){
    return (c >='A' && c <= 'Z'
      || c>= 'a' && c<= 'z'
      || c>= '0' && c<= '9'
    );
  }
}
