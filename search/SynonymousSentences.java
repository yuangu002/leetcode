package search;

import java.util.*;

/**
 * Example 1:
 * 
 * Input: synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]], text
 * = "I am happy today but was sad yesterday"
 * Output: ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 * 
 * Example 2:
 * 
 * Input: synonyms = [["happy","joy"],["cheerful","glad"]], text = "I am happy
 * today but was sad yesterday"
 * Output: ["I am happy today but was sad yesterday",
 * "I am joy today but was sad yesterday"]
 */
class SynonymousSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = buildGraph(synonyms);
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(text);
        visited.add(text);
        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            String curText = q.poll();
            ans.add(curText);

            String[] wordList = curText.split(" ");
            for (int i = 0; i < wordList.length; ++i) {
                String word = wordList[i];
                if (!graph.containsKey(word)) {
                    continue;
                }
                List<String> synList = graph.get(word);
                for (String synWord: synList) {
                    String[] newWordList = Arrays.copyOf(wordList, wordList.length);
                    newWordList[i] = synWord;
                    String newText = String.join(" ", newWordList);
                    if (visited.contains(newText)) {
                        continue;
                    }
                    q.offer(newText);
                    visited.add(newText);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    private Map<String, List<String>> buildGraph(List<List<String>> synonyms) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> synonym : synonyms) {
            String word1 = synonym.get(0);
            String word2 = synonym.get(1);
            List<String> synWord1 = graph.getOrDefault(word1, new ArrayList<>());
            List<String> synWord2 = graph.getOrDefault(word2, new ArrayList<>());

            synWord1.add(word2);
            synWord2.add(word1);
            graph.put(word1, synWord1);
            graph.put(word2, synWord2);
        }
        return graph;
    }
}
