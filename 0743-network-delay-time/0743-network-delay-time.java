class Solution {
    public int networkDelayTime(int[][] times,int n,int k) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] time:times){
            int u = time[0];
            int v= time[1];
            int d =time[2];
            
            graph[u].add(new int[]{v,d});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int currNode= curr[0];
            int currDist = curr[1];
            
            if(currDist > dist[currNode]) continue;
            
            for(int[] next: graph[currNode]){
                int nextNode = next[0];
                int nextDist= next[1];
                if(currDist + nextDist < dist[nextNode]){
                    dist[nextNode] = currDist + nextDist;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE ) return -1;
            answer = Math.max(answer, dist[i]);
        }
        return answer;
    }
}