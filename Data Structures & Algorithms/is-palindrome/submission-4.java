class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (true) {
            while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (end > 0 && !Character.isLetterOrDigit(s.charAt(end))) end--; 

            if (start > end) {
                break;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }
            
        return true;
    }

}
