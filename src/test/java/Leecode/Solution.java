package Leecode;

import java.util.HashMap;
import java.util.Map;

/*给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int [] a = new int[2];
        for(int i = 0;i < nums.length;i++)
        {
            map.put(target-nums[i],i);
        }

        for(int i = 0;i < nums.length;i++)
        {
            //可能存在一个数x,满足x*2=target，i!=map.get(nums[i])可以避免
            if(map.containsKey(nums[i]) == true && i != map.get(nums[i]))
            {
                a[0]=i < map.get(nums[i])?i:map.get(nums[i]);
                a[1]=i > map.get(nums[i])?i:map.get(nums[i]);
                break;
            }
        }
        return a;

    }

    public void main(String args[]){

    }
}
