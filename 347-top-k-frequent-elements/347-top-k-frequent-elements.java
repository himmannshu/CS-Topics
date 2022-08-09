class Solution {
   
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue(k, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            q.offer(e);
        }
        
        int[] ans = new int[k];
        int i = 0;
        while(i < k){
            Map.Entry<Integer, Integer> e = q.poll();
            ans[i++] = e.getKey();
        }
        
        return ans;
    }
}