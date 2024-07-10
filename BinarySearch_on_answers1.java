/*
this code is for binary search problems in which we have to divide in subarrays with given constraints etc
*/

import java.util.*;
public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int G = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        
        System.out.println(func(n, G, a));
    }

    private static long func(int n, int G, long[] a) 
    {
        long low = 0;
        long high = 0;
        
        for (long weight : a) 
        {
            low = Math.max(low, weight); // Maximum weight of a single bag
            high += weight; // Sum of all weights
        }
        
        while (low <= high) 
        {
            long mid = low + (high - low) / 2;
            long g=canSplit(a,mid);
            if(g<=G)
                high = mid-1;
            else 
                low = mid + 1;
        }
        
        return low;
    }

    private static long canSplit(long[] a,long maxWeight) 
    {
        long groups = 1;
        long currentWeight = 0;

        for (long weight : a) 
        {
            if (currentWeight + weight > maxWeight) 
            {
                groups++;
                currentWeight = weight;
            } 
            else currentWeight+=weight;
        }
        return groups;
    }
}
