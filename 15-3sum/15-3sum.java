class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i<len; i++){
            // a = - b - c
            if(nums[i] > 0) break;
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                }else if(sum < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return new ArrayList(res);
    }
}