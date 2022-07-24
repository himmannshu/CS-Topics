class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        sum(ans, new ArrayList(), candidates, target, 0);
        
        return ans;
    }
    
    private void sum(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int index){
        
        if(target == 0){
            ans.add(new ArrayList(temp));
            return;
        }
        
        if(target < 0 || index >= candidates.length){
            return;
        }
        
        if(candidates[index] <= target){
            temp.add(candidates[index]);
            sum(ans, temp, candidates, target - candidates[index], index);
            temp.remove(temp.size() - 1);

        }
        sum(ans, temp, candidates, target, index + 1);
    }
}