class Solution {
    public boolean isPalindrome(int x) {
        
        int ori=x;
        int rev=0;

        while (x>0){
            rev=x%10 + rev*10;
            x/=10;    
        }
        if(rev==ori)
        return true;
    
    return false;}
}