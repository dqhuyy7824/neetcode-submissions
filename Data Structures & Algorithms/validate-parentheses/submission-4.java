class Solution {
    public boolean isValid(String s) {
        char[] mark = new char[s.length()];
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!typeChar(c)) {
                mark[++index] = c;
            } else {
                if (index < 0) return false; 
                
                if(!done(mark[index], c)) return false;

                index--;
            }
        }

        return index == - 1;
    }

    public boolean typeChar(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    public boolean done(char start, char end) {
        return start == '(' && end == ')' ||
               start == '{' && end == '}' ||
               start == '[' && end == ']';
    }
}
