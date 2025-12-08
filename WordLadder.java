class Solution {

    List<String> wordListG = new ArrayList<>();
    String endWordG = "";

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordListG = wordList;
        endWordG = endWord;

        HashSet<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int length = current.length;

            if (word.equals(endWordG)) {
                return length;
            }

            for (int i = 0; i < wordListG.size(); i++) {
                String next = wordListG.get(i);
                if (!visited.contains(next) && oneDiff(word, next)) {
                    visited.add(next);
                    queue.add(new Pair(next, length + 1));
                }
            }
        }

        return 0;
    }

    private boolean oneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    private static class Pair {
        String word;
        int length;
        Pair(String w, int l) {
            word = w;
            length = l;
        }
    }
}
