class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length==0) return false;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }
            else{
                map.put(val,1);
            }
        }
        Set<Integer> set=new HashSet<>(map.values());
        if(map.size()==set.size()) return true;
        return false;
    }
}