M
tags: Sort, Two Pointers

```
/*
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Example
GIven colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4]. 

Note
You are not suppose to use the library's sort function for this problem.

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory.

Can you do it without using extra memory?

Tags Expand 
Two Pointers Sort

Thoughts (Need to revist and think about this, very interesting)
Doing quick sort partition for K -1 times.
1. Use K - 1 value as pivot
2. Starting from 0, whenever low<high && less or equal to pivot, low++
3. starting from end, whenever high >0, and greater than pivot, high--
4. Result: only swap when low and high have disagreement on the pivot value.

*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0 || k <= 0) {
            return;
        }
        int end = colors.length - 1;
        for (int i = 0; i < k - 1; i++) {
            end = helper(colors, 0, end, k - i - 1);
        }
    }
    
    public void swap(int[] colors, int x, int y){
        int temp = colors[x];
        colors[x] = colors[y];
        colors[y] = temp;
    }
    
    public int helper(int[] colors, int start, int end, int pivot) {
        int low = start;
        int high = end;
        while (low <= high) {
            while(low < high && colors[low] <= pivot) {
                low++;
            }
            while(high > 0 && colors[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(colors, low, high);
                low++;
                high--;
            }
        }
        return low - 1;
    }
}


```