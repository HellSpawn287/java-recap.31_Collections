package set_And_HashSet.dynatrance;

class Solution {
    public void solution(int N) {
        // write your code in Java SE 8
        for (int i = 1; i < (N + 1); i++) {
            String s = getRepresentation(i);
            System.out.println(s);

        }
    }

    private String getRepresentation(int i) {
        StringBuilder builder = new StringBuilder();
        if (i % 2 == 0) {
            builder.append("Codility");
        }
        if (i % 3 == 0) {
            builder.append("Test");

        }
        if (i % 5 == 0) {
            builder.append("Coders");
        }
        if (builder.length() ==0){
            builder.append(i);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(30);
    }
}