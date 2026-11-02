class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();
        for (String str : strs) {
            strBuilder.append(str.length());
            strBuilder.append("#");
            strBuilder.append(str);
        }

        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int index = 0;

        while (index < str.length()) {
            int number = 0;

            int lengthNumber = 0;
            while (str.charAt(index) != '#') {
            number = number*10 + (str.charAt(index) - '0');
            index++;
            }

            index++;
            String strCondicate = str.substring(index, index + number);
            list.add(strCondicate);
            index = index + number;

        }

        return list;
    }

}
