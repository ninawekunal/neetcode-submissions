class Solution {

    public String encode(List<String> strs) {
        // Naive solution - using a non-ascii delimiter.
        StringBuilder encodedString = new StringBuilder();
        for (String str: strs) {
            encodedString.append(str + "-");
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        for (char strings: str.toCharArray()) {
            if (strings == '-') {
                result.add(string.toString());
                string.setLength(0);
            } else {
                string.append(strings);
            }
        }
        return result;
    }
}
