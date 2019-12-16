class Solution {

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0);
    }

    private List<String> generateParenthesis(int open, int close) {

        if (open == 0) {
            char[] chars = new char[close];
            Arrays.fill(chars, ')');
            return Arrays.asList(new String(chars));
        }

        //open > 0
        List<String> results = new ArrayList<String>();

        String use = "(";
        List<String> rUsedOpens = generateParenthesis(open - 1, close + 1);
        for (String rUsedOpen: rUsedOpens) {
            results.add(use + rUsedOpen);
        }

        if (close > 0) {
            used = ")";
            List<String> rUsedCloses =  generateParenthesis(open, close - 1);
            for (String rUsedClose: rUsedCloses) {
                results.add(used + rUsedClose);
            }
        }

        return results;
    }
}

