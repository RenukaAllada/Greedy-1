// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Sample{
    /*********************PROBLEM-1*****************/
    //BFS
    //TC:0(n)
//SC:0(n)
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums==null || nums.length==0 || nums.length==1){
                return true;
            }
            Queue<Integer> queue=new LinkedList<>();
            queue.add(0);
            int size=0;
            HashSet<Integer> seen=new HashSet();
            seen.add(0);
            while(!queue.isEmpty()){
                int value=queue.poll();
                for(int i=1;i<=nums[value];i++){
                    if(i+value==nums.length-1){
                        return true;
                    }
                    if(!seen.contains(i+value)){
                        seen.add(i+value);
                        queue.add(i+value);
                    }
                }
            }
            return false;
        }
    }
//DFS
    //TC:0(n)
//SC:0(n)
    class Solution {
        HashSet<Integer> visited;
        public boolean canJump(int[] nums) {
            if(nums==null || nums.length==0 || nums.length==1){
                return true;
            }
            visited=new HashSet<>();
            return dfs(nums,0);
        }
        private boolean dfs(int[] nums,int index){
            //base
            if(index==nums.length-1){
                return true;
            }
            if(visited.contains(index)){
                return false;
            }
            visited.add(index);
            //logic
            for(int i=1;i<=nums[index];i++){
                int child=i+index;
                if(dfs(nums,child)){
                    return true;
                }
            }
            return false;
        }
    }

    //TC:0(n)
//SC:0(1)
    class Solution {

        public boolean canJump(int[] nums) {
            if(nums==null || nums.length==0 || nums.length==1){
                return true;
            }
            int n=nums.length;
            int destination=n-1;
            for(int i=n-2;i>=0;i--){
                if(i+nums[i]>=destination){
                    destination=i;
                }
            }
            return destination==0;
        }

    }

    /*********************PROBLEM-2*****************/
    /*********************PROBLEM-3****************/
    //tc:0(n)
//sc:0(n)
    class Solution {
        public int candy(int[] ratings) {
            if(ratings==null || ratings.length==0){
                return 0;
            }
            int n=ratings.length;
            int[] candies=new int[n];
            Arrays.fill(candies,1);
            for(int i=1;i<n;i++){
                if(ratings[i]>ratings[i-1]){
                    candies[i]=candies[i-1]+1;
                }
            }
            int sum=candies[n-1];
            for(int i=n-2;i>=0;i--){
                if(ratings[i]>ratings[i+1]){
                    candies[i]=Math.max(candies[i],candies[i+1]+1);
                }
                sum+=candies[i];
            }
            return sum;
        }
    }
}
