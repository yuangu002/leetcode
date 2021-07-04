import java.util.List;

public class test {

    public static void main(String[] args){
        Permutations.Solution solution = new Permutations().new Solution();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = solution.permute(nums);
        for (int i = 0; i<res.size(); i++) {
            System.out.print(i+": ");
            for (int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j)+", ");
            }
        }
    }
}