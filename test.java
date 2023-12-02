import java.util.List;

import search.LetterCombinations;

public class Test {

    public static void main(String[] args){
        LetterCombinations solution = new LetterCombinations();
        
        List<String> dfs = solution.letterCombinationsDFS("23");
        for (int i = 0; i < dfs.size(); i++) {
            System.out.println(dfs.get(i));
        }

        List<String> bfs = solution.letterCombinationsBFS("23");
        for (int i = 0; i < bfs.size(); i++) {
            System.out.println(bfs.get(i));
        }
    }
}