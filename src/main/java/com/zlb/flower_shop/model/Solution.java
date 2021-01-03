package com.zlb.flower_shop.model;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k=(nums1.length+nums2.length+1)/2;
        boolean fag = true;
        if((nums1.length+nums2.length)%2==0){
            fag=false;
            k++;
        }
        int l1=0,l2=0;
        double ans=0;
        while(k-->0) {
            if((k==0&&fag)||(!fag&&(k==0||k==1))){
                if(l1>=nums1.length)
                    ans+=nums2[l2];
                else
                    if(l2>=nums2.length)
                        ans+=nums1[l1];
                    else
                        if(nums1[l1]<nums2[l2])
                            ans+=nums1[l1];
                        else
                            ans+=nums2[l2];
            }
            if(l1>=nums1.length)
                l2++;
            else
                if(l2>=nums2.length)
                    l1++;
                else
                    if(nums1[l1]<nums2[l2])
                        l1++;
                    else
                        l2++;
        }
        if (fag)
            return ans;
        else
            return ans/2;
    }
}
