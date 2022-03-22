package u10pp;

public class RecursivePalindromeChecker{

    public static boolean isPalindrome(String s){
        int length = s.length();
        if(length == 0 || length == 1){
            return true;
        }
        else if(s.substring(0,1).equals(s.substring(length - 1))){
            return true && isPalindrome(s.substring(1, length - 1));
        }else return false;
    }

}