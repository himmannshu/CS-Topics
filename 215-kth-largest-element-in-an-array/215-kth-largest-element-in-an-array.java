class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        
        for(int i = 0; i<nums.length; i++){
            queue.offer(nums[i]);
        }
        
        while(k > 1){
            queue.poll();
            k--;
        }
        
        return (int)queue.poll();
    }
}