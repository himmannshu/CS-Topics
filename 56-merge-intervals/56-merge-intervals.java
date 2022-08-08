class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<int[]> ans = new ArrayList();
        
        int startIndex = 1;
        int endIndex = 0;
        while(startIndex < intervals.length){
            if(start[startIndex] <= end[startIndex - 1]){
                startIndex++;
            }else{
                ans.add(new int[]{start[endIndex], end[startIndex - 1]});
                endIndex = startIndex;
                startIndex++;
            }
        }
        
        ans.add(new int[]{start[endIndex], end[startIndex - 1]});
        
        int[][] retValue = new int[ans.size()][2];
        
        for(int i = 0; i<ans.size(); i++){
            retValue[i][0] = ans.get(i)[0];
            retValue[i][1] = ans.get(i)[1];
        }
        
        return retValue;
        
    }
}