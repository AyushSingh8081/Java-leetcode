
class Solution {
    public String removeKdigits(String num, int k) {
        
        StringBuilder st = new StringBuilder();

        for (char digit : num.toCharArray()) {

            while (st.length() > 0 && k > 0 &&
                   st.charAt(st.length() - 1) > digit) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }

            st.append(digit);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }

        // Remove leading zeros
        int i = 0;
        while (i < st.length() && st.charAt(i) == '0') {
            i++;
        }

        String ans = st.substring(i);

        return ans.length() == 0 ? "0" : ans;
    }
}
